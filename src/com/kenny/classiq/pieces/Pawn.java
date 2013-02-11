package com.kenny.classiq.pieces;

import java.util.ArrayList;

import com.kenny.classiq.board.Square;
import com.kenny.classiq.definitions.PieceValues;
import com.kenny.classiq.game.Move;

public class Pawn extends Piece
{
	public Pawn()
	{
		pieceValue=PieceValues.pawnValue;
		shortAlgebraicNotation="P";
	}
	public ArrayList<Move> getMoves()
	{
		ArrayList<Move> returnList=new ArrayList<Move>();
		ArrayList<Square> toSquares=new ArrayList<Square>();
		if(square!=null)
		{
			if(white)
			{
				if(square.getTopLeftSquare()!=null)
					if(square.getTopLeftSquare().getPiece()!=null)
						if(square.getTopLeftSquare().getPiece().
								isWhite()!=white)
							toSquares.add(square.getTopLeftSquare());
				if(square.getTopRightSquare()!=null)
					if(square.getTopRightSquare().getPiece()!=null)
						if(square.getTopRightSquare().getPiece().
								isWhite()!=white)
							toSquares.add(square.getTopRightSquare());
				if(square.getTopSquare()!=null)
					if(square.getTopSquare().getPiece()==null)
						toSquares.add(square.getTopSquare());
				if(Byte.parseByte(square.getRank().getName())==2)
					if(square.getTopSquare().getPiece()==null)
						if(square.getTopSquare().getTopSquare().
										getPiece()==null)
							toSquares.add(square.getTopSquare().
											getTopSquare());
			}
			else
			{
				if(square.getBottomLeftSquare()!=null)
					if(square.getBottomLeftSquare().getPiece()!=null)
						if(square.getBottomLeftSquare().getPiece().
								isWhite()!=white)
							toSquares.add(square.getBottomLeftSquare());
				if(square.getBottomRightSquare()!=null)
					if(square.getBottomRightSquare().getPiece()!=null)
						if(square.getBottomRightSquare().getPiece().
								isWhite()!=white)
							toSquares.add(square.getBottomRightSquare());
				if(square.getBottomSquare()!=null)
					if(square.getBottomSquare().getPiece()==null)
						toSquares.add(square.getBottomSquare());
				if(Byte.parseByte(square.getRank().getName())==7)
					if(square.getBottomSquare().getPiece()==null)
						if(square.getBottomSquare().getBottomSquare().
								getPiece()==null)
							toSquares.add(square.getBottomSquare().
									getBottomSquare());
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