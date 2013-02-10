package com.kenny.classiq.junit;

import java.util.ArrayList;

import org.junit.Test;

import com.kenny.classiq.definitions.Definitions;
import com.kenny.classiq.game.Game;
import com.kenny.classiq.game.Move;

public class PawnMoveGenTest
{
	@Test
	public void test()
	{
		Game chessGame=new Game(Definitions.startPositionFEN);
		ArrayList<Move> pawnMovesA2,pawnMovesE2,pawnMovesD7,pawnMovesD3;
		pawnMovesA2=chessGame.getGameBoard().getSquare("a2").getPiece().getMoves();
		System.out.println(pawnMovesA2);
		Move blackMoveOne=new Move(chessGame.getGameBoard());
		blackMoveOne.setMoveString("e7d3");
		chessGame.getPlayerOne().makeMove(blackMoveOne);
		chessGame.showBoard();
		pawnMovesE2=chessGame.getGameBoard().getSquare("e2").getPiece().getMoves();
		pawnMovesD7=chessGame.getGameBoard().getSquare("d7").getPiece().getMoves();
		pawnMovesD3=chessGame.getGameBoard().getSquare("d3").getPiece().getMoves();
		System.out.println(pawnMovesE2);
		System.out.println(pawnMovesD7);
		System.out.println(pawnMovesD3);
	}
}
