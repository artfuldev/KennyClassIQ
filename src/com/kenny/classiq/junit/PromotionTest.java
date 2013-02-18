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

import com.kenny.classiq.game.Game;
import com.kenny.classiq.game.Move;

public class PromotionTest
{
	@Test
	public void test()
	{
		String newFEN="rnb1kbnr/ppp1pppp/8/8/8/5Q2/PPpP1PPP/RNB2RK1 b kq - 0 7";
		Game chessGame=new Game(newFEN);
		chessGame.printStats();
		Move moveOne=new Move(chessGame.getGameBoard().getSquare("c2"),
				chessGame.getGameBoard().getSquare("b1"),"knight");
		chessGame.getPlayerTwo().makeMove(moveOne);
		chessGame.printStats();
		Move moveTwo=new Move(chessGame.getGameBoard().getSquare("a1"),
				chessGame.getGameBoard().getSquare("b1"));
		chessGame.getPlayerTwo().makeMove(moveTwo);
		chessGame.printStats();
		chessGame.getPlayerTwo().unMakeMove(moveTwo);
		chessGame.printStats();
		chessGame.getPlayerTwo().unMakeMove(moveOne);
		chessGame.printStats();
	}
}
