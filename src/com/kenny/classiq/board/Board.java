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
	 * An array of <code>Square</code> objects, which holds all the squares
	 * of the <code>Board</code>. References to these squares can belong in
	 * the ranks, files and diagonals.
	 */
	private Square[] square;
	/**
	 * An array of <code>Rank</code> objects, which holds all the rows
	 * of the <code>Board</code>, with each <code>Rank</code> object
	 * containing, not copies, but references, to the respective squares
	 * of the board, thereby maintaining the integral OOPS concept,
	 * while still not wasting memory. 
	 */
	private Rank[] rank;
	/**
	 * An array of <code>File</code> objects, which holds all the files
	 * of the <code>Board</code>, with each <code>File</code> object
	 * containing, not copies, but references, to the respective squares
	 * of the board, thereby maintaining the integral OOPS concept,
	 * while still not wasting memory. 
	 */
	private File[] file;
	/**
	 * An array of <code>Diagonal</code> objects, which holds all the light
	 * squared diagonals of the <code>Board</code>, with each <code>Diagonal</code>
	 * object containing, not copies, but references, to the respective squares
	 * of the board, thereby maintaining the integral OOPS concept,
	 * while still not wasting memory. 
	 */
	private Diagonal[] lightDiagonal;
	/**
	 * An array of <code>Diagonal</code> objects, which holds all the dark
	 * squared diagonals of the <code>Board</code>, with each <code>Diagonal</code>
	 * object containing, not copies, but references, to the respective squares
	 * of the board, thereby maintaining the integral OOPS concept,
	 * while still not wasting memory. 
	 */
	private Diagonal[] darkDiagonal;
	/**
	 * An array of <code>Piece</code> objects, representing all the pieces
	 * currently on the <code>Board</code>. This can be modified as and when
	 * captures are effected. Pieces removed from the board are placed on the
	 * Piece Set.
	 */
	private Piece[] piece;
	/**
	 * The default constructor of <code>Board</code>, which creates a board
	 * representing a new game. The constructor may also set values for its
	 * variables or call an initialization function to do the same. Usually,
	 * only the references and default values for the data members are set,
	 * while the <code>Game</code> class arranges the pieces on the board,
	 * taking the pieces from the <code>PieceSet</code> and placing them on
	 * the <code>Board</code>.
	 */
	public Board()
	{
		
	}
}