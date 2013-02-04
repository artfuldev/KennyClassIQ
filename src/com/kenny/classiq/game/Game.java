package com.kenny.classiq.game;

import java.util.ArrayList;

import com.kenny.classiq.board.Board;
import com.kenny.classiq.pieces.Piece;
import com.kenny.classiq.players.AI;
import com.kenny.classiq.players.GUI;
import com.kenny.classiq.players.Player;

/**
 * The <code>Game</code> class holds the information regarding the game, and
 * also has objects of classes related to the <code>Game</code>. As this is
 * a chess game, it holds a <code>Board</code>, two <code>Player</code>s, a
 * reference to the current <code>Player</code>, the last <code>Move</code>,
 * the list of <code>Move</code>s made so far, a <code>PieceSet</code> which
 * holds all the pieces of the <code>Game</code>, and a reference to the last
 * moved <code>Piece</code>.
 * @author Kenshin Himura (Sudarsan Balaji)
 *
 */
public class Game
{
	/**
	 * Holds the <code>Board</code> of the <code>Game</code>, only one instance,
	 * gets updated as the game progresses with each half-<code>Move</code>.
	 */
	private Board gameBoard;
	/**
	 * Holds a reference to the last-moved <code>Piece</code> of the
	 * <code>Game</code>. May be used for some things later on.
	 */
	private Piece lastMovedPiece;
	/**
	 * Holds the first <code>Player</code> of the <code>Game</code>. Usually
	 * white, but can be changed. Initialized during construction. And usually
	 * the GUI (or user).
	 */
	private Player playerOne;
	/**
	 * Holds the second <code>Player</code> of the <code>Game</code>. Usually
	 * black, but can be changed. Initialized during construction. And usually
	 * the AI.
	 */
	private Player playerTwo;
	/**
	 * Holds a reference to the current <code>Player</code> of the
	 * <code>Game</code>. Is used to switch the players between turns.
	 */
	private Player currentPlayer;
	/**
	 * Holds a reference to the last <code>Move</code> made in the game.
	 * May be used to set the en-passant <code>Square</code> later, in the
	 * FEN String.
	 */
	private Move lastMove;
	/**
	 * Holds the list of <code>Move</code>s made in the game. May be used to
	 * replay the <code>Game</code>, if such features are necessary later.
	 */
	private ArrayList<Move> moveList;
	/**
	 * Holds the number of half-<code>Move</code>s made in the game.
	 * When divided by 2, gives the number of <code>Move</code>s made.
	 * Incremented on every <code>Move</code>, and decremented for every
	 * undo. If %2 of this is 1, it is black's turn, else it is white's.
	 * Hence used to keep a record of the turn number. Incidentally it is
	 * also equal to <code>moveList.size()</code>.
	 */
	int halfMoveNumber=0;
	/**
	 * The <code>PieceSet</code> of the <code>Game</code>, which holds all
	 * the pieces necessary to play the <code>Game</code>. <code>Piece</code>s
	 * are taken from the <code>PieceSet</code> and placed on the
	 * <code>Square</code>s of the <code>Board</code>, and are returned
	 * during captures.
	 */
	private PieceSet pieceSet;
	/**
	 * Default constructor of <code>Game</code>. Creates all objects within the
	 * <code>Game</code> and initializes them.
	 */
	public Game()
	{
		gameBoard=new Board(this);
		lastMovedPiece=null;
		playerOne=new GUI(this,"white");
		playerTwo=new AI(this,"black");
		currentPlayer=playerOne;
		pieceSet=new PieceSet();
		moveList=new ArrayList<Move>();
		setupBoard();
	}
	/**
	 * Generic getter method used to access the private data member
	 * gameBoard. Useful in many cases like move generation.
	 * @return The <code>Board</code> of this <code>Game</code>.
	 */
	public Board getGameBoard()
	{
		return gameBoard;
	}
	/**
	 * This method is used to set up a "new game" position. <code>Board</code>
	 * positions are reset, and the references are changed. Called
	 * from the default <code>Game</code> constructor.
	 */
	public void setupBoard()
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
	/**
	 * Used to display the <code>Board</code> of the <code>Game</code>.
	 * Simply calls the printBoard() method of the <code>Board</code>.
	 */
	public void showBoard()
	{
		gameBoard.printBoard();
	}
	public PieceSet getPieceSet()
	{
		return pieceSet;
	}
	public Player getCurrentPlayer()
	{
		return currentPlayer;
	}
	public void setCurrentPlayer(Player currentPlayer)
	{
		this.currentPlayer = currentPlayer;
	}
	public Player getPlayerOne()
	{
		return playerOne;
	}
	public Player getPlayerTwo()
	{
		return playerTwo;
	}
	public ArrayList<Move> getMoveList()
	{
		return moveList;
	}
	public int getHalfMoveNumber()
	{
		return halfMoveNumber;
	}
	public void setHalfMoveNumber(int halfMoveNumber)
	{
		this.halfMoveNumber = halfMoveNumber;
	}
	public void printMainLine()
	{
		if(moveList.isEmpty())
			System.out.print("No moves");
		else
			for(int i=0;i<moveList.size();i++)
			{
				if(i%2==0)
					System.out.print(i+1);
				System.out.print(" ");
				System.out.print(moveList.get(i));
			}
		System.out.println();
	}
}