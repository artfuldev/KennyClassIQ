package com.kenny.classiq.pieces;

import java.util.ArrayList;

import com.kenny.classiq.board.Square;
import com.kenny.classiq.definitions.PieceValues;
import com.kenny.classiq.game.Move;

public class Queen extends Piece
{
	public Queen()
	{
		pieceValue=PieceValues.queenValue;
		shortAlgebraicNotation="Q";
	}
	public ArrayList<Move> getMoves()
	{
		ArrayList<Move> returnList=new ArrayList<Move>();
		ArrayList<Square> toSquares=new ArrayList<Square>();
		Square newSquare=square;
		if(newSquare!=null)
		{
			while(newSquare.getBottomLeftSquare()!=null)
			{
				newSquare=newSquare.getBottomLeftSquare();
				addCaptureAndMoveToSquare(newSquare,toSquares);
				if(newSquare.getPiece()!=null)
					break;
			}
			newSquare=square;
			while(newSquare.getBottomRightSquare()!=null)
			{
				newSquare=newSquare.getBottomRightSquare();
				addCaptureAndMoveToSquare(newSquare,toSquares);
				if(newSquare.getPiece()!=null)
					break;
			}
			newSquare=square;
			while(newSquare.getTopLeftSquare()!=null)
			{
				newSquare=newSquare.getTopLeftSquare();
				addCaptureAndMoveToSquare(newSquare,toSquares);
				if(newSquare.getPiece()!=null)
					break;
			}
			newSquare=square;
			while(newSquare.getTopRightSquare()!=null)
			{
				newSquare=newSquare.getTopRightSquare();
				addCaptureAndMoveToSquare(newSquare,toSquares);
				if(newSquare.getPiece()!=null)
					break;
			}
			newSquare=square;
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
			if(!returnList.isEmpty())
				return returnList;
		}
		return null;
	}
}
