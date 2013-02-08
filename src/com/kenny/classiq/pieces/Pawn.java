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
		return returnList;
	}
}