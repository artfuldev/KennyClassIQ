/*
 * This file is part of "Kenny ClassIQ", (c) Kenshin Himura, 2013.
 * 
 * "Kenny ClassIQ" is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * "Kenny ClassIQ" is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with "Kenny ClassIQ".  If not, see <http://www.gnu.org/licenses/>.
 * 
 */

package com.kenny.classiq.game;

import java.util.ArrayList;

import com.kenny.classiq.board.Board;
import com.kenny.classiq.board.Square;
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
 * @author Kenshin Himura  
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
	 * Holds the list of <code>Move</code>s made in the game. May be used to
	 * replay the <code>Game</code>, if such features are necessary later.
	 * Removed lastMove because it can be accest from this moveList itself.
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
	private boolean whiteToMove;
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
		whiteToMove=true;
		playerOne=new GUI(this,"white");
		playerTwo=new AI(this,"black");
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
		if(fenTokens[1].matches("b"))
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
	 * This is a function of <code>Game</code> which takes a FEN String as
	 * a parameter in order to setup a game that way.
	 * @param fenString The FEN String of the <code>Game</code> to be setup.
	 */
	public void setFen(String fenString)
	{
		gameBoard=new Board(this);
		whiteToMove=true;
		playerOne=new GUI(this,"white");
		playerTwo=new AI(this,"black");
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
		if(fenTokens[1].matches("b"))
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
	/**
	 * Generic getter method. Since pieceSet is a private variable, it has
	 * to be accessed using a public getter method. This follows the rules
	 * of data abstraction, thus OOPS in general.
	 * @return The <code>PieceSet</code> of this <code>Game</code>.
	 */
	public PieceSet getPieceSet()
	{
		return pieceSet;
	}
	/**
	 * Generic setter method, used to set the private variable pieceSet.
	 * Almost never used. Simply defined as good programming practice, so
	 * that we have it when we need it (if at all).
	 * @param pieceSet The <code>PieceSet</code> of this <code>Game</code>. 
	 */
	public void setPieceSet(PieceSet pieceSet)
	{
		this.pieceSet=pieceSet;
	}
	/**
	 * Generic getter method. Since currentPlayer is a private variable, it
	 * has to be accessed using a public getter method. This follows the
	 * rules of data abstraction, thus OOPS in general.
	 * @return The current <code>Player</code> of this <code>Game</code>.
	 */
	public Player getCurrentPlayer()
	{
		if(whiteToMove)
			return playerOne;
		return playerTwo;
	}
	/**
	 * Generic getter method. Since playerOne is a private variable, it has
	 * to be accessed using a public getter method. This follows the rules
	 * of data abstraction, thus OOPS in general.
	 * @return The first <code>Player</code> of this <code>Game</code>.
	 */
	public Player getPlayerOne()
	{
		return playerOne;
	}
	/**
	 * Generic setter method, used to set the private variable playerOne.
	 * Almost never used. Simply defined as good programming practice, so
	 * that we have it when we need it (if at all).
	 * @param playerOne The first <code>Player</code> of this <code>Game
	 * </code>. 
	 */
	public void setPlayerOne(Player playerOne)
	{
		this.playerOne=playerOne;
	}
	/**
	 * Generic getter method. Since playerTwo is a private variable, it has
	 * to be accessed using a public getter method. This follows the rules
	 * of data abstraction, thus OOPS in general.
	 * @return The second <code>Player</code> of this <code>Game</code>.
	 */
	public Player getPlayerTwo()
	{
		return playerTwo;
	}
	/**
	 * Generic setter method, used to set the private variable playerTwo.
	 * Almost never used. Simply defined as good programming practice, so
	 * that we have it when we need it (if at all).
	 * @param playerTwo The second <code>Player</code> of this <code>Game
	 * </code>. 
	 */
	public void setPlayerTwo(Player playerTwo)
	{
		this.playerTwo=playerTwo;
	}
	/**
	 * Generic getter method. Since moveList is a private variable, it has
	 * to be accessed using a public getter method. This follows the rules
	 * of data abstraction, thus OOPS in general.
	 * @return The <code>ArrayList</code> of <code>Move</code>s of this
	 * <code>Game</code>.
	 */
	public ArrayList<Move> getMoveList()
	{
		return moveList;
	}
	/**
	 * Generic setter method, used to set the private variable moveList.
	 * Almost never used. Simply defined as good programming practice, so
	 * that we have it when we need it (if at all).
	 * @param moveList The <code>ArrayList</code> of <code>Move</code>
	 * of this <code>Game</code>. 
	 */
	public void setMoveList(ArrayList<Move> moveList)
	{
		this.moveList=moveList;
	}
	/**
	 * Generic getter method. Since moveNumber is a private variable, it has
	 * to be accessed using a public getter method. This follows the rules
	 * of data abstraction, thus OOPS in general.
	 * @return The move number of this <code>Game</code>.
	 */
	public int getMoveNumber()
	{
		return moveNumber;
	}
	/**
	 * Generic setter method, used to set the private variable moveNumber.
	 * Used to alter the moveNumber while making and un-making <code>Move
	 * </code>s.
	 * @param moveNumber The moveNumber of the next <code>Move</code> of
	 * this <code>Game</code>. 
	 */
	public void setMoveNumber(int moveNumber)
	{
		this.moveNumber = moveNumber;
	}
	/**
	 * Generic getter method. Since halfMoveClock is a private variable, it
	 * has to be accessed using a public getter method. This follows the rules
	 * of data abstraction, thus OOPS in general.
	 * @return The halfMoveClosk of this <code>Game</code>, as a <code>byte
	 * </code>.
	 */
	public byte getHalfMoveClock()
	{
		return halfMoveClock;
	}
	/**
	 * Generic setter method, used to set the private variable halfMoveClock.
	 * Used to alter the moveNumber while making and un-making <code>Move
	 * </code>s.
	 * @param halfMoveClock The half-move clock of this <code>Game</code>,
	 * as a <code>byte</code>. 
	 */
	public void setHalfMoveClock(byte halfMoveClock)
	{
		this.halfMoveClock = halfMoveClock;
	}
	/**
	 * Generic getter method. Since fenString is a private variable, it has
	 * to be accessed using a public getter method. This follows the rules
	 * of data abstraction, thus OOPS in general.
	 * @return The FEN <code>String</code> of this <code>Game</code>.
	 */
	public String getFenString()
	{
		return fenString;
	}
	/**
	 * Generic setter method, used to set the private variable fenString.
	 * Almost never used. Simply defined as good programming practice, so
	 * that we have it when we need it (if at all).
	 * @param fenString The <code>String</code> of this <code>Game</code>. 
	 */
	public void setFenString(String fenString)
	{
		this.fenString = fenString;
	}
	/**
	 * Generic getter method. Since enPassantSquare is a private variable,
	 * it has to be accessed using a public getter method. This follows the
	 * rules of data abstraction, thus OOPS in general.
	 * @return The en-passant <code>Square</code> of this <code>Game</code>.
	 */
	public Square getEnPassantSquare()
	{
		return enPassantSquare;
	}
	/**
	 * Generic setter method, used to set the private variable enPassantSquare.
	 * Used to set and reset the enPassantSquare while making and un-making
	 * <code>Move</code>s.
	 * @param enPassantSquare The <code>Square</code> representing the en-passant
	 * square of this <code>Game</code>. 
	 */
	public void setEnPassantSquare(Square enPassantSquare)
	{
		this.enPassantSquare = enPassantSquare;
	}
	/**
	 * Generic getter method. Since whiteToMove is a private variable, it has
	 * to be accessed using a public getter method. This follows the rules
	 * of data abstraction, thus OOPS in general.
	 * @return <code>true</code> if it is white's turn to move.
	 */
	public boolean isWhiteToMove()
	{
		return whiteToMove;
	}
	/**
	 * Generic setter method, used to set the private variable whiteToMove,
	 * while making and unmaking <code>Move</code>s.
	 * @param whiteToMove <code>false</code> if it is black's turn to move.
	 */
	public void setWhiteToMove(boolean whiteToMove)
	{
		this.whiteToMove = whiteToMove;
	}
	/**
	 * Generic getter method. Since whiteCastleKingside is a private variable,
	 * it has to be accessed using a public getter method. This follows the
	 * rules of data abstraction, thus OOPS in general.
	 * @return <code>true</code> if white can castle on its kingside.
	 */
	public boolean isWhiteCastleKingside()
	{
		return whiteCastleKingside;
	}
	/**
	 * Generic setter method, used to set the private variable
	 * whiteCastleKingside, while making and unmaking <code>Move</code>s.
	 * @param whiteCastleKingside <code>true</code> if white can castle
	 * on its kingside.
	 */
	public void setWhiteCastleKingside(boolean whiteCastleKingside)
	{
		this.whiteCastleKingside = whiteCastleKingside;
	}
	/**
	 * Generic getter method. Since whiteCastleQueenside is a private variable,
	 * it has to be accessed using a public getter method. This follows the
	 * rules of data abstraction, thus OOPS in general.
	 * @return <code>true</code> if white can castle on its queenside.
	 */
	public boolean isWhiteCastleQueenside()
	{
		return whiteCastleQueenside;
	}
	/**
	 * Generic setter method, used to set the private variable
	 * whiteCastleQueenside, while making and unmaking <code>Move</code>s.
	 * @param whiteCastleQueenside <code>true</code> if white can castle
	 * on its queenside.
	 */
	public void setWhiteCastleQueenside(boolean whiteCastleQueenside)
	{
		this.whiteCastleQueenside = whiteCastleQueenside;
	}
	/**
	 * Generic getter method. Since blackCastleKingside is a private variable,
	 * it has to be accessed using a public getter method. This follows the
	 * rules of data abstraction, thus OOPS in general.
	 * @return <code>true</code> if black can castle on its kingside.
	 */
	public boolean isBlackCastleKingside()
	{
		return blackCastleKingside;
	}
	/**
	 * Generic setter method, used to set the private variable
	 * blackCastleKingside, while making and unmaking <code>Move</code>s.
	 * @param blackCastleKingside <code>true</code> if black can castle
	 * on its kingside.
	 */
	public void setBlackCastleKingside(boolean blackCastleKingside)
	{
		this.blackCastleKingside = blackCastleKingside;
	}
	/**
	 * Generic getter method. Since blackCastleQueenside is a private variable,
	 * it has to be accessed using a public getter method. This follows the
	 * rules of data abstraction, thus OOPS in general.
	 * @return <code>true</code> if black can castle on its queenside.
	 */
	public boolean isBlackCastleQueenside()
	{
		return blackCastleQueenside;
	}
	/**
	 * Generic setter method, used to set the private variable
	 * blackCastleQueenside, while making and unmaking <code>Move</code>s.
	 * @param blackCastleQueenside <code>true</code> if black can castle
	 * on its queenside.
	 */
	public void setBlackCastleQueenside(boolean blackCastleQueenside)
	{
		this.blackCastleQueenside = blackCastleQueenside;
	}
	/**
	 * Prints the list of <code>Move</code>s made by the <code>Player
	 * </code>s of this <code>Game</code>, along with the move numbers
	 * when required.
	 */
	public void printMainLine()
	{
		if(moveList.isEmpty())
			System.out.print("No moves made yet...");
		else
			for(int i=0;i<moveList.size();i++)
				System.out.print(moveList.get(i)+" ");
		System.out.println();
	}
	public void printStats()
	{
		showBoard();
		printMainLine();
		System.out.println("White to move: "+isWhiteToMove());
		System.out.println("En Passant Square: "+enPassantSquare);
		System.out.println("Score: "+gameBoard.getScore(true));
	}
}