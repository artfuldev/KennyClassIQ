package com.kenny.classiq.board;

public class Diagonal
{
	private Square[] square;
	private Board board;
	private String name;
	public Diagonal(String name)
	{
		setName(name);
		//variable, calculate first
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
}
