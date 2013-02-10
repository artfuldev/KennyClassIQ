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
