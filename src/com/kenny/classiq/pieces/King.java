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