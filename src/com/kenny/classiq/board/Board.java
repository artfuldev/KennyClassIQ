package com.kenny.classiq.board;

import com.kenny.classiq.game.Game;
import com.kenny.classiq.pieces.Piece;

/**
 * The <code>Board</code> class is the class which represents a chess board.
 * It is made up of objects of the class <code>Square</code>, which are
 * also members of objects of classes <code>Rank</code>, <code>File</code>,
 * and <code>Diagonal</code>.
 * @author Kenshin Himura (Sudarsan Balaji)
 * 
 */
public class Board
{
	/**
	 * Holds a reference to the <code>Game</code> this <code>Board</code>
	 * belongs to. Useful in retrieveing information such as last move
	 * and current player from the <code>Game</code>, when updating
	 * FEN Strings.
	 */
	private Game game;
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
		//Create 64 squares, 8 ranks, and 8 files
		square=new Square[64];
		rank=new Rank[8];
		file=new File[8];
		//name each rank and file during construction
		rank[0]=new Rank("1");
		rank[1]=new Rank("2");
		rank[2]=new Rank("3");
		rank[3]=new Rank("4");
		rank[4]=new Rank("5");
		rank[5]=new Rank("6");
		rank[6]=new Rank("7");
		rank[7]=new Rank("8");
		file[0]=new File("a");
		file[1]=new File("b");
		file[2]=new File("c");
		file[3]=new File("d");
		file[4]=new File("e");
		file[5]=new File("f");
		file[6]=new File("g");
		file[7]=new File("h");
		//create and set individual square properties
		for(int i=0;i<square.length;i++)
		{
			byte fileIndex=(byte)(i%8);
			byte rankIndex=(byte)(i/8);
			square[i]=new Square();
			square[i].setBoard(this);
			square[i].setFile(file[fileIndex]);
			square[i].setRank(rank[rankIndex]);
			rank[rankIndex].setSquare(square[i],fileIndex);
			file[fileIndex].setSquare(square[i],rankIndex);
			square[i].setName(square[i].getFile().getName()
					+square[i].getRank().getName());
			//Every alternate square is a dark square, starting from a1.
			if((i%2)==0)
				square[i].setLight(false);
		}
	}
	/**
	 * The default constructor of <code>Board</code> is of no use, now that
	 * we wish to have a reference to <code>Game</code>. Hence this parameterised
	 * constructor, which creates a board representing a new game, and sets a
	 * reference to the <code>Game</code> of which this <code>Board</code> is a
	 * part.
	 * <p>
	 * The constructor may also set values for its variables or call an
	 * initialization function to do the same. Usually, only the references
	 * and default values for the data members are set, while the
	 * <code>Game</code> class arranges the pieces on the board,
	 * taking the pieces from the <code>PieceSet</code> and placing them on
	 * the <code>Board</code>.
	 */
	public Board(Game game)
	{
		this.setGame(game);
		//Create 64 squares, 8 ranks, and 8 files
		square=new Square[64];
		rank=new Rank[8];
		file=new File[8];
		//name each rank and file during construction
		rank[0]=new Rank("1");
		rank[1]=new Rank("2");
		rank[2]=new Rank("3");
		rank[3]=new Rank("4");
		rank[4]=new Rank("5");
		rank[5]=new Rank("6");
		rank[6]=new Rank("7");
		rank[7]=new Rank("8");
		file[0]=new File("a");
		file[1]=new File("b");
		file[2]=new File("c");
		file[3]=new File("d");
		file[4]=new File("e");
		file[5]=new File("f");
		file[6]=new File("g");
		file[7]=new File("h");
		//create and set individual square properties
		for(int i=0;i<square.length;i++)
		{
			byte fileIndex=(byte)(i%8);
			byte rankIndex=(byte)(i/8);
			square[i]=new Square();
			square[i].setBoard(this);
			square[i].setFile(file[fileIndex]);
			square[i].setRank(rank[rankIndex]);
			rank[rankIndex].setSquare(square[i],fileIndex);
			file[fileIndex].setSquare(square[i],rankIndex);
			square[i].setName(square[i].getFile().getName()
					+square[i].getRank().getName());
			//Every alternate square is a dark square, starting from a1.
			if((i%2)==0)
				square[i].setLight(false);
		}
	}
	/**
	 * Prints the <code>Board</code>, <code>Rank</code>-wise, from rank 8
	 * to rank 1, so that the <code>Board</code> is printed from
	 * <code>White's<code> point of view. for debug purposes,
	 * later may be used to display to user.
	 */
	public void printBoard()
	{
		for(int i=7;i>=0;i--)
			rank[i].printRank();
	}
	/**
	 * Sets a <code>Piece</code> at a specific <code>Square</code> of
	 * the <code>Board</code>. This function is called so that a
	 * <code>Board</code> can be setup for a new <code>Game</code>
	 * position, or based on a FEN string.
	 * @param piece <code>Piece</code> to be placed.
	 * @param squareName name of <code>Square</code> on which to place
	 * the <code>Piece</code>, eg., "a4"
	 */
	public void setPiece(Piece piece, String squareName)
	{
		for(int i=0;i<square.length;i++)
			if(square[i].getName().matches(squareName))
			{
				square[i].setPiece(piece);
				break;
			}
	}
	/**
	 * Sets a <code>Piece</code> at a specific <code>Square</code> of
	 * the <code>Board</code>, by taking the index value of the
	 * <code>Square</code> in the <code>Board<code>. This function
	 * is called so that a <code>Board</code> can be setup for a new
	 * <code>Game</code> position, or based on a FEN string.
	 * @param piece <code>Piece</code> to be placed.
	 * @param index index of <code>Square</code> on which to place
	 * the <code>Piece</code>, eg., 0 for "a1", 63 for "h8".
	 */
	public void setPiece(Piece piece, byte index)
	{
		square[index].setPiece(piece);
	}
	/**
	 * Used to get a specific <code>Square</code> of this <code>Board</code>,
	 * when the name of the <code>Square</code> is known.
	 * @param squareName The name of the <code>Square</code> as a String, eg.
	 * "e2".
	 * @return The specified <code>Square</code>. 
	 */
	public Square getSquare(String squareName)
	{
		for(int i=0;i<square.length;i++)
			if(square[i].getName().matches(squareName))
				return square[i];
		return null;
	}

	/**
	 * Used to get a specific <code>Square</code> of this <code>Board</code>,
	 * when the index of the <code>Square</code> is known.
	 * @param index The index of the <code>Square</code> as a byte, 0-64.
	 * @return The specified <code>Square</code>. 
	 */
	public Square getSquare(byte index)
	{
		return square[index];
	}
	public Game getGame()
	{
		return game;
	}
	public void setGame(Game game)
	{
		this.game = game;
	}
}