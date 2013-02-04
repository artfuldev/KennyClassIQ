package com.kenny.classiq.junit;

import org.junit.Test;

import com.kenny.classiq.game.Game;
import com.kenny.classiq.game.Move;

public class HalfMoveTest
{
	@Test
	public void test()
	{
		Game chessGame=new Game();
		Move moveOne=new Move(chessGame.getGameBoard());
		moveOne.setMoveString("g1f3");
		chessGame.getCurrentPlayer().makeMove(moveOne);
		System.out.println(chessGame.getHalfMoveClock());
		Move moveTwo=new Move(chessGame.getGameBoard());
		moveTwo.setMoveString("g8f6");
		chessGame.getCurrentPlayer().makeMove(moveTwo);
		System.out.println(chessGame.getHalfMoveClock());
		Move moveThree=new Move(chessGame.getGameBoard());
		moveThree.setMoveString("e2e4");
		chessGame.getCurrentPlayer().makeMove(moveThree);
		System.out.println(chessGame.getHalfMoveClock());
		chessGame.getCurrentPlayer().unMakeMove(moveThree);
		System.out.println(chessGame.getHalfMoveClock());
		chessGame.getCurrentPlayer().unMakeMove(moveTwo);
		System.out.println(chessGame.getHalfMoveClock());
		chessGame.getCurrentPlayer().unMakeMove(moveOne);
		System.out.println(chessGame.getHalfMoveClock());
	}
}
