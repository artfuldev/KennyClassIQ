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

package com.kenny.classiq.pieces;

import java.util.ArrayList;

import com.kenny.classiq.board.Square;
import com.kenny.classiq.definitions.PieceValues;
import com.kenny.classiq.game.Move;

public class Rook extends Piece
{
	public Rook()
	{
		pieceValue=PieceValues.rookValue;
		shortAlgebraicNotation="R";
	}
	public ArrayList<Move> getMoves()
	{
		ArrayList<Move> returnList=new ArrayList<Move>();
		ArrayList<Square> toSquares=new ArrayList<Square>();
		Square newSquare=square;
		if(newSquare!=null)
		{
			while(newSquare.getBottomSquare()!=null)
			{
				newSquare=newSquare.getBottomSquare();
				addCaptureAndMoveToSquare(newSquare,toSquares);
				if(newSquare.getPiece()!=null)
					break;
			}
			newSquare=square;
			while(newSquare.getRightSquare()!=null)
			{
				newSquare=newSquare.getRightSquare();
				addCaptureAndMoveToSquare(newSquare,toSquares);
				if(newSquare.getPiece()!=null)
					break;
			}
			newSquare=square;
			while(newSquare.getTopSquare()!=null)
			{
				newSquare=newSquare.getTopSquare();
				addCaptureAndMoveToSquare(newSquare,toSquares);
				if(newSquare.getPiece()!=null)
					break;
			}
			newSquare=square;
			while(newSquare.getLeftSquare()!=null)
			{
				newSquare=newSquare.getLeftSquare();
				addCaptureAndMoveToSquare(newSquare,toSquares);
				if(newSquare.getPiece()!=null)
					break;
			}
			if(!toSquares.isEmpty())
				for(byte i=0;i<toSquares.size();i++)
					returnList.add(new Move(square,toSquares.get(i)));
		}
		return returnList;
	}
}
