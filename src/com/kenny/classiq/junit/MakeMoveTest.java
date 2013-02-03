package com.kenny.classiq.junit;

import static org.junit.Assert.*;

import org.junit.Test;

import com.kenny.classiq.game.Game;
import com.kenny.classiq.game.Move;

public class MakeMoveTest 
{
	@Test
	public void test()
	{
		Game chessGame=new Game();
		Move moveToMake=new Move(chessGame.getGameBoard());
		moveToMake.setMoveString("e2d7");
		chessGame.showBoard();
		System.out.println();
		chessGame.getPlayerOne().makeMove(moveToMake);
		chessGame.showBoard();
		System.out.println();
		Move secondMoveToMake=new Move(chessGame.getGameBoard());
		secondMoveToMake.setMoveString("d7d8");
		chessGame.getPlayerTwo().makeMove(secondMoveToMake);
		chessGame.showBoard();
		System.out.println();
		chessGame.getPlayerTwo().unMakeMove(secondMoveToMake);
		chessGame.showBoard();
		System.out.println();
		chessGame.getPlayerOne().unMakeMove(moveToMake);
		chessGame.showBoard();
	}
}
