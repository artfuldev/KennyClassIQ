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

package com.kenny.classiq.game;

import com.kenny.classiq.pieces.Bishop;
import com.kenny.classiq.pieces.King;
import com.kenny.classiq.pieces.Knight;
import com.kenny.classiq.pieces.Pawn;
import com.kenny.classiq.pieces.Piece;
import com.kenny.classiq.pieces.Queen;
import com.kenny.classiq.pieces.Rook;

/**
 * The <code>PieceSet</code> class represents the piece set of the
 * game, having all the pieces required to successfully complete a
 * normal chess game (the normal variant).
 * <p>
 * For the order of pieces in the piece set, please see {@link #piece}
 * @author Kenshin Himura  
 */
public class PieceSet
{
	/**
	 * Holds the pieces of the game in the following order:
	 * <ol>
	 * <li>00-47: WHITE pieces
	 * <ol>
	 * <li>00-07: Pawn
	 * <li>08-17: Knight
	 * <li>18-27: Bishop 
	 * <li>28-37: Rook
	 * <li>38-46: Queen
	 * <li>47-47: King
	 * </ol>
	 * <li>48-95: BLACK pieces
	 * <ol>
	 * <li>48-55: Pawn
	 * <li>56-65: Knight
	 * <li>66-75: Bishop 
	 * <li>76-85: Rook
	 * <li>86-94: Queen
	 * <li>95-95: King
	 * </ol>
	 * </ol>
	 * <p>
	 * Extra pieces have been provided so as to accomodate for
	 * promotion of a pawn to any other piece.
	 */
	private Piece[] piece;
	/**
	 * Gets a <code>Piece</code> of the specified characteristics, from the
	 * <code>PieceSet</code>.
	 * @param colour Colour ("black" or "white") of the <code>Piece</code>.
	 * @param pieceType Type of the <code>Piece</code>, eg.,
	 * "knight"
	 * @return The corresponding <code>Piece</code> from the
	 * <code>PieceSet</code>.
	 */
	public Piece getPiece(String colour, String pieceType)
	{
		pieceType.toLowerCase();
		Piece returnPiece=null;
		int index1=0,index2=7;
		if(pieceType.matches("knight"))
		{
			index1=8;
			index2=17;
		}
		if(pieceType.matches("bishop"))
		{
			index1=18;
			index2=27;
		}
		if(pieceType.matches("rook"))
		{
			index1=28;
			index2=37;
		}
		if(pieceType.matches("queen"))
		{
			index1=38;
			index2=46;
		}
		if(pieceType.matches("king"))
		{
			index1=47;
			index2=47;
		}
		if(colour.matches("black"))
		{
			index1+=48;
			index2+=48;
		}
		for(;index1<=index2;index1++)
			if(piece[index1]!=null)
			{
				returnPiece=piece[index1];
				piece[index1]=null;
				break;
			}
		if(returnPiece==null)
			return Piece.getPiece(colour,pieceType);
		return returnPiece;
	}
	/**
	 * Generic getter method to access a piece. Since the piece[] is a
	 * private data member, it should be accessed using a public getter
	 * method. Since getting all pieces is going to be useless, we can
	 * get specific pieces from the <code>PieceSet</code> using an index.
	 * @param index The index of the <code>Piece</code> queried.
	 * @return The <code>Piece</code> at the specified index.
	 */
	public Piece getPiece(int index)
	{
		Piece returnPiece=piece[index];//.clone();
		piece[index]=null;
		return returnPiece;
	}
	/**
	 * Places the piece in the piece table, calculating a specific
	 * index (location) for the placement.
	 * @param piece The <code>Piece</code> to be placed in the
	 * <code>PieceSet</code>
	 */
	public void setPiece(Piece piece)
	{
		int index1=0,index2=7;
		if(piece.getShortAlgebraicNotation()=="N")
		{
			index1=8;
			index2=17;
		}
		if(piece.getShortAlgebraicNotation()=="B")
		{
			index1=18;
			index2=27;
		}
		if(piece.getShortAlgebraicNotation()=="R")
		{
			index1=28;
			index2=37;
		}
		if(piece.getShortAlgebraicNotation()=="Q")
		{
			index1=38;
			index2=46;
		}
		if(piece.getShortAlgebraicNotation()=="K")
		{
			index1=47;
			index2=47;
		}
		if(!piece.isWhite())
		{
			index1+=48;
			index2+=48;
		}
		for(;index1<=index2;index1++)
			if(this.piece[index1]==null)
			{
				this.piece[index1]=piece;
				break;
			}
	}
	/**
	 * This is the constructor of the <code>PieceSet</code> belonging to a
	 * <code>Game</code>. Constructs the pieces as mentioned in {@link #piece}.
	 */
	public PieceSet()
	{
		piece=new Piece[96];
		for(int i=0;i<piece.length;i++)
		{
			if((i%48)>46)
				piece[i]=new King();
			else if((i%48)>37)
				piece[i]=new Queen();
			else if((i%48)>27)
				piece[i]=new Rook();
			else if((i%48)>17)
				piece[i]=new Bishop();
			else if((i%48)>7)
				piece[i]=new Knight();
			else
				piece[i]=new Pawn();
			if(i>47)
				piece[i].setWhite(false);
		}
	}
}