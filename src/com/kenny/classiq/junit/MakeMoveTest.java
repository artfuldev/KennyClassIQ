package com.kenny.classiq.junit;

import org.junit.Test;

import com.kenny.classiq.definitions.Definitions;
import com.kenny.classiq.game.Game;
import com.kenny.classiq.game.Move;

public class MakeMoveTest 
{
	@Test
	public void test()
	{
		Game chessGame=new Game(Definitions.startPositionFEN);
		System.out.println(chessGame.isWhiteCastleKingside());
		Move moveToMake=new Move(chessGame.getGameBoard());
		moveToMake.setMoveString("e1d7");
		chessGame.showBoard();
		System.out.println("Making move "+moveToMake.getMoveString());
		chessGame.getPlayerOne().makeMove(moveToMake);
		chessGame.showBoard();
		chessGame.printMainLine();
		System.out.println(chessGame.isWhiteCastleKingside());
		Move secondMoveToMake=new Move(chessGame.getGameBoard());
		secondMoveToMake.setMoveString("d7d8");
		System.out.println("Making move "+secondMoveToMake.getMoveString());
		chessGame.getPlayerTwo().makeMove(secondMoveToMake);
		chessGame.showBoard();
		chessGame.printMainLine();
		System.out.println("UnMaking move "+secondMoveToMake.getMoveString());
		chessGame.getPlayerTwo().unMakeMove(secondMoveToMake);
		chessGame.showBoard();
		chessGame.printMainLine();
		System.out.println(chessGame.isWhiteCastleKingside());
		System.out.println("UnMaking move "+moveToMake.getMoveString());
		chessGame.getPlayerOne().unMakeMove(moveToMake);
		chessGame.showBoard();
		chessGame.printMainLine();
		System.out.println(chessGame.isWhiteCastleKingside());
	}
}
