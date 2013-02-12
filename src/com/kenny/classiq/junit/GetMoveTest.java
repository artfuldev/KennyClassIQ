package com.kenny.classiq.junit;

import org.junit.Test;

import com.kenny.classiq.definitions.Definitions;
import com.kenny.classiq.game.Game;
import com.kenny.classiq.game.Move;

public class GetMoveTest
{
	@Test
	public void test()
	{
		Game chessGame=new Game(Definitions.startPositionFEN);
		Move moveOne=new Move(chessGame.getGameBoard());
		moveOne.setMoveString("e2e4");
		chessGame.getCurrentPlayer().makeMove(moveOne);
		chessGame.getCurrentPlayer().getMove();
		moveOne=new Move(chessGame.getGameBoard());
		moveOne.setMoveString("f1a6");
		chessGame.getCurrentPlayer().makeMove(moveOne);
		chessGame.getCurrentPlayer().getMove();
	}
}
