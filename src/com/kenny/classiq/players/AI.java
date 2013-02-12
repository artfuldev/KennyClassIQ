package com.kenny.classiq.players;

import java.util.ArrayList;

import com.kenny.classiq.board.Square;
import com.kenny.classiq.game.Game;
import com.kenny.classiq.game.Move;

/**
 * The <code>AI</code> represents the <code>AI Player</code> which
 * calculates the best <code>Move</code> and returns it.
 * @author Kenshin Himura (Sudarsan Balaji)
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
		ArrayList<Move> allMoves=new ArrayList<Move>();
		ArrayList<Square> occupiedSquares;
		if(game.isWhiteToMove())
			occupiedSquares=game.getGameBoard().
				getWhiteOccupiedSquares();
		else
			occupiedSquares=game.getGameBoard().
				getBlackOccupiedSquares();
		while(!occupiedSquares.isEmpty())
		{
			if(occupiedSquares.get(0).getPiece().getMoves()!=null)
				allMoves.addAll(occupiedSquares.get(0).
						getPiece().getMoves());
			occupiedSquares.remove(0);
		}
		//Calculate best move here
		bestMove=allMoves.get(0);
		System.out.println("1\t0\t0\t0\t"+bestMove);
		makeMove(bestMove);
		return bestMove;
	}
}