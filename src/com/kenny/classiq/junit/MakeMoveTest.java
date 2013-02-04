package com.kenny.classiq.junit;

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
		System.out.println("Making move "+moveToMake.getMoveString());
		chessGame.getPlayerOne().makeMove(moveToMake);
		chessGame.showBoard();
		chessGame.printMainLine();
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
		System.out.println("UnMaking move "+moveToMake.getMoveString());
		chessGame.getPlayerOne().unMakeMove(moveToMake);
		chessGame.showBoard();
		chessGame.printMainLine();
	}
}
