/*
 * This file is part of "Kenny ClassIQ", (c) Kenshin Himura, 2013.
 * 
 * "Kenny ClassIQ" is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * "Kenny ClassIQ" is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with "Kenny ClassIQ".  If not, see <http://www.gnu.org/licenses/>.
 * 
 */

package com.kenny.classiq.players;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.kenny.classiq.definitions.PieceValues;
import com.kenny.classiq.game.Game;
import com.kenny.classiq.game.Move;

/**
 * The <code>AI</code> represents the <code>AI Player</code> which
 * calculates the best <code>Move</code> and returns it.
 * @author Kenshin Himura  
 */
public class AI extends Player
{
	private int nodes;
	private Move bestMove=null;
	private byte sd=2;
	private byte sdepth;
	private long startTime=0;
	private long elapsedTime=0;
	private long timeLimit=0;
	private int bestScore=0;
	private int nps;
	private ArrayList<Move> principalVariation;
	int infinity=(int)(2*PieceValues.kingValue);
	public AI(Game gameReference, String colour)
	{
		if(!colour.matches("white"))
			white=false;
		playerType="ai";
		game=gameReference;
	}
	/**
	 * Outputs move, moveNow(?) command not executed.
	 */
	public Move getMove()
	{
		nodes=0;
		startTime=System.nanoTime();
		timeLimit=(long)(Double.POSITIVE_INFINITY);
		//Calculate best move here
		bestScore=-infinity;
		for(sdepth=1;sdepth<=sd;sdepth++)
		{
			bestScore=-infinity;
			elapsedTime=(System.nanoTime()-startTime)/1000000L;
			if(timeLimit>(elapsedTime*sdepth))
			{
				principalVariation=new ArrayList<Move>(sdepth+1);
				bestScore=alphaBetaPVS((byte)(sdepth),-infinity,infinity,
							principalVariation);
				if((bestScore/PieceValues.kingValue)>0)
				{
					if(uci)
					{
						System.out.print("info score mate ");
						if(bestScore<0)
							System.out.print("-");
						System.out.println((sdepth));
					}
				}
				if(bestScore==PieceValues.kingValue)
					break;
				timeLimit-=elapsedTime;
			}
			else
				timeLimit+=(timeLimit-elapsedTime);
		}		
		makeMove(bestMove);
		return bestMove;
	}
	//------------------------------------------------------------------------------
	//This sort implementation idea taken from
	//http://stackoverflow.com/questions/4839915/sorting-a-list-based-on-another-
	//lists-values-java
	//Quicksort implementation taken from http://en.wikipedia.org/wiki/Quicksort
	//"In-Place Quicksort"
	//------------------------------------------------------------------------------
	private static void swap(List<?> l1, List<?> l2, byte i, byte j)
	{
		Collections.swap(l1, i, j);
		Collections.swap(l2, i, j);     
	}
	private static byte partition(List<Integer> comp, List<?> l2, byte left,
									byte right)
	{
		byte i=left, j=right, pivot=(byte)((i+j)/2), returnIndex;
		int pivotValue=comp.get(pivot);
		swap(comp,l2,pivot,right);
		returnIndex=left;
		for(;i<(right-1);i++)
			if(comp.get(i)<pivotValue)
			{
				swap(comp,l2,i,returnIndex);
				returnIndex++;
			}
		swap(comp,l2,returnIndex,right);
		return returnIndex;
	}
	private void quickSort(List<Integer> comp, List<?> l2, byte left, byte right)
	{
		byte index = partition(comp, l2, left, right);
		if(left<(index-1))
			quickSort(comp, l2, left,(byte)(index-1));
		if((index+1)<right)
			quickSort(comp, l2, (byte)(index+1), right);
	}
	public void quickSort(List<Integer> comp,
			List<?> l2)
	{
		quickSort(comp, l2,(byte)0,(byte)(comp.size()-1));
	}
	//-----------------
	//Sorting ends here
	//-----------------
	//alphaBetaPVS based on http://en.wikipedia.org/wiki/Negascout
	private int alphaBetaPVS(byte depth,int alpha,int beta,
			ArrayList<Move> localPV)
	{
		nodes++;
		ArrayList<Move> tempMoves=getLegalMoves();
		if(tempMoves.isEmpty())
			return game.getGameBoard().getScore(game.isWhiteToMove());
		else if(depth==0)
			return quiescenceSearch(alpha,beta);
		ArrayList<Move> localLine=new ArrayList<Move>();
	    for(Move move:tempMoves)
	    {
	       makeMove(move);
	       bestScore=-alphaBetaPVS((byte)(depth-1),-beta,-alpha,
	    			   localLine);
	       unMakeMove(move);
	       if(bestScore>=beta)
	    	   return beta;
	       else if(bestScore>alpha)
	       {
	    	   alpha=bestScore;
	    	   localPV.clear();
	    	   localPV.add(move);
	    	   localPV.addAll(localLine);
	    	   if(depth==sdepth)
	    	   {
	    		   elapsedTime=(System.nanoTime()-startTime)/1000/1000;
	    		   nps=(int)(nodes*1000/elapsedTime);
	    		   bestMove=localPV.get(0);
	    		   if(!uci)
	    			   System.out.println((sdepth+1)+"\t"+bestScore+"\t"
	    					   +elapsedTime+"\t"+nodes+"\t"+pv());
	    		   else
	    			   System.out.println("info depth "+(sdepth)+" seldepth "
	   							+sd+" pv "+pv()+"score cp "+bestScore+" nodes "+nodes
	   							+" time "+elapsedTime+" nps "+nps);
	    	   }
	       }
	    }
	    return alpha;
	}
	private String pv()
	{
		String returnString="";
		if(!principalVariation.isEmpty())
			for(Move move:principalVariation)
				returnString+=move.toString()+" ";
		return returnString;
	}
	private ArrayList<Move> getLegalMoves()
	{
		ArrayList<Move> returnList=getLegalMoves(game.isWhiteToMove());
		if(!returnList.isEmpty())
		{
			ArrayList<Integer> scores=new ArrayList<Integer>();
			for(Move move:returnList)
			{
				makeMove(move);
				scores.add(-game.getGameBoard().getMaterialScore(
						!game.isWhiteToMove()));
				unMakeMove(move);
			}
			quickSort(scores,returnList);
		}
		return returnList;
	}
	private ArrayList<Move> getGoodCaptures()
	{
		ArrayList<Move> returnList=getLegalMoves();
		int score=0;
		int oldScore=game.getGameBoard().getMaterialScore(game.isWhiteToMove());
		if(!returnList.isEmpty())
		{
			Move move;
			byte size=(byte)returnList.size();
			for(byte i=0;i<size;i++)
			{
				move=returnList.get(i);
				makeMove(move);
				score=game.getGameBoard().getMaterialScore(!game.isWhiteToMove());
				unMakeMove(move);
				if(!((score-oldScore)>PieceValues.bishopValue))
				{
					returnList.remove(i);
					i--;
					size--;
				}
			}
		}
		return returnList;
	}
	private int quiescenceSearch(int alpha, int beta)
	{
		nodes++;
		game.printStats();
		ArrayList<Move> tempMoves=getLegalMoves();
		if(game.getGameBoard().isChecked(game.isWhiteToMove()))
		{
			if(tempMoves.size()<3)
				return alphaBetaPVS((byte)(tempMoves.size()),alpha,beta);
		}
		int score=game.getGameBoard().getScore(game.isWhiteToMove());
	    if(score>=beta)
	    	return beta;
	    if(score>alpha)
	    	alpha=score;
	    tempMoves=getGoodCaptures();
	    if(!tempMoves.isEmpty())
	    	for(Move move:tempMoves)
	    	{
	    		makeMove(move);
	    		score=-quiescenceSearch(-beta,-alpha);
	    		unMakeMove(move);
	    		if(score>=beta)
	    			return beta;
	    		if(score>alpha)
	    			alpha=score;
	    	}
	    return alpha;
	}
	private int alphaBetaPVS(byte depth, int alpha, int beta)
	{
		nodes++;
		ArrayList<Move> tempMoves=getLegalMoves();
		if(tempMoves.isEmpty())
			return game.getGameBoard().getScore(game.isWhiteToMove());
		else if(depth==0)
			return quiescenceSearch(alpha,beta);
		ArrayList<Move> localLine=new ArrayList<Move>();
	    for(Move move:tempMoves)
	    {
	       makeMove(move);
	       bestScore=-alphaBetaPVS((byte)(depth-1),-beta,-alpha,
	    			   localLine);
	       unMakeMove(move);
	       if(bestScore>=beta)
	    	   return beta;
	       else if(bestScore>alpha)
	    	   alpha=bestScore;
	    }
	    return alpha;
	}
}