package com.kenny.classiq.pieces;

import java.util.ArrayList;

import com.kenny.classiq.board.Square;
import com.kenny.classiq.definitions.PieceValues;
import com.kenny.classiq.game.Move;

public class Knight extends Piece
{
	public Knight()
	{
		pieceValue=PieceValues.knightValue;
		shortAlgebraicNotation="N";
	}
	public ArrayList<Move> getMoves()
	{
		ArrayList<Move> returnList=new ArrayList<Move>();
		ArrayList<Square> toSquares=new ArrayList<Square>();
		if(square!=null)
		{
			if(square.getBottomSquare()!=null)
			{
				addCaptureAndMoveToSquare(square.getBottomSquare().
					getBottomLeftSquare(), toSquares);
				addCaptureAndMoveToSquare(square.getBottomSquare().
					getBottomRightSquare(), toSquares);
			}
			if(square.getRightSquare()!=null)
			{
				addCaptureAndMoveToSquare(square.getRightSquare().
					getBottomRightSquare(), toSquares);
				addCaptureAndMoveToSquare(square.getRightSquare().
					getTopRightSquare(), toSquares);
			}
			if(square.getTopSquare()!=null)
			{
				addCaptureAndMoveToSquare(square.getTopSquare().
					getTopLeftSquare(), toSquares);
				addCaptureAndMoveToSquare(square.getTopSquare().
					getTopRightSquare(), toSquares);
			}
			if(square.getLeftSquare()!=null)
			{
				addCaptureAndMoveToSquare(square.getLeftSquare().
					getBottomLeftSquare(), toSquares);
				addCaptureAndMoveToSquare(square.getLeftSquare().
					getTopLeftSquare(), toSquares);
			}
			if(!toSquares.isEmpty())
				for(byte i=0;i<toSquares.size();i++)
					returnList.add(new Move(square,toSquares.get(i)));
			if(!returnList.isEmpty())
				return returnList;
		}
		return null;
	}
}
