package com.kenny.classiq.junit;

import static org.junit.Assert.*;

import org.junit.Test;

import com.kenny.classiq.definitions.Definitions;
import com.kenny.classiq.game.Game;
import com.kenny.classiq.game.Move;

public class KnightMoveGenTest
{
	@Test
	public void test()
	{
		Game chessGame=new Game(Definitions.startPositionFEN);
		Move moveToMake=new Move(chessGame.getGameBoard());
		moveToMake.setMoveString("g1f3");
		chessGame.showBoard();
		System.out.println(chessGame.getGameBoard().getSquare("g1").
				getPiece()+" moves:");
		System.out.println(chessGame.getGameBoard().getSquare("g1").
				getPiece().getMoves());
		chessGame.getCurrentPlayer().makeMove(moveToMake);
		chessGame.showBoard();
		System.out.println(chessGame.getGameBoard().getSquare("f3").
				getPiece()+" moves:");
		System.out.println(chessGame.getGameBoard().getSquare("f3").
				getPiece().getMoves());
	}
}
