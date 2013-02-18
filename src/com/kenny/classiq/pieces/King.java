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

public class King extends Piece
{
	public King()
	{
		pieceValue=PieceValues.kingValue;
		shortAlgebraicNotation="K";
	}
	public ArrayList<Move> getMoves()
	{
		ArrayList<Move> returnList=new ArrayList<Move>();
		ArrayList<Square> toSquares=new ArrayList<Square>();
		if(square!=null)
		{
			addCaptureAndMoveToSquare(square.getBottomLeftSquare(),toSquares);
			addCaptureAndMoveToSquare(square.getBottomSquare(),toSquares);
			addCaptureAndMoveToSquare(square.getBottomRightSquare(),toSquares);
			addCaptureAndMoveToSquare(square.getTopLeftSquare(),toSquares);
			addCaptureAndMoveToSquare(square.getTopSquare(),toSquares);
			addCaptureAndMoveToSquare(square.getTopRightSquare(),toSquares);
			addCaptureAndMoveToSquare(square.getLeftSquare(),toSquares);
			addCaptureAndMoveToSquare(square.getRightSquare(),toSquares);
			if(white)
			{
				if(square.getBoard().getGame().isWhiteCastleKingside())
					if(square.getBoard().getSquare("f1").getPiece()==null)
						if(square.getBoard().getSquare("g1").getPiece()==null)
							toSquares.add(square.getBoard().getSquare("g1"));
				if(square.getBoard().getGame().isWhiteCastleQueenside())
					if(square.getBoard().getSquare("b1").getPiece()==null)
						if(square.getBoard().getSquare("c1").getPiece()==null)
							if(square.getBoard().getSquare("d1").
								getPiece()==null)
								toSquares.add(square.getBoard().
								getSquare("c1"));
			}
			else
			{
				if(square.getBoard().getGame().isBlackCastleKingside())
					if(square.getBoard().getSquare("f8").getPiece()==null)
						if(square.getBoard().getSquare("g8").getPiece()
							==null)
							toSquares.add(square.getBoard().
							getSquare("g8"));
				if(square.getBoard().getGame().isBlackCastleQueenside())
					if(square.getBoard().getSquare("b8").getPiece()==null)
						if(square.getBoard().getSquare("c8").getPiece()==null)
							if(square.getBoard().getSquare("d8").
								getPiece()==null)
								toSquares.add(square.getBoard().
								getSquare("c8"));
			
			}
			if(!toSquares.isEmpty())
				for(byte i=0;i<toSquares.size();i++)
					returnList.add(new Move(square,toSquares.get(i)));
		}
		return returnList;
	}
}