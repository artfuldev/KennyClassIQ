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

import java.util.ArrayList;

import org.junit.Test;

import com.kenny.classiq.definitions.Definitions;
import com.kenny.classiq.game.Game;
import com.kenny.classiq.game.Move;

public class PawnMoveGenTest
{
	@Test
	public void test()
	{
		Game chessGame=new Game(Definitions.startPositionFEN);
		ArrayList<Move> pawnMovesA2,pawnMovesE2,pawnMovesD7,pawnMovesD3;
		pawnMovesA2=chessGame.getGameBoard().getSquare("a2").getPiece().getMoves();
		System.out.println(pawnMovesA2);
		Move blackMoveOne=new Move(chessGame.getGameBoard());
		blackMoveOne.setMoveString("e7d3");
		chessGame.getPlayerOne().makeMove(blackMoveOne);
		chessGame.showBoard();
		pawnMovesE2=chessGame.getGameBoard().getSquare("e2").getPiece().getMoves();
		pawnMovesD7=chessGame.getGameBoard().getSquare("d7").getPiece().getMoves();
		pawnMovesD3=chessGame.getGameBoard().getSquare("d3").getPiece().getMoves();
		System.out.println(pawnMovesE2);
		System.out.println(pawnMovesD7);
		System.out.println(pawnMovesD3);
	}
}
