package com.kenny.classiq.junit;

import org.junit.Test;

import com.kenny.classiq.definitions.Definitions;
import com.kenny.classiq.game.Game;
import com.kenny.classiq.game.Move;

public class OccupiedSquaresTest
{
	@Test
	public void test()
	{
		Game chessGame=new Game(Definitions.startPositionFEN);
		chessGame.showBoard();
		System.out.println(chessGame.getGameBoard().getOccupiedSquares());
		System.out.println(chessGame.getGameBoard().getWhiteOccupiedSquares());
		System.out.println(chessGame.getGameBoard().getBlackOccupiedSquares());
		Move moveOne=new Move(chessGame.getGameBoard());
		moveOne.setMoveString("e2e4");
		chessGame.getPlayerOne().makeMove(moveOne);
		System.out.println(chessGame.getGameBoard().getOccupiedSquares());
		System.out.println(chessGame.getGameBoard().getWhiteOccupiedSquares());
		System.out.println(chessGame.getGameBoard().getBlackOccupiedSquares());
	}
}
