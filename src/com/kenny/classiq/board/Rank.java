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

public class Rank
{
	private Square[] square;
	private Board board;
	private String name;
	public Rank(String name)
	{
		setName(name);
		square=new Square[8];
	}
	public Square getSquare(String squareName)
	{
		for(int i=0;i<square.length;i++)
			if(square[i].getName().matches(squareName))
				return square[i];
		return null;
	}
	public void setSquare(Square square, byte index)
	{
		this.square[index] = square;
	}
	public Board getBoard()
	{
		return board;
	}
	public void setBoard(Board board)
	{
		this.board = board;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public void printRank()
	{
		String printString;
		for(int i=0;i<8;i++)
		{
			if(square[i].getPiece()!=null)
			{
				printString=square[i].getPiece().getShortAlgebraicNotation();
				if(!square[i].getPiece().isWhite())
					printString=printString.toLowerCase();
			}
			else
				printString="-";
			System.out.print(printString+"  ");
		}
		System.out.print("\n");
	}
	public Square getSquare(byte fileIndex)
	{
		if((fileIndex>-1)&&(fileIndex<8))
			return square[fileIndex];
		return null;
	}
}
