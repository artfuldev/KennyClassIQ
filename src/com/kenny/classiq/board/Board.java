package com.kenny.classiq.board;

import com.kenny.classiq.pieces.Piece;

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
		 * Holds the light Diagonal index of the Square, which tells us which
		 * light Diagonal of the parent board, the Square belongs to. Useful
		 * for returning the entire left Diagonal of the current Square.
		 */
		private byte lightDiagonalIndex;
		/**
		 * Holds the dark Diagonal index of the Square, which tells us which
		 * dark Diagonal of the parent board, the Square belongs to. Useful
		 * for returning the entire right Diagonal of the current Square.
		 */
		private byte darkDiagonalIndex;
		/**
		 * Holds the property of the square if it is a light square. In chess,
		 * light and dark squares alternate, so it is important to make a
		 * note of this shade of the square.
		 */
		private boolean lightSquare;
		/**
		 * Holds the name (description) of the square, which is nothing but
		 * the file-rank name, like "e4".
		 */
		private String name;
		/**
		 * Holds the piece (or a reference to the piece) residing on the square.
		 * The reference is set to null if the square is blank or empty. 
		 */
		private Piece piece=null;
		/**
		 * Modifies and overrides the toString function of the Object
		 * superclass to implement for debug purposes. 
		 */
		public String toString()
		{
			return name;
		}
	}
}