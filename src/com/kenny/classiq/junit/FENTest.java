package com.kenny.classiq.junit;

import static org.junit.Assert.*;

import org.junit.Test;

import com.kenny.classiq.definitions.Definitions;
import com.kenny.classiq.game.Game;

public class FENTest
{
	@Test
	public void test()
	{
		Game chessGame=new Game(Definitions.startPositionFEN);
		chessGame.showBoard();
		System.out.println();
		String newFen="rnbqkbnr/pp1ppppp/8/2p5/4P3/5N2/"
				+"PPPP1PPP/RNBQKB1R b KQkq - 1 2";
		Game chessGame2=new Game(newFen);
		chessGame2.showBoard();
		System.out.println();
		newFen="rnbqkbnr/pp1ppppp/8/8/8/8/PPP2PPP/RNBQKBNR w KQkq c6 0 2";
		Game chessGame3=new Game(newFen);
		chessGame3.showBoard();
		chessGame=new Game(Definitions.startPositionFEN);
		chessGame.setFen(newFen);
		chessGame.showBoard();
		assertEquals("Great!","c6",chessGame3.getEnPassantSquare().getName());
		assertEquals("Nice!",0,chessGame3.getHalfMoveClock(),0);
		assertEquals("Wow!",2,chessGame3.getMoveNumber(),0);
	}
}
