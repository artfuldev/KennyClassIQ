package com.kenny.classiq.junit;

import org.junit.Test;

import com.kenny.classiq.game.Game;

public class PromotionTest
{
	@Test
	public void test()
	{
		String newFEN="rnbqkbnr/pppPpppp/8/8/8/8/PPPPPPpP/RNBQKB1R w KQkq - 0 1";
		Game chessGame=new Game(newFEN);
		chessGame.showBoard();
		System.out.println(chessGame.getGameBoard().getSquare("g2").
				getPiece().getMoves());
		System.out.println(chessGame.getGameBoard().getSquare("g2").
				getPiece().getMoves().get(0).getMoveString());
		System.out.println(chessGame.getGameBoard().getSquare("d7").
				getPiece().getMoves());
		System.out.println(chessGame.getGameBoard().getSquare("d7").
				getPiece().getMoves().get(0).getMoveString());
	}
}
