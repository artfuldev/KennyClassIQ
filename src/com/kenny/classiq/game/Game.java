package com.kenny.classiq.game;

import com.kenny.classiq.board.Board;
import com.kenny.classiq.move.Move;
import com.kenny.classiq.pieces.Piece;

public class Game
{
	private Board gameBoard;
	private Piece lastMovedPiece;
	private Move lastMove;
	private Move[] moveStack[];
}