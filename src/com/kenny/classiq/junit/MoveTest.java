package com.kenny.classiq.junit;

import static org.junit.Assert.*;
import org.junit.Test;
import com.kenny.classiq.game.Game;
import com.kenny.classiq.game.Move;

public class MoveTest
{
	@Test
	public void test()
	{
		Game game=new Game();
		Move moveOne=new Move(game.getGameBoard());
		Move moveTwo=new Move(game.getGameBoard().getSquare("e2"),
				game.getGameBoard().getSquare("e4"));
		moveOne.setMoveString("e2e4");
		System.out.println(moveOne.getMoveString());
		System.out.println(moveTwo.getMoveString());
		assertEquals("Wow!",moveOne.toString(),moveTwo.toString());
	}
}
