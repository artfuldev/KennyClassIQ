package com.kenny.classiq.pieces;

import com.kenny.classiq.board.Square;

/**
 * The <code>Piece</code> class is the class which represents a pice of the
 * chess board. All specific pieces of the chess board should be represented by
 * classes derived from this superclass. Enhances the OOPS concept
 * implementation. An abstract class, because no objects will be created of
 * <code>Piece</code> type.
 * @author Kenshin Himura (Sudarsan Balaji)
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
	 * Used to get the short algebraic notation of a piece, usually to find
	 * out its type (which can alternately be found using getClass().getName(),
	 * but it wasn't the right way to proceed).
	 * @return The short algebraic notation of the piece, eg: "N"
	 * for knight.
	 */
	public String getShortAlgebraicNotation()
	{
		return shortAlgebraicNotation;
	}
	/**
	 * Genric setter method used to set the value of the private variable
	 * shortAlgebraicNotation. Almost never used, but still defined as a
	 * good programming practice (meaning if ever we need it later, we
	 * won't have to come back here and define it again).
	 * @param shortAlgebraicNotation The short algebraic notation of
	 * this <code>Piece</code>, as a single-character <code>String</code>.
	 */
	public void setShortAlgebraicNotation(String shortAlgebraicNotation)
	{
		this.shortAlgebraicNotation = shortAlgebraicNotation;
	}
	/**
	 * Used to get the value of this <code>Piece</code> in centipawns, possibly
	 * for use during the evaluation function.
	 * @return The value of this <code>Piece</code>, measured in centipawns.
	 */
	public int getPieceValue()
	{
		return pieceValue;
	}
	/**
	 * Genric setter method used to set the value of the private variable
	 * pieceValue. Almost never used, but still defined as a good programming
	 * practice (meaning if ever we need it later, we won't have to come back
	 * here and define it again).
	 * @param pieceValue The pieceValue of this <code>Piece</code>, as an
	 * integer.
	 */
	public void setPieceValue(int pieceValue)
	{
		this.pieceValue = pieceValue;
	}
	/**
	 * Used to get the <code>Square</code> on which this <code>Piece</code>
	 * resides, possible for move-generation and tactical analysis purposes.
	 * @return The <code>Square</code> on which this <code>Piece</code>
	 * belongs, <code>null</code> if it does not belong to any <code>Square
	 * </code>.
	 */
	public Square getSquare()
	{
		return square;
	}
	/**
	 * Used to set the <code>Square</code> on which this <code>Piece</code>
	 * is resting. Usually set by the <code>Square</code> on which it is set,
	 * during the beginning of the <code>Game</code> and during the making
	 * and unMaking of <code>Move</code>s.
	 * @param square The <code>Square</code> on which this <code>Piece
	 * </code> resides.
	 */
	public void setSquare(Square square)
	{
		this.square = square;
	}
	/**
	 * Used to check if this <code>Piece</code> is a white piece or not. Possibly
	 * to be used for scoring in evaluation, or to check if a move is legal.
	 * @return <code>true</code> if this <code>Piece</code> is of white's
	 * side.
	 */
	public boolean isWhite()
	{
		return white;
	}
	/**
	 * Generic setter method. Used to set whether the piece is on the white's
	 * side, immediately after or during construction. It is used in the
	 * generation of <code>Piece</code>s for the <code>PieceSet</code>,
	 * only from which the <code>Game</code> can use <code>Piece</code>s.
	 * Generally called only with <code>false</code>, because the default
	 * value for a <code>Piece</code> is true.
	 * @param white <code>false</code> if the piece to be on the black's
	 * side.
	 */
	public void setWhite(boolean white)
	{
		this.white = white;
	}
	/**
	 * Modifies and overrides the toString function of the Object
	 * superclass to implement for debug purposes. Returns a String
	 * of the form "N at f3".
	 */
	public String toString()
	{
		String returnString;
		returnString=getShortAlgebraicNotation();
		if(square!=null)
			returnString+=" at "+square.toString();
		return returnString;
	}
}