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

public class KingMoveGenTest
{
	@Test
	public void test()
	{
		Game chessGame=new Game(Definitions.startPositionFEN);
		Move moveToMake=new Move(chessGame.getGameBoard());
		moveToMake.setMoveString("e2e4");
		chessGame.getCurrentPlayer().makeMove(moveToMake);
		moveToMake=new Move(chessGame.getGameBoard());
		moveToMake.setMoveString("e7e5");
		chessGame.getCurrentPlayer().makeMove(moveToMake);
		moveToMake=new Move(chessGame.getGameBoard());
		moveToMake.setMoveString("g1f3");
		chessGame.getCurrentPlayer().makeMove(moveToMake);
		moveToMake=new Move(chessGame.getGameBoard());
		moveToMake.setMoveString("g8f6");
		chessGame.getCurrentPlayer().makeMove(moveToMake);
		moveToMake=new Move(chessGame.getGameBoard());
		moveToMake.setMoveString("f1c4");
		chessGame.getCurrentPlayer().makeMove(moveToMake);
		moveToMake=new Move(chessGame.getGameBoard());
		moveToMake.setMoveString("b8c6");
		chessGame.getCurrentPlayer().makeMove(moveToMake);
		moveToMake=new Move(chessGame.getGameBoard());
		moveToMake.setMoveString("f8e7");
		chessGame.getCurrentPlayer().makeMove(moveToMake);
		chessGame.showBoard();
		System.out.println(chessGame.getMoveList());
		System.out.println("White King Moves: ");
		System.out.println(chessGame.getGameBoard().getSquare("e1").
				getPiece().getMoves());
		System.out.println("Black King Moves: ");
		System.out.println(chessGame.getGameBoard().getSquare("e8").
				getPiece().getMoves());
		
	}
}
