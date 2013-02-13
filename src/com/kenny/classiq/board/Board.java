/*
 * This file is part of "Kenny ClassIQ", (c) Kenshin Himura, 2013.
 * 
 * "Kenny ClassIQ" is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * "Kenny ClassIQ" is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with "Kenny ClassIQ".  If not, see <http://www.gnu.org/licenses/>.
 * 
 */

package com.kenny.classiq.board;

import java.util.ArrayList;

import com.kenny.classiq.game.Game;
import com.kenny.classiq.game.Move;
import com.kenny.classiq.pieces.Piece;

/**
 * The <code>Board</code> class is the class which represents a chess board.
 * It is made up of objects of the class <code>Square</code>, which are
 * also members of objects of classes <code>Rank</code>, <code>File</code>,
 * and <code>Diagonal</code>.
 * @author Kenshin Himura  
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
			square[i].setFileIndex(fileIndex);
			square[i].setRankIndex(rankIndex);
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
	/**
	 * Used to get a particular <code>Rank<code> of the <code>Board</code>,
	 * by specifying its rank index in the <code>Board</code>.
	 * @param rankIndex The index of the required <code>Rank</code> in
	 * the <code>Board</code>, as a <code>byte</code> from 0-7.
	 * @return The specified <code>Rank</code> of this <code>Board</code>.
	 */
	public Rank getRank(byte rankIndex)
	{
		if((rankIndex>-1)&&(rankIndex<8))
				return rank[rankIndex];
		return null;
	}
	/**
	 * Used to get a particular <code>File<code> of the <code>Board</code>,
	 * by specifying its file index in the <code>Board</code>.
	 * @param fileIndex The index of the required <code>File</code> in
	 * the <code>Board</code>, as a <code>byte</code> from 0-7.
	 * @return The specified <code>File</code> of this <code>Board</code>.
	 */
	public File getFile(byte fileIndex)
	{
		if((fileIndex>-1)&&(fileIndex<8))
				return file[fileIndex];
		return null;
	}
	/**
	 * Generic getter method used to access the <code>Game</code> to which the
	 * <code>Board</code> belongs. Since it is a private member, it has to be
	 * accessed by a public getter method.
	 * @return The <code>Game</code> of this <code>Board</code>.
	 */
	public Game getGame()
	{
		return game;
	}
	/**
	 * Generic setter method used to set the <code>Game</code> to which the
	 * <code>Board</code> belongs. Since it is a private member, it has to be
	 * set by a public setter method. Generally not used, as it is set during
	 * construction itself, still defined as good programming practice (it may
	 * become useful later).
	 * @return The <code>Game</code> of this <code>Board</code>.
	 */
	public void setGame(Game game)
	{
		this.game = game;
	}
	/**
	 * Used to get the list of <code>Squares</code> which are occupied by
	 * white pieces. Uses the getOccupiedSquares() function and removes the
	 * <code>Square</code>s which are occupied by black pieces.
	 * @return An <code>ArrayList</code> of <code>Square</code>s having
	 * white <code>Piece</code>s.
	 */
	public ArrayList<Square> getWhiteOccupiedSquares()
	{
		ArrayList<Square> returnList=getOccupiedSquares();
		for(byte i=0;i<returnList.size();i++)
			if(!returnList.get(i).getPiece().isWhite())
			{
				returnList.remove(i);
				i--;
			}
		return returnList;
	}
	/**
	 * Used to get the list of <code>Squares</code> which are occupied by
	 * black pieces. Uses the getOccupiedSquares() function and removes the
	 * <code>Square</code>s which are occupied by white pieces.
	 * @return An <code>ArrayList</code> of <code>Square</code>s having
	 * black <code>Piece</code>s.
	 */
	public ArrayList<Square> getBlackOccupiedSquares()
	{
		ArrayList<Square> returnList=getOccupiedSquares();
		for(byte i=0;i<returnList.size();i++)
			if(returnList.get(i).getPiece().isWhite())
			{
				returnList.remove(i);
				i--;
			}
		return returnList;
	}
	/**
	 * Used to get the list of <code>Squares</code> which are occupied by
	 * pieces. Checks if the </code>Square</code>s are empty and adds the
	 * <code>Square</code>s which are occupied by pieces.
	 * @return An <code>ArrayList</code> of <code>Square</code>s having
	 * <code>Piece</code>s.
	 */
	public ArrayList<Square> getOccupiedSquares()
	{
		ArrayList<Square> returnList=new ArrayList<Square>();
		for(byte i=0;i<64;i++)
			if(getSquare(i).getPiece()!=null)
				returnList.add(getSquare(i));
		return returnList;
	}
	/**
	 * Used to get the list of <code>Squares</code> which are not occupied by
	 * pieces. Checks if the </code>Square</code>s are empty and adds the
	 * <code>Square</code>s which are not occupied by pieces.
	 * @return An <code>ArrayList</code> of <code>Square</code>s not having
	 * <code>Piece</code>s.
	 */
	public ArrayList<Square> getEmptySquares()
	{
		ArrayList<Square> returnList=new ArrayList<Square>();
		for(byte i=0;i<64;i++)
			if(getSquare(i).getPiece()==null)
				returnList.add(getSquare(i));
		return returnList;
	}
	/**
	 * Used to get the <code>Square</code> in which the white <code>
	 * King</code> is present. Used to calculate legality of <code>
	 * Move</code>s.
	 * @return The <code>Square</code> in which the white <code>
	 * King</code> is present.
	 */
	public Square getWhiteKingSquare()
	{
		for(byte i=0;i<getWhiteOccupiedSquares().size();i++)
			if(getWhiteOccupiedSquares().get(i).getPiece().
					getShortAlgebraicNotation().matches("K"))
			{
				return getWhiteOccupiedSquares().get(i);
			}
		return null;
	}
	/**
	 * Used to get the <code>Square</code> in which the black <code>
	 * King</code> is present. Used to calculate legality of <code>
	 * Move</code>s.
	 * @return The <code>Square</code> in which the black <code>
	 * King</code> is present.
	 */
	public Square getBlackKingSquare()
	{
		for(byte i=0;i<getBlackOccupiedSquares().size();i++)
			if(getBlackOccupiedSquares().get(i).getPiece().
					getShortAlgebraicNotation().matches("K"))
			{
				return getBlackOccupiedSquares().get(i);
			}
		return null;
	}
	/**
	 * Used to check if the side specified by the <code>boolean</code>
	 * is in the checked position on the <code>Board</code>
	 * @param white The side for which the isChecked test should be
	 * made.
	 * @return <code>true</code> if the side's <code>King</code> is in
	 * check, <code>false</code> otherwise.
	 */
	public boolean isChecked(boolean white)
	{
		ArrayList<Square> enemySquares=null;
		ArrayList<Move> testMoves=null;
		if(white)
			enemySquares=getBlackOccupiedSquares();
		else
			enemySquares=getWhiteOccupiedSquares();
		for(byte i=0;i<enemySquares.size();i++)
		{
			testMoves=enemySquares.get(i).getPiece().getMoves();
			if(testMoves!=null)
				for(byte j=0;j<testMoves.size();j++)
				{
					Move testMove=testMoves.get(j);
					if(testMove!=null)
						if(testMove.isCapturingMove())
							if(testMove.getCapturedPiece().
								getShortAlgebraicNotation().matches("K"))
								return true;
				}
		}
		return false;
	}
}