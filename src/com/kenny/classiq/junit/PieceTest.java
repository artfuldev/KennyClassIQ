package com.kenny.classiq.junit;

import static org.junit.Assert.*;
import org.junit.Test;
import com.kenny.classiq.pieces.Knight;
import com.kenny.classiq.pieces.Piece;

public class PieceTest
{
	@Test
	public void test()
	{
		Piece knightPiece=new Knight();
		assertEquals("Right",knightPiece.getShortAlgebraicNotation(),"N");
	}

}
