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

public class EnPassantTest
{
	@Test
	public void test()
	{
		String newFEN="rnbqkbnr/pppp1ppp/4p3/4P3/8/8/PPPP1PPP/RNBQKBNR b KQkq - 0 2 ";
		Game chessGame=new Game(newFEN);
		chessGame.printStats();
		Move newMove=new Move(chessGame.getGameBoard());
		newMove.setMoveString("d7d5");
		chessGame.getCurrentPlayer().makeMove(newMove);
		chessGame.printStats();
		Move newMoveThree=new Move(chessGame.getGameBoard());
		newMoveThree.setMoveString("e5d6");
		chessGame.getCurrentPlayer().makeMove(newMoveThree);
		chessGame.printStats();
		chessGame.getCurrentPlayer().unMakeMove(newMoveThree);
		chessGame.printStats();
		newFEN="rnbqkbnr/1ppppp1p/8/8/p7/8/PPPPPPP1/RNBQKBNR w KQkq - 0 1 ";
		chessGame=new Game(newFEN);
		chessGame.printStats();
		newMove=new Move(chessGame.getGameBoard());
		newMove.setMoveString("b2b4");
		chessGame.getCurrentPlayer().makeMove(newMove);
		chessGame.printStats();
		newMoveThree=new Move(chessGame.getGameBoard());
		newMoveThree.setMoveString("a4b3");
		chessGame.getCurrentPlayer().makeMove(newMoveThree);
		chessGame.printStats();
		chessGame.getCurrentPlayer().unMakeMove(newMoveThree);
		chessGame.printStats();
		
//		chessGame.getPlayerTwo().getMove();
		
	}
}
