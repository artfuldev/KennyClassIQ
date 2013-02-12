package com.kenny.classiq.junit;

import org.junit.Test;

import com.kenny.classiq.definitions.Definitions;
import com.kenny.classiq.game.Game;
import com.kenny.classiq.game.Move;

public class RookMoveGenTest
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
		moveToMake.setMoveString("h7h5");
		chessGame.getCurrentPlayer().makeMove(moveToMake);
		chessGame.showBoard();
		System.out.println(chessGame.getMoveList());
		System.out.println(chessGame.getGameBoard().getSquare("h1").
				getPiece()+" moves:");
		System.out.println(chessGame.getGameBoard().getSquare("h1").
				getPiece().getMoves());
		System.out.println(chessGame.getGameBoard().getSquare("h8").
				getPiece()+" moves:");
		System.out.println(chessGame.getGameBoard().getSquare("h8").
				getPiece().getMoves());
	}
}
