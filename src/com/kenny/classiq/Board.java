package com.kenny.classiq;

/**
 * The <code>Board</code> class is the class which represents a chess board.
 * It is made up of objects of the class <code>Square</code>, which are
 * also members of objects of classes <code>Rank</code>, <code>File</code>,
 * and <code>Diagonal</code>.
 * @author Kenshin Himura (Sudarsan Balaji)
 */
public class Board
{
	/**
	 * The <code>Square</code> class is the class which represents the
	 * individual squares of the board in a chess game. It is a very important
	 * part of definition, as the squares should have lots of relevent
	 * functions to help with evaluation.
	 * Squares are part of the board, which also has files and ranks and
	 * diagonals, all of which again contain the same 64 squares (references,
	 * not duplicates). This represents an intricate, inter-related OOPS design,
	 * which closely represents the real world.
	 * @author Kenshin Himura
	 *
	 */
	public class Square
	{
		/**
		 * Holds the Rank index of the Square, which tells us which Rank of
		 * the parent board, the Square belongs to. Useful for returning the
		 * entire Rank of the current Square.
		 */
		private byte rankIndex;
		/**
		 * Holds the File index of the Square, which tells us which File of
		 * the parent board, the Square belongs to. Useful for returning the
		 * entire File of the current Square.
		 */
		private byte fileIndex;
		/**
		 * Holds the left Diagonal index of the Square, which tells us which
		 * left Diagonal of the parent board, the Square belongs to. Useful
		 * for returning the entire left Diagonal of the current Square.
		 */
		private byte leftDiagonalIndex;
		/**
		 * Holds the right Diagonal index of the Square, which tells us which
		 * right Diagonal of the parent board, the Square belongs to. Useful
		 * for returning the entire right Diagonal of the current Square.
		 */
		private byte rightDiagonalIndex;
		/**
		 * Holds the property of the square if it is a light square. In chess,
		 * light and dark squares alternate, so it is important to make a
		 * note of this shade of the square.
		 */
		private boolean lightSquare;
	}
}