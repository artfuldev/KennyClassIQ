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
				addCaptureSquare(square.getTopRightSquare(),toSquares);
				addCaptureSquare(square.getTopLeftSquare(),toSquares);
				addMoveToSquare(square.getTopSquare(),toSquares);
				if(Byte.parseByte(square.getRank().getName())==2)
					if(square.getTopSquare().getPiece()==null)
						if(square.getTopSquare().getTopSquare().
										getPiece()==null)
							toSquares.add(square.getTopSquare().
											getTopSquare());
			}
			else
			{
				addCaptureSquare(square.getBottomRightSquare(),toSquares);
				addCaptureSquare(square.getBottomLeftSquare(),toSquares);
				addMoveToSquare(square.getBottomSquare(),toSquares);
				if(Byte.parseByte(square.getRank().getName())==7)
					if(square.getBottomSquare().getPiece()==null)
						if(square.getBottomSquare().getBottomSquare().
								getPiece()==null)
							toSquares.add(square.getBottomSquare().
									getBottomSquare());
			}
			if(!toSquares.isEmpty())
				for(byte i=0;i<toSquares.size();i++)
				{
					Move tempMove=new Move(square,toSquares.get(i));
					returnList.add(tempMove);
					if(	(toSquares.get(i).getRankIndex()==0)||
						(toSquares.get(i).getRankIndex()==7))
					{
						returnList.remove(tempMove);
						returnList.add(new Move(square,toSquares.get(i),"queen"));
						returnList.add(new Move(square,toSquares.get(i),"rook"));
						returnList.add(new Move(square,toSquares.get(i),"bishop"));
						returnList.add(new Move(square,toSquares.get(i),"knight"));
					}
				}
			if(!returnList.isEmpty())
				return returnList;
		}
		return null;
	}
}