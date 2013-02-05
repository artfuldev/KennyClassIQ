package com.kenny.classiq.game;

import java.util.ArrayList;

import com.kenny.classiq.board.Board;
import com.kenny.classiq.board.Square;
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
	 * Holds the number of <code>Move</code>s made in the game.
	 * Incremented on every black <code>Move</code>, and decremented for every
	 * undo.
	 */
	int moveNumber=0;
	/**
	 * Holds the number of half-<code>Move</code>s made in the <code>Game</code>
	 * since the last <code>Pawn</code> advance or capture. This is used to
	 * determine if a draw can be claimed under the fifty-move rule, and is used
	 * in the generation and use of the FEN String. Declared as a byte because the
	 * maximum value it can take is 50.
	 */
	byte halfMoveClock=0;
	/**
	 * Holds the FEN String representing this <code>Game</code>. Is updated
	 * whenever the <code>Board</code> is updated, or whenever it is queried.
	 */
	private String fenString;
	/**
	 * Holds a boolean representing whether it is white's turn to move.
	 * May be used by the <code>Player</code>s, or may be used to generate
	 * the FEN String of this <code>Game</code>. Has a default value of
	 * <code>true</code>.
	 */
	private boolean whiteToMove=true;
	/**
	 * Holds a boolean representing whether white can castle kingside.
	 */
	private boolean whiteCastleKingside=false;
	/**
	 * Holds a boolean representing whether white can castle queenside.
	 */
	private boolean whiteCastleQueenside=false;
	/**
	 * Holds a boolean representing whether black can castle kingside.
	 */
	private boolean blackCastleKingside=false;
	/**
	 * Holds a boolean representing whether black can castle queenside.
	 */
	private boolean blackCastleQueenside=false;
	/**
	 * Holds a reference to the curent en-passant <code>Square</code> of
	 * the <code>Game</code>.
	 */
	private Square enPassantSquare;
	/**
	 * The <code>PieceSet</code> of the <code>Game</code>, which holds all
	 * the pieces necessary to play the <code>Game</code>. <code>Piece</code>s
	 * are taken from the <code>PieceSet</code> and placed on the
	 * <code>Square</code>s of the <code>Board</code>, and are returned
	 * during captures.
	 */
	private PieceSet pieceSet;
	/**
	 * This is the newer constructor of <code>Game</code> which takes a
	 * FEN String as a parameter in order to setup a new game that way.
	 * @param fenString The FEN String of the <code>Game</code> to be setup.
	 */
	public Game(String fenString)
	{
		gameBoard=new Board(this);
		lastMovedPiece=null;
		playerOne=new GUI(this,"white");
		playerTwo=new AI(this,"black");
		currentPlayer=playerOne;
		pieceSet=new PieceSet();
		moveList=new ArrayList<Move>();
		this.fenString=fenString;
		String[] fenTokens=fenString.split("\\s");
		char[] positionString=fenTokens[0].toCharArray();
		for(byte i=0,rankIndex=7,fileIndex=0;i<positionString.length;i++)
		{
			byte index=(byte)((rankIndex*8)+fileIndex);
			if(positionString[i]=='k')
				gameBoard.setPiece(pieceSet.getPiece("black","king"),index);
			else if(positionString[i]=='K')
				gameBoard.setPiece(pieceSet.getPiece("white","king"),index);
			else if(positionString[i]=='q')
				gameBoard.setPiece(pieceSet.getPiece("black","queen"),index);
			else if(positionString[i]=='Q')
				gameBoard.setPiece(pieceSet.getPiece("white","queen"),index);
			else if(positionString[i]=='b')
				gameBoard.setPiece(pieceSet.getPiece("black","bishop"),index);
			else if(positionString[i]=='B')
				gameBoard.setPiece(pieceSet.getPiece("white","bishop"),index);
			else if(positionString[i]=='n')
				gameBoard.setPiece(pieceSet.getPiece("black","knight"),index);
			else if(positionString[i]=='N')
				gameBoard.setPiece(pieceSet.getPiece("white","knight"),index);
			else if(positionString[i]=='r')
				gameBoard.setPiece(pieceSet.getPiece("black","rook"),index);
			else if(positionString[i]=='R')
				gameBoard.setPiece(pieceSet.getPiece("white","rook"),index);
			else if(positionString[i]=='p')
				gameBoard.setPiece(pieceSet.getPiece("black","pawn"),index);
			else if(positionString[i]=='P')
				gameBoard.setPiece(pieceSet.getPiece("queen","pawn"),index);
			else if(positionString[i]=='/')
			{
				rankIndex--;
				fileIndex=-1;
			}
			else
			{
				String tempString=positionString[i]+"";
				fileIndex+=Byte.parseByte(tempString)-1;
			}
			fileIndex++;
		}
		if(fenTokens[1]!="w")
			whiteToMove=false;
		if(fenTokens[2].contains("K"))
			whiteCastleKingside=true;
		if(fenTokens[2].contains("Q"))
			whiteCastleQueenside=true;
		if(fenTokens[2].contains("k"))
			blackCastleKingside=true;
		if(fenTokens[2].contains("q"))
			blackCastleQueenside=true;
		if(fenTokens[3]!="-")
			setEnPassantSquare(gameBoard.getSquare(fenTokens[3]));
		halfMoveClock=Byte.parseByte(fenTokens[4]);
		moveNumber=Integer.parseInt(fenTokens[5]);
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
	public int getMoveNumber()
	{
		return moveNumber;
	}
	public void setMoveNumber(int moveNumber)
	{
		this.moveNumber = moveNumber;
	}
	public byte getHalfMoveClock()
	{
		return halfMoveClock;
	}
	public void setHalfMoveClock(byte halfMoveClock)
	{
		this.halfMoveClock = halfMoveClock;
	}
	public String getFenString()
	{
		return fenString;
	}
	public void setFenString(String fenString)
	{
		this.fenString = fenString;
	}
	public Square getEnPassantSquare()
	{
		return enPassantSquare;
	}
	public void setEnPassantSquare(Square enPassantSquare)
	{
		this.enPassantSquare = enPassantSquare;
	}
	public boolean isWhiteToMove() {
		return whiteToMove;
	}
	public void setWhiteToMove(boolean whiteToMove) {
		this.whiteToMove = whiteToMove;
	}
	public boolean isWhiteCastleKingside() {
		return whiteCastleKingside;
	}
	public void setWhiteCastleKingside(boolean whiteCastleKingside) {
		this.whiteCastleKingside = whiteCastleKingside;
	}
	public boolean isWhiteCastleQueenside() {
		return whiteCastleQueenside;
	}
	public void setWhiteCastleQueenside(boolean whiteCastleQueenside) {
		this.whiteCastleQueenside = whiteCastleQueenside;
	}
	public boolean isBlackCastleKingside() {
		return blackCastleKingside;
	}
	public void setBlackCastleKingside(boolean blackCastleKingside) {
		this.blackCastleKingside = blackCastleKingside;
	}
	public boolean isBlackCastleQueenside() {
		return blackCastleQueenside;
	}
	public void setBlackCastleQueenside(boolean blackCastleQueenside) {
		this.blackCastleQueenside = blackCastleQueenside;
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