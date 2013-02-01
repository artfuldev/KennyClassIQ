package com.kenny.classiq.junit;

import org.junit.Test;
import com.kenny.classiq.game.Game;

public class GameTest
{
	@Test
	public void test()
	{
		Game chessGame=new Game();
		chessGame.showBoard();
	}
}
