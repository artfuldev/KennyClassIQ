package com.kenny.classiq.junit;

import static org.junit.Assert.*;

import org.junit.Test;

import com.kenny.classiq.definitions.Definitions;
import com.kenny.classiq.game.Game;
import com.kenny.classiq.game.Move;

public class MoveTest
{
	@Test
	public void test()
	{
		Game game=new Game(Definitions.startPositionFEN);
		Move moveOne=new Move(game.getGameBoard());
		Move moveTwo=new Move(game.getGameBoard().getSquare("e1"),
				game.getGameBoard().getSquare("g1"));
		moveOne.setMoveString("e1g1");
		System.out.println(moveOne.getMoveString());
		System.out.println(moveTwo.getMoveString());
		Move moveThree=new Move(game.getGameBoard());
		moveThree.setMoveString("g1e7");
		Move moveFour=new Move(game.getGameBoard());
		moveFour.setMoveString("e2e4");
		System.out.println(moveOne.getMoveString());
		System.out.println(moveTwo.getMoveString());
		System.out.println(moveThree.getMoveString());
		System.out.println(moveFour.getMoveString());
		System.out.println(moveOne+"\n"+moveTwo+"\n"+moveThree+"\n"+moveFour);
		assertEquals("Wow!",moveOne.toString(),moveTwo.toString());
	}
}
