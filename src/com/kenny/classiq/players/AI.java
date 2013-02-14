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
		ArrayList<Move> legalMoves=getLegalMoves(game.isWhiteToMove());
		//Calculate best move here
		int bestScore=(int)(Double.NEGATIVE_INFINITY);
		for(Move move:legalMoves)
		{
			makeMove(move);
			if(game.getGameBoard().getScore(game.isWhiteToMove())>=bestScore)
			{
				bestScore=game.getGameBoard().getScore(game.isWhiteToMove());
				bestMove=move;
				System.out.println("1\t"+bestScore+"\t0\t"+legalMoves.size()+"\t"+bestMove);
			}
			unMakeMove(move);
		}
		makeMove(bestMove);
		return bestMove;
	}
}