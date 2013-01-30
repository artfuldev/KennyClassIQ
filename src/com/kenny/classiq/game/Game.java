package com.kenny.classiq.game;

import com.kenny.classiq.board.Board;
import com.kenny.classiq.pieces.Piece;

public class Game
{
	private Board gameBoard;
	private Piece lastMovedPiece;
	private Player playerOne;
	private Player playerTwo;
	private Player currentPlayer;
	private Move lastMove;
	private Move[] moveStack[];
	private PieceSet pieceSet;
	public Game()
	{
		gameBoard=new Board();
		lastMovedPiece=null;
		playerOne=new Player(this,"white","gui");
		playerTwo=new Player(this,"black","ai");
		currentPlayer=playerTwo;
	}
}