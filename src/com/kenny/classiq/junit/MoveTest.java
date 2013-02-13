/*
 * This file is part of "Kenny ClassIQ", (c) Kenshin Himura, 2013.
 * 
 * "Kenny ClassIQ" is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * "Kenny ClassIQ" is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with "Kenny ClassIQ".  If not, see <http://www.gnu.org/licenses/>.
 * 
 */

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
