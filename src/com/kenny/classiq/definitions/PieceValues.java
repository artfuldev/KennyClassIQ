package com.kenny.classiq.definitions;

/**
 * Includes the standard definitions of the piece values needed.
 * This reduces the navigation between class files to edit piece
 * values if I ever need to do that.
 * I previously used to work with C++. Since Java lacks the <code>#define</code>
 * tags used to define constants in C++, I found this workaround. Making
 * the members static makes them accessible without using an object, and making
 * them final makes them constant, just the functionality offered by the 
 * <code>#define</code> tags. I have to include the class name, yes, but its
 * better than not having such a functionality at all!
 * @author Kenshin Himura (Sudarsan Balaji)
 *
 */
public class PieceValues
{
	/**
	 * Holds the value of the king in centipawns.
	 * Much higher than all pieces put together in the game,
	 * to avoid the engine caring about exchanges.
	 */
	public static final int kingValue=30000;
	/**
	 * Holds the value of the queen in centipawns
	 */
	public static final int queenValue=900;
	/**
	 * Holds the value of the rook in centipawns
	 */
	public static final int rookValue=500;
	/**
	 * Holds the value of the bishop in centipawns
	 */
	public static final int bishopValue=300;
	/**
	 * Holds the value of the knight in centipawns
	 */
	public static final int knightValue=300;
	/**
	 * Holds the value of the pawn in centipawns, 
	 * obviously 100, but can be modified to reflect changes in
	 * engine thinking.
	 */
	public static final int pawnValue=100;
}
