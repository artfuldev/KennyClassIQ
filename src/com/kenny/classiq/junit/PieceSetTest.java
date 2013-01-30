package com.kenny.classiq.junit;

import static org.junit.Assert.*;
import org.junit.Test;
import com.kenny.classiq.game.PieceSet;

public class PieceSetTest
{
	@Test
	public void testPieceSet()
	{
		PieceSet pieceSet=new PieceSet();
		assertEquals("Done",pieceSet.getPiece(12).toString(),
				pieceSet.getPiece("white","knight").toString());
	}
}