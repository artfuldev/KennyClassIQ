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

import org.junit.Test;

import com.kenny.classiq.definitions.Definitions;
import com.kenny.classiq.game.Game;
import com.kenny.classiq.game.Move;

public class HalfMoveTest
{
	@Test
	public void test()
	{
		Game chessGame=new Game(Definitions.startPositionFEN);
		Move moveOne=new Move(chessGame.getGameBoard());
		moveOne.setMoveString("g1f3");
		chessGame.getCurrentPlayer().makeMove(moveOne);
		System.out.println(chessGame.getHalfMoveClock());
		Move moveTwo=new Move(chessGame.getGameBoard());
		moveTwo.setMoveString("g8f6");
		chessGame.getCurrentPlayer().makeMove(moveTwo);
		System.out.println(chessGame.getHalfMoveClock());
		Move moveThree=new Move(chessGame.getGameBoard());
		moveThree.setMoveString("e2e4");
		chessGame.getCurrentPlayer().makeMove(moveThree);
		System.out.println(chessGame.getHalfMoveClock());
		chessGame.getCurrentPlayer().unMakeMove(moveThree);
		System.out.println(chessGame.getHalfMoveClock());
		chessGame.getCurrentPlayer().unMakeMove(moveTwo);
		System.out.println(chessGame.getHalfMoveClock());
		chessGame.getCurrentPlayer().unMakeMove(moveOne);
		System.out.println(chessGame.getHalfMoveClock());
	}
}
