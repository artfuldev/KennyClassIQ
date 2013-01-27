package com.kenny.classiq;

import com.kenny.classiq.Board.Square;

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
	 * Holds the type of piece of the object, should obviously be
	 * derived by the subclasses, so made protected. An example would
	 * be a <code>Knight</code> class derived from this <code>Piece</code>
	 * class having playerType=<code>"Knight"</code>. 
	 */
	protected String pieceType;
	/**
	 * Holds the short algebraic notation of a piece. Made protected, so
	 * that it can be derived as a private member. An example would be
	 * a <code>Knight</code> class drevied from this <code>Piece</code>
	 * class, having shortAlgebraicNotation=<code>"N"</code>.
	 */
	protected String shortAlgebraicNotation="";
	/**
	 * Holds a reference to the square a <code>Piece</code> belongs to.
	 * Obviously has to be derived as a private member, so being made
	 * protected. Holds a <code>null</code> value if the piece does not
	 * belong to a square.
	 */
	protected Square square=null;
}