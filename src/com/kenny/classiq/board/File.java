package com.kenny.classiq.board;

public class File
{
	private Square[] square;
	private Board board;
	private String name;
	public File(String name)
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
	public Square getSquare(byte rankIndex)
	{
		if((rankIndex>-1)&&(rankIndex<8))
			return square[rankIndex];
		return null;
	}
}
