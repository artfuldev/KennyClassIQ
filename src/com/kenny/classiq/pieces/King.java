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
			if(square.getBottomLeftSquare()!=null)
			{
				if(square.getBottomSquare().getPiece()!=null)
				{
					if(square.getBottomLeftSquare().getPiece().isWhite()!=white)
						toSquares.add(square.getBottomLeftSquare());
				}
				else
					toSquares.add(square.getBottomLeftSquare());
			}
			if(square.getBottomSquare()!=null)
			{
				if(square.getBottomSquare().getPiece()!=null)
				{
					if(square.getBottomSquare().getPiece().isWhite()!=white)
						toSquares.add(square.getBottomSquare());
				}
				else
					toSquares.add(square.getBottomSquare());
			}
			if(square.getBottomRightSquare()!=null)
			{
				if(square.getBottomRightSquare().getPiece()!=null)
				{
					if(square.getBottomRightSquare().getPiece().isWhite()!=white)
						toSquares.add(square.getBottomRightSquare());
				}
				else
					toSquares.add(square.getBottomRightSquare());
			}
			if(square.getLeftSquare()!=null)
			{
				if(square.getLeftSquare().getPiece()!=null)
				{
					if(square.getLeftSquare().getPiece().isWhite()!=white)
						toSquares.add(square.getLeftSquare());
				}
				else
					toSquares.add(square.getLeftSquare());
			}
			if(square.getRightSquare()!=null)
			{
				if(square.getRightSquare().getPiece()!=null)
				{
					if(square.getRightSquare().getPiece().isWhite()!=white)
						toSquares.add(square.getRightSquare());
				}
				else
					toSquares.add(square.getRightSquare());
			}
			if(square.getTopLeftSquare()!=null)
			{
				if(square.getTopLeftSquare().getPiece()!=null)
				{
					if(square.getTopLeftSquare().getPiece().isWhite()!=white)
						toSquares.add(square.getTopLeftSquare());
				}
				else
					toSquares.add(square.getTopLeftSquare());
			}
			if(square.getTopSquare()!=null)
			{
				if(square.getTopSquare().getPiece()!=null)
				{
					if(square.getTopSquare().getPiece().isWhite()!=white)
						toSquares.add(square.getTopSquare());
				}
				else
					toSquares.add(square.getTopSquare());
			}
			if(square.getTopRightSquare()!=null)
			{
				if(square.getTopRightSquare().getPiece()!=null)
				{
					if(square.getTopRightSquare().getPiece().isWhite()!=white)
						toSquares.add(square.getTopRightSquare());
				}
				else
					toSquares.add(square.getTopRightSquare());
			}
			if(white)
			{
				if(square.getBoard().getGame().isWhiteCastleKingside())
					if(square.getBoard().getSquare("f1").getPiece()==null)
						if(square.getBoard().getSquare("g1").getPiece()==null)
							toSquares.add(square.getBoard().getSquare("g1"));
				if(square.getBoard().getGame().isWhiteCastleQueenside())
					if(square.getBoard().getSquare("b1").getPiece()==null)
						if(square.getBoard().getSquare("c1").getPiece()==null)
							if(square.getBoard().getSquare("d1").getPiece()==null)
								toSquares.add(square.getBoard().getSquare("c1"));
			}
			else
			{
				if(square.getBoard().getGame().isBlackCastleKingside())
					if(square.getBoard().getSquare("f8").getPiece()==null)
						if(square.getBoard().getSquare("g8").getPiece()==null)
							toSquares.add(square.getBoard().getSquare("g8"));
				if(square.getBoard().getGame().isWhiteCastleQueenside())
					if(square.getBoard().getSquare("b8").getPiece()==null)
						if(square.getBoard().getSquare("c8").getPiece()==null)
							if(square.getBoard().getSquare("d8").getPiece()==null)
								toSquares.add(square.getBoard().getSquare("c8"));
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