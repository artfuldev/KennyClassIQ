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
public class GamePlayTest
{
	@Test
	public void test()
	{
		String newFEN="rnbqkbnr/1ppppppp/7P/8/pP6/8/P1PPPPP1/RNBQKBNR b KQkq b3 0 6 ";
		Game chessGame=new Game(newFEN);
		chessGame.showBoard();
		System.out.println(chessGame.getGameBoard().getSquare("a4").getPiece().
				getMoves());
		System.out.println(chessGame.getGameBoard().getSquare("a4").getPiece().
		getMoves().get(1).getToSquare());
		System.out.println(chessGame.getGameBoard().getSquare("a4").getPiece().
		getMoves().get(1).getEnPassantSquare());
		System.out.println(chessGame.getGameBoard().getSquare("a4").getPiece().
		getMoves().get(1).getToSquare().getTopSquare());
		System.out.println(chessGame.getGameBoard().getSquare("a4").getPiece().
		getMoves().get(1).getToSquare().getTopSquare().getPiece());
		System.out.println(chessGame.getGameBoard().getSquare("b4").getPiece());
		System.out.println(chessGame.getGameBoard().getSquare("b3").getTopSquare().getPiece());
		System.out.println(chessGame.getGameBoard().getSquare("a4").getPiece().
		getMoves().get(1).getToSquare().getBoard());
		System.out.println(chessGame.getGameBoard().getSquare("a4").getPiece().
		getMoves().get(1).getFromSquare().getBoard());
		System.out.println(chessGame.getGameBoard());
//		System.out.println("move "+chessGame.getPlayerTwo().getMove().getMoveString());
//		chessGame.showBoard();
	}
}
