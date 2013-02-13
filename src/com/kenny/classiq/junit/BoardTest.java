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

import com.kenny.classiq.board.Board;
import com.kenny.classiq.pieces.Knight;
import com.kenny.classiq.pieces.Piece;

public class BoardTest
{
	@Test
	public void test()
	{
		Board board=new Board();
		Piece whiteKnight=new Knight();
		Piece blackKnight=new Knight();
		blackKnight.setWhite(false);
		board.setPiece(whiteKnight, "g1");
		board.setPiece(blackKnight, "g8");
		board.printBoard();
	}
}
