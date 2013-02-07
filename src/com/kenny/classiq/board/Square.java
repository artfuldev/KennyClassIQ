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
	private boolean light=true;
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
	/**
	 * Genric getter method to access the private date member rank. It can
	 * be used to better evaluate the board, by calling the <code>Rank</code>
	 * to which this <code>Square</code> belongs, and then later using the
	 * other <code>Square</code>s on the <code>Rank</code> to calculate
	 * stuff! (You get the idea, right?)
	 * @return <code>Rank</code> to which this <code>Square</code> belongs.
	 */
	public Rank getRank()
	{
		return rank;
	}
	/**
	 * Setter method to set the <code>Rank</code> of this <code>Square</code>.
	 * Primarily used immediately after construction of the <code>Board</code>.
	 * @param rank <code>Rank</code> to which this <code>Square</code> belongs.
	 */
	public void setRank(Rank rank)
	{
		this.rank = rank;
	}
	/**
	 * Genric getter method to access the private date member file. It can
	 * be used to better evaluate the board, by calling the <code>File</code>
	 * to which this <code>Square</code> belongs, and then later using the
	 * other <code>Square</code>s on the <code>File</code> to calculate
	 * stuff! (You get the idea, right?)
	 * @return <code>File</code> to which this <code>Square</code> belongs.
	 */
	public File getFile()
	{
		return file;
	}
	/**
	 * Setter method to set the <code>File</code> of this <code>Square</code>.
	 * Primarily used immediately after construction of the <code>Board</code>.
	 * @param file <code>File</code> to which this <code>Square</code> belongs.
	 */
	public void setFile(File file)
	{
		this.file = file;
	}
	/**
	 * Genric getter method to access the private date member diagonal. It can
	 * be used to better evaluate the board, by calling the <code>Diagonal</code>
	 * to which this <code>Square</code> belongs, and then later using the
	 * other <code>Square</code>s on the <code>Diagonal</code> to calculate
	 * stuff! (You get the idea, right?)
	 * @return <code>Diagonal</code> to which this <code>Square</code> belongs.
	 */
	public Diagonal getDiagonal()
	{
		return diagonal;
	}
	/**
	 * Setter method to set the <code>Diagonal</code> of this <code>Square</code>.
	 * Primarily used immediately after construction of the <code>Board</code>.
	 * @param diagonal <code>Diagonal</code> to which this <code>Square</code>
	 * belongs.
	 */
	public void setDiagonal(Diagonal diagonal)
	{
		this.diagonal = diagonal;
	}
	/**
	 * Used to check if the <code>Square</code> is a light square.
	 * Getter method for the light data member. Used to access the value of
	 * the private member of the class.
	 * @return <code>True</code> if te <code>Square</code> is a light
	 * square, <code>False</code> otherwise.
	 */
	public boolean isLight()
	{
		return light;
	}
	/**
	 * Used to tell whether the <code>Square</code> is a dark square,
	 * immediately after construction and never changed afterwards. Since
	 * the default value of this boolean is <code>True</code>, it is only
	 * called if it has to be reset.
	 * @param light <code>false</code> if the <code>Square</code> is a
	 * dark square.
	 */
	public void setLight(boolean light)
	{
		this.light = light;
	}
	/**
	 * Generic getter method to access the private data member
	 * representing the name of this <code>Square</code>.
	 * @return The name of this <code>Square</code>.
	 */
	public String getName()
	{
		return name;
	}
	/**
	 * Used to set a name for this <code>Square</code>.
	 * Generic setter method to set the private data member.
	 * @param name The name of this <code>Square</code>.
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	/**
	 * Generic getter method to access the private data member
	 * representing the <code>Piece</code> at this <code>Square</code>.
	 * @return <code>Piece</code> at this <code>Square</code>.
	 */
	public Piece getPiece()
	{
		return piece;
	}
	/**
	 * Used to set a <code>Piece</code> at this <code>Square</code>.
	 * Generic setter method to set the private data member. Also sets the
	 * square of the piece to this <code>Square</code>
	 * @param piece <code>Piece</code> to be set at this <code>Square</code>.
	 */
	public void setPiece(Piece piece)
	{
		this.piece = piece;
		this.piece.setSquare(this);
	}
	/**
	 * Used to get the <code>Board</code> to which this <code>Square</code>
	 * belongs, in a <code>Game</code>. This may prove useful in evaluation
	 * of certain features of the <code>Board</code>, as we will come to see
	 * later.
	 * @return <code>Board</code> to which this <code>Square</code>
	 * belongs
	 */
	public Board getBoard()
	{
		return board;
	}
	/**
	 * Setter method to set the <code>Board</code> of this <code>Square</code>.
	 * Primarily used immediately after construction of the <code>Board</code>.
	 * @param board <code>Board</code> to which this <code>Square</code>
	 * belongs.
	 */
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