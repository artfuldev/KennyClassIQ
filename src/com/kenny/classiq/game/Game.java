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
		gameBoard=new Board(this);
		lastMovedPiece=null;
		playerOne=new Player(this,"white","gui");
		playerTwo=new Player(this,"black","ai");
		currentPlayer=playerTwo;
		pieceSet=new PieceSet();
	}
	public void newGame()
	{
		for(byte i=8;i<16;i++)
			gameBoard.setPiece(pieceSet.getPiece("white","pawn"),i);
		for(byte i=48;i<56;i++)
			gameBoard.setPiece(pieceSet.getPiece("black","pawn"),i);
		gameBoard.setPiece(pieceSet.getPiece("white","rook"),"a1");
		gameBoard.setPiece(pieceSet.getPiece("white","rook"),"h1");
		gameBoard.setPiece(pieceSet.getPiece("black","rook"),"a8");
		gameBoard.setPiece(pieceSet.getPiece("black","rook"),"h8");
		gameBoard.setPiece(pieceSet.getPiece("white","knight"),"b1");
		gameBoard.setPiece(pieceSet.getPiece("white","knight"),"g1");
		gameBoard.setPiece(pieceSet.getPiece("black","knight"),"b8");
		gameBoard.setPiece(pieceSet.getPiece("black","knight"),"g8");
		gameBoard.setPiece(pieceSet.getPiece("white","bishop"),"c1");
		gameBoard.setPiece(pieceSet.getPiece("white","bishop"),"f1");
		gameBoard.setPiece(pieceSet.getPiece("black","bishop"),"c8");
		gameBoard.setPiece(pieceSet.getPiece("black","bishop"),"f8");
		gameBoard.setPiece(pieceSet.getPiece("white","queen"),"d1");
		gameBoard.setPiece(pieceSet.getPiece("white","king"),"e1");
		gameBoard.setPiece(pieceSet.getPiece("black","queen"),"d8");
		gameBoard.setPiece(pieceSet.getPiece("black","king"),"e8");
	}
	public void showBoard()
	{
		gameBoard.printBoard();
	}
}