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
		square=new Square[64];
		rank=new Rank[8];
		file=new File[8];
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
			square[i].setName(square[i].getFile().getName()+square[i].getRank().getName());
		}
	}
	public void printBoard()
	{
		for(int i=7;i>=0;i--)
			rank[i].printRank();
	}
	public void setPiece(Piece piece, String squareName)
	{
		for(int i=0;i<square.length;i++)
			if(square[i].getName().matches(squareName))
			{
				square[i].setPiece(piece);
				break;
			}
	}
}