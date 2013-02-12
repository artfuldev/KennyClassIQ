package com.kenny.classiq.junit;

import static org.junit.Assert.*;

import org.junit.Test;

import com.kenny.classiq.definitions.Definitions;
import com.kenny.classiq.game.Game;
import com.kenny.classiq.game.Move;

public class QueenMoveGenTest
{
	@Test
	public void test()
	{
		Game chessGame=new Game(Definitions.startPositionFEN);
		Move moveToMake=new Move(chessGame.getGameBoard());
		moveToMake.setMoveString("e2e4");
		chessGame.getCurrentPlayer().makeMove(moveToMake);
		moveToMake=new Move(chessGame.getGameBoard());
		moveToMake.setMoveString("e7e5");
		chessGame.getCurrentPlayer().makeMove(moveToMake);
		moveToMake=new Move(chessGame.getGameBoard());
		moveToMake.setMoveString("g1f3");
		chessGame.getCurrentPlayer().makeMove(moveToMake);
		moveToMake=new Move(chessGame.getGameBoard());
		moveToMake.setMoveString("g8f6");
		chessGame.getCurrentPlayer().makeMove(moveToMake);
		moveToMake=new Move(chessGame.getGameBoard());
		moveToMake.setMoveString("f1c4");
		chessGame.getCurrentPlayer().makeMove(moveToMake);
		moveToMake=new Move(chessGame.getGameBoard());
		moveToMake.setMoveString("b8c6");
		chessGame.getCurrentPlayer().makeMove(moveToMake);
		moveToMake=new Move(chessGame.getGameBoard());
		moveToMake.setMoveString("f8e7");
		chessGame.getCurrentPlayer().makeMove(moveToMake);
		moveToMake=new Move(chessGame.getGameBoard());
		moveToMake.setMoveString("d7d5");
		chessGame.getCurrentPlayer().makeMove(moveToMake);
		chessGame.showBoard();
		System.out.println(chessGame.getMoveList());
		System.out.println(chessGame.getGameBoard().getSquare("d1").
				getPiece()+" moves:");
		System.out.println(chessGame.getGameBoard().getSquare("d1").
				getPiece().getMoves());
		System.out.println(chessGame.getGameBoard().getSquare("d8").
				getPiece()+" moves:");
		System.out.println(chessGame.getGameBoard().getSquare("d8").
				getPiece().getMoves());		
	}
}
