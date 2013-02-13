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
