package com.kenny.classiq.junit;

import org.junit.Test;

import com.kenny.classiq.definitions.Definitions;
import com.kenny.classiq.game.Game;

public class GameTest
{
	@Test
	public void test()
	{
		Game chessGame=new Game(Definitions.startPositionFEN);
		chessGame.showBoard();
	}
}
