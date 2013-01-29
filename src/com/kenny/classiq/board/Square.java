package com.kenny.classiq.board;

import com.kenny.classiq.pieces.Piece;

/**
 * The <code>Square</code> class is the class which represents the
 * individual squares of the board in a chess game. It is a very important
 * part of definition, as the squares should have lots of relevent
 * functions to help with evaluation.
 * Squares are part of the board, which also has files and ranks and
 * diagonals, all of which again contain the same 64 squares (references,
 * not duplicates). This represents an intricate, inter-related OOPS design,
 * which closely represents the real world.
 * @author Kenshin Himura (Sudarsan Balaji)
 *
 */
public class Square
{
	/**
	 * Holds the <code>Board</code> to which the square belongs, as a
	 * reference. Without wasting as much memory as a copy, still
	 * maintains the core concept of relationships between classes in
	 * OOPS. 
	 */
	private Board board;
	/**
	 * Holds the <code>Rank</code> of the <code>Square</code>, which tells
	 * us which Rank of the parent <code>Board</code>, the <code>Square</code>
	 * belongs to.
	 */
	private Rank rank;
	/**
	 * Holds the <code>File</code> of the <code>Square</code>, which tells
	 * us which <code>File</code> of the parent <code>Board</code>, the
	 * <code>Square</code> belongs to.
	 */
	private File file;
	/**
	 * Holds the <code>Diagonal</code> of the <code>Square</code>, which tells
	 * us which <code>Diagonal</code> of the parent <code>Board</code>, the
	 * <code>Diagonal</code> belongs to.
	 */
	private Diagonal diagonal;
	/**
	 * Holds the property of the square if it is a light square. In chess,
	 * light and dark squares alternate, so it is important to make a
	 * note of this shade of the square.
	 */
	private boolean light;
	/**
	 * Holds the name (description) of the square, which is nothing but
	 * the file-rank name, like "e4", derived from the file and rank to
	 * which it belongs.
	 */
	private String name;
	/**
	 * Holds the piece (or a reference to the piece) residing on the square.
	 * The reference is set to null if the square is blank or empty. 
	 */
	private Piece piece=null;
	public Rank getRank()
	{
		return rank;
	}
	public void setRank(Rank rank)
	{
		this.rank = rank;
	}
	public File getFile()
	{
		return file;
	}
	public void setFile(File file)
	{
		this.file = file;
	}
	public Diagonal getDiagonal()
	{
		return diagonal;
	}
	public void setDiagonal(Diagonal diagonal)
	{
		this.diagonal = diagonal;
	}
	public boolean isLight()
	{
		return light;
	}
	public void setLight(boolean light)
	{
		this.light = light;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public Piece getPiece()
	{
		return piece;
	}
	public void setPiece(Piece piece)
	{
		this.piece = piece;
	}
	public Board getBoard()
	{
		return board;
	}
	public void setBoard(Board board)
	{
		this.board = board;
	}
	/**
	 * Modifies and overrides the toString function of the Object
	 * superclass to implement for debug purposes. 
	 */
	public String toString()
	{
		return name;
	}
}