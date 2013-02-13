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

import com.kenny.classiq.game.Move;
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
	 * Holds the index of this <code>Square</code> in the <code>Rank</code>,
	 * with respect to the <code>File</code>.
	 */
	private byte fileIndex;
	/**
	 * Holds the index of this <code>Square</code> in the <code>File</code>,
	 * with respect to the <code>Rank</code>.
	 */
	private byte rankIndex;
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
		return board.getRank(rankIndex);
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
		return board.getFile(fileIndex);
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
		if(this.piece!=null)
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
	 * Generic getter method used to access the private variable fileIndex.
	 * Since it is a private data member, it has to be accessed using public
	 * getter and setter methods.
	 * @return The file index of this <code>Square</code> on its <code>Board
	 * </code>. 
	 */
	public byte getFileIndex()
	{
		return fileIndex;
	}
	/**
	 * Generic setter method used to set the private variable fileIndex.
	 * Since it is a private data member, it has to be accessed using public
	 * getter and setter methods.
	 * @param fileIndex The file index of this <code>Square</code> on its
	 * <code>Board</code>. 
	 */
	public void setFileIndex(byte fileIndex)
	{
		this.fileIndex = fileIndex;
	}
	/**
	 * Generic getter method used to access the private variable rankIndex.
	 * Since it is a private data member, it has to be accessed using public
	 * getter and setter methods.
	 * @return The rank index of this <code>Square</code> on its <code>Board
	 * </code>. 
	 */
	public byte getRankIndex()
	{
		return rankIndex;
	}
	/**
	 * Generic setter method used to set the private variable rankIndex.
	 * Since it is a private data member, it has to be accessed using public
	 * getter and setter methods.
	 * @param rankIndex The rank index of this <code>Square</code> on its
	 * <code>Board</code>. 
	 */
	public void setRankIndex(byte rankIndex)
	{
		this.rankIndex = rankIndex;
	}
	/**
	 * Used to return the neighburing squares of this <code>Square</code>.
	 * Probably used later to calculate king safety or for pawn move
	 * generation. 
	 * @return The neighbouring <code>Square</code>s of a <code>Square</code> as
	 * an <code>ArrayList</code>.
	 */
	public ArrayList<Square> getNeighbouringSquares()
	{
		ArrayList<Square> returnList=new ArrayList<Square>();
		return returnList;
	}
	/**
	 * Used to get the <code>Square</code> located to the left of this <code>
	 * Square</code> on its <code>Board</code>.
	 * @return The left <code>Square</code> if available, else <code>null</code>.
	 */
	public Square getLeftSquare()
	{
		return getRank().getSquare((byte)(fileIndex-1));
	}
	/**
	 * Used to get the <code>Square</code> located to the right of this <code>
	 * Square</code> on its <code>Board</code>.
	 * @return The right <code>Square</code> if available, else <code>null</code>.
	 */
	public Square getRightSquare()
	{
		return getRank().getSquare((byte)(fileIndex+1));
	}
	/**
	 * Used to get the <code>Square</code> located to the top of this <code>
	 * Square</code> on its <code>Board</code>.
	 * @return The top <code>Square</code> if available, else <code>null</code>.
	 */
	public Square getTopSquare()
	{
		return getFile().getSquare((byte)(rankIndex+1));
	}
	/**
	 * Used to get the <code>Square</code> located to the bottom of this <code>
	 * Square</code> on its <code>Board</code>.
	 * @return The bottom <code>Square</code> if available, else <code>null</code>.
	 */
	public Square getBottomSquare()
	{
		return getFile().getSquare((byte)(rankIndex-1));
	}
	/**
	 * Used to get the <code>Square</code> located to the top-left of this
	 * <code>Square</code> on its <code>Board</code>.
	 * @return The top-left <code>Square</code> if available, else
	 * <code>null</code>.
	 */
	public Square getTopLeftSquare()
	{
		if(board.getFile((byte)(fileIndex-1))!=null)
			return board.getFile((byte)(fileIndex-1)).getSquare(
				(byte)(rankIndex+1));
		return null;
	}
	/**
	 * Used to get the <code>Square</code> located to the bottom-left of this
	 * <code>Square</code> on its <code>Board</code>.
	 * @return The bottom-left <code>Square</code> if available, else
	 * <code>null</code>.
	 */
	public Square getBottomLeftSquare()
	{
		if(board.getFile((byte)(fileIndex-1))!=null)
			return board.getFile((byte)(fileIndex-1)).getSquare(
				(byte)(rankIndex-1));
		return null;
	}
	/**
	 * Used to get the <code>Square</code> located to the top-right of this
	 * <code>Square</code> on its <code>Board</code>.
	 * @return The top-right <code>Square</code> if available, else
	 * <code>null</code>.
	 */
	public Square getTopRightSquare()
	{
		if(board.getFile((byte)(fileIndex+1))!=null)
			return board.getFile((byte)(fileIndex+1)).getSquare(
				(byte)(rankIndex+1));
		return null;
	}
	/**
	 * Used to get the <code>Square</code> located to the bottom-right of this
	 * <code>Square</code> on its <code>Board</code>.
	 * @return The bottom-right <code>Square</code> if available, else
	 * <code>null</code>.
	 */
	public Square getBottomRightSquare()
	{
		if(board.getFile((byte)(fileIndex+1))!=null)
			return board.getFile((byte)(fileIndex+1)).getSquare(
				(byte)(rankIndex-1));
		return null;
	}
	public boolean isThreatenedBy(boolean white)
	{
		ArrayList<Square> enemySquares=null;
		ArrayList<Move> testMoves=null;
		if(!white)
			enemySquares=board.getBlackOccupiedSquares();
		else
			enemySquares=board.getWhiteOccupiedSquares();
		for(byte i=0;i<enemySquares.size();i++)
			if(enemySquares.get(i).getPiece().getMoves()!=null)
			{
				testMoves=enemySquares.get(i).getPiece().getMoves();
				for(byte j=0;j<testMoves.size();j++)
					if(testMoves.get(j).getToSquare().equals(this))
						return true;
			}
		return false;
	}
	public ArrayList<Square> threatenedBy(boolean white)
	{
		ArrayList<Square> returnList=new ArrayList<Square>();
		ArrayList<Square> enemySquares=null;
		if(!white)
			enemySquares=board.getBlackOccupiedSquares();
		else
			enemySquares=board.getWhiteOccupiedSquares();
		for(byte i=0;i<enemySquares.size();i++)
		{
			if(enemySquares.get(i).getPiece().getMoves()!=null)
				for(byte j=0;j<enemySquares.get(i).getPiece().getMoves().size();j++)
					if(enemySquares.get(i).getPiece().getMoves().get(j).
						getToSquare().equals(this))
						returnList.add(enemySquares.get(i));
		}
		if(!returnList.isEmpty())
			return returnList;
		return null;
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