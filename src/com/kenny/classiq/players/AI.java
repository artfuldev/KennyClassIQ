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

import com.kenny.classiq.Main;
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
	private Move bestMove;
	private Move tempBestMove;
	private int nodes;
	private byte sd=3;
	private long startTime=0;
	private long elapsedTime=0;
	private long timeLimit=0;
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
		ArrayList<Move> legalMoves=getLegalMoves(game.isWhiteToMove());
		ArrayList<Integer> scores=new ArrayList<Integer>();
		//Calculate best move here
		int infinity=(int)(2*PieceValues.kingValue);
		int bestScore=-infinity;
		int currentScore=-infinity;
		byte depth;
		Move move=null;
		int i=0,nps=0;
		int tempBestScore=-infinity;
		for(depth=0;depth<sd;depth++)
		{
			elapsedTime=(System.nanoTime()-startTime)/1000000L;
			if(timeLimit>elapsedTime)
			{
				currentScore=-infinity;
				tempBestScore=-infinity;
				scores.clear();
				for(i=0;i<legalMoves.size();i++)
				{
					move=legalMoves.get(i);
					makeMove(move);
					currentScore=alphaBeta(game,depth,-infinity,infinity,
											game.isWhiteToMove());
					if(game.isWhiteToMove())
						currentScore*=-1;
					scores.add(-currentScore);
					if(currentScore==PieceValues.kingValue)
					{
						if(!Main.protocolType.matches("xboard"))
							System.out.println("info score mate 1");
						bestMove=move;
						unMakeMove(move);
						bestScore=currentScore;
						break;
					}
					if(currentScore>=tempBestScore)
					{
						tempBestScore=currentScore;
						tempBestMove=move;
					}
					unMakeMove(move);
					elapsedTime=(System.nanoTime()-startTime)/1000/1000;
					nps=(int)(nodes*1000/elapsedTime);
					if(Main.protocolType.matches("xboard"))
						System.out.println((depth+1)+"\t"+bestScore+"\t"+elapsedTime
								+"\t"+nodes+"\t"+bestMove);
					else
						System.out.println("info currmove "+move
								+" currmovenumber "+(i+1)+" depth "+(depth+1)
								+" seldepth "+sd+" pv "+tempBestMove
								+" score cp "+tempBestScore);
					if(timeLimit<(elapsedTime+30))
						break;
				}
				if(bestScore==PieceValues.kingValue)
					break;
				bestMove=tempBestMove;
				bestScore=tempBestScore;
				elapsedTime=(System.nanoTime()-startTime)/1000000L;
				nps=(int)(nodes*1000/elapsedTime);
				if(Main.protocolType.matches("xboard"))
					System.out.println((depth+1)+"\t"+bestScore+"\t"+elapsedTime
							+"\t"+nodes+"\t"+bestMove);
				else
					System.out.println("info nodes "+nodes+" pv "+bestMove
							+" score cp "+bestScore+" time "+elapsedTime
							+" nps "+nps);
				if(depth+1<sd)
					quickSort(scores,legalMoves);
				timeLimit-=elapsedTime;
			}
			else
				timeLimit+=(timeLimit-elapsedTime);
		}
		makeMove(bestMove);
		return bestMove;
	}
	private int alphaBeta(Game game, byte depth, int alpha, int beta, boolean white)
	{
		nodes++;
		ArrayList<Move> tempMoves=game.getCurrentPlayer().getLegalMoves(white);
		if((depth==0)||(tempMoves.isEmpty()))
			return game.getGameBoard().getScore(true);
		if(white)
		{
			for(Move move:tempMoves)
			{
				makeMove(move);
				alpha=Math.max(alpha,alphaBeta(game,(byte)(depth-1),alpha,beta,!white));
				unMakeMove(move);
				if(beta<=alpha)
					break;
			}
			return alpha;
		}
		else
		{
			for(Move move:tempMoves)
			{
				makeMove(move);
				beta=Math.min(beta,alphaBeta(game,(byte)(depth-1),alpha,beta,!white));
				unMakeMove(move);
				if(alpha>=beta)
					break;
			}
			return beta;
		}
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
}