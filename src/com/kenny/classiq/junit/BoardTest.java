package com.kenny.classiq.junit;

import org.junit.Test;

import com.kenny.classiq.board.Board;
import com.kenny.classiq.pieces.Knight;
import com.kenny.classiq.pieces.Piece;

public class BoardTest
{
	@Test
	public void test()
	{
		Board board=new Board();
		Piece whiteKnight=new Knight();
		Piece blackKnight=new Knight();
		blackKnight.setWhite(false);
		board.setPiece(whiteKnight, "g1");
		board.setPiece(blackKnight, "g8");
		board.printBoard();
	}
}
