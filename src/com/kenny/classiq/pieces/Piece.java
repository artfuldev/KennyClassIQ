package com.kenny.classiq.pieces;

import com.kenny.classiq.board.Board.Square;

/**
 * The <code>Piece</code> class is the class which represents a pice of the
 * chess board. All specific pieces of the chess board should be represented by
 * classes derived from this superclass. Enhances the OOPS concept
 * implementation. An abstract class, because no objects will be created of
 * <code>Piece</code> type.
 * @author Kenshin Himura
 *
 */
public abstract class Piece
{
	/**
	 * Holds the short algebraic notation of a piece. Made protected, so
	 * that it can be derived as a private member. An example would be
	 * a <code>Knight</code> class drevied from this <code>Piece</code>
	 * class, having shortAlgebraicNotation=<code>"N"</code>.
	 */
	protected String shortAlgebraicNotation="";
	/**
	 * Holds the value of the piece in centipawns. Currently an integer,
	 * later may be changed for optimization. Made protected so that it becomes
	 * a private member of the derived classes.
	 */
	protected int pieceValue=0;
	/**
	 * Holds a reference to the square a <code>Piece</code> belongs to.
	 * Obviously has to be derived as a private member, so being made
	 * protected. Holds a <code>null</code> value if the piece does not
	 * belong to a square.
	 */
	protected Square square=null;
	/**
	 * Holds the side of the board (black or white) the piece is on.
	 * Boolean term white, true means belongs to white. Default value is
	 * true.
	 */
	protected boolean white=true;
	/**
	 * Modifies and overrides the toString function of the Object
	 * superclass to implement for debug purposes. 
	 */
	public String toString()
	{
		return shortAlgebraicNotation+" at "+square.toString();
	}
}