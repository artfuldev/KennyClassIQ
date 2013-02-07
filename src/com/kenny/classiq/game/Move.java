package com.kenny.classiq.game;

import com.kenny.classiq.board.Board;
import com.kenny.classiq.board.Square;
import com.kenny.classiq.pieces.Piece;

/**
 * The <code>Move</code> class is the class used to represent a chess move.
 * Since in chess, a move involves a piece moving from one square to the
 * next, objects of type move contain these items. In addition to this,
 * certain special moves like castling and check and mate require the
 * definition of additional elements in the <code>toString()</code>
 * function.
 * @author Kenshin Himura (Sudarsan Balaji)
 *
 */
public class Move
{
	/**
	 * Holds the piece which was moved in the current move (half-move).
	 * Since no move in chess can be made without moving a piece from
	 * one square to the next, this is important.
	 */
	private Piece pieceMoved;
	/**
	 * Holds the piece which was captured in the current move (half-move).
	 * This is used to transfer the <code>Piece</code> from the <code>Board
	 * </code> to the <code>PieceSet</code> during makeMove(), and then back
	 * during unmakeMove().
	 */
	private Piece capturedPiece=null;
	/**
	 * Holds the square from which the piece was moved in the current
	 * move (half-move). Since no move in chess can be made without
	 * moving a piece from one square to the next, this is important.
	 */
	private Square fromSquare;
	/**
	 * Holds the square to which the piece was moved in the current
	 * move (half-move). Since no move in chess can be made without
	 * moving a piece from one square to the next, this is important.
	 */
	private Square toSquare;
	/**
	 * Holds the number of half-<code>Move</code>s made in the <code>Game</code>
	 * since the last <code>Pawn</code> advance or capture. This is used to
	 * determine if a draw can be claimed under the fifty-move rule, and is used
	 * during unMakeMove to restore the previous value. Declared as a byte
	 * because the maximum value it can take is 50.
	 */
	private byte halfMoveClock=0;
	/**
	 * Holds a boolean representing whether white can castle kingside. To
	 * be restored during unMakeMove, if at all reset.
	 */
	boolean whiteCastleKingside=false;
	/**
	 * Holds a boolean representing whether white can castle queenside. To
	 * be restored during unMakeMove, if at all reset.
	 */
	boolean whiteCastleQueenside=false;
	/**
	 * Holds a boolean representing whether black can castle kingside. To
	 * be restored during unMakeMove, if at all reset.
	 */
	boolean blackCastleKingside=false;
	/**
	 * Holds a boolean representing whether black can castle queenside. To
	 * be restored during unMakeMove, if at all reset.
	 */
	boolean blackCastleQueenside=false;
	/**
	 * Holds the en-passant <code>Square</code> of the <code>Game</code>
	 * before this <code>Move</code>, so that it can be restored during
	 * unMakeMove.
	 */
	private Square enPassantSquare=null;
	/**
	 * Holds the string which represents the move in simple WinBoard
	 * notation, eg, "e2e4". This should be sent to the GUI as a command,
	 * if the engine wants to play this move.
	 * This is different from the toString() of <code>Move</code>, which
	 * sends the viewable output to the GUI (in the PV).  
	 */
	private String moveString;
	/**
	 * Holds a reference to the <code>Board</code> on which the
	 * <code>Move</code> is made.
	 */
	private Board board;
	/**
	 * Holds a boolean value specifying if the move is a checking move,
	 * or not. Calculated during of after construction.
	 */
	private boolean checkingMove=false;
	/**
	 * Holds a boolean value specifying if the move is a mating move,
	 * or not. Calculated during of after construction.
	 */
	private boolean matingMove=false;
	/**
	 * Holds a boolean value specifying if the move is a move involving
	 * the capture of an opponent piece or not.
	 */
	private boolean capturingMove=false;
	/**
	 * Default Constructor of <code>Move</code>.
	 */
	public Move()
	{
		
	}
	/**
	 * This is the constructor of <code>Mode</code> which sets a
	 * reference to the <code>Board</code> on which the <code>Move</code>
	 * is made. This is necessary if the references to the
	 * <code>Square</code>s making up the <code>Move</code> are unavailable,
	 * as the reference to the <code>Board</code> through them is also
	 * lost. 
	 */
	public Move(Board boardReference)
	{
		this.board=boardReference;
	}
	/**
	 * Constructor of the <code>Move</code> class. Gets a reference to two
	 * square objects, which may or may not be of the same <code>Board</code>,
	 * but represent the squares from and to which the piece moved in the
	 * move respectively, in that order. 
	 * @param fromSquare Square from which piece of the <code>Move</code> moved.
	 * @param toSquare Squared to which piece of the <code>Move</code> moved.
	 */
	public Move(Square fromSquare,Square toSquare)
	{
		this.fromSquare=fromSquare;
		this.toSquare=toSquare;
		pieceMoved=fromSquare.getPiece();
		moveString=fromSquare.getName()+toSquare.getName();
		board=fromSquare.getBoard();
		capturedPiece=toSquare.getPiece();
		if(capturedPiece!=null)
			capturingMove=true;
		if(pieceMoved.getClass().getName().matches("Pawn")||
			capturingMove)
			halfMoveClock=board.getGame().getHalfMoveClock();
		whiteCastleKingside=board.getGame().isWhiteCastleKingside();
		whiteCastleQueenside=board.getGame().isWhiteCastleQueenside();
		blackCastleKingside=board.getGame().isBlackCastleKingside();
		blackCastleQueenside=board.getGame().isBlackCastleQueenside();
	}
	/**
	 * Generic getter method of the variable pieceMoved. Since its a
	 * private variable, a public getter method has to be used to access
	 * it. Stays true to the concept of data abstraction.
	 * @return The <code>Piece</code> moved.
	 */
	public Piece getPieceMoved()
	{
		return pieceMoved;
	}
	/**
	 * Generic setter method of the variable pieceMoved. Since its a
	 * private variable, a public getter method has to be used to access
	 * it. Stays true to the concept of data abstraction.
	 * @param pieceMoved The <code>Piece</code> moved.
	 */
	public void setPieceMoved(Piece pieceMoved)
	{
		this.pieceMoved = pieceMoved;
	}
	/**
	 * Generic getter method of the variable pieceMoved. Since its a
	 * private variable, a public getter method has to be used to access
	 * it. Stays true to the concept of data abstraction.
	 * @return The <code>Piece</code> captured during the move.
	 */
	public Piece getCapturedPiece()
	{
		return capturedPiece;
	}
	/**
	 * Generic setter method of the variable pieceMoved. Since its a
	 * private variable, a public getter method has to be used to access
	 * it. Stays true to the concept of data abstraction. It is used to
	 * restore the board during unmakeMove().
	 * @param capturedPiece The <code>Piece</code> captured.
	 */
	public void setCapturedPiece(Piece capturedPiece)
	{
		this.capturedPiece = capturedPiece;
	}
	/**
	 * Generic getter method to access the private member fromSquare.
	 * It has been defined as good programming practice, and has not
	 * been used at the time of writing.
	 * @return The source (opposite of destination, yes) <code>square</code>
	 * of the <code>Move</code>.
	 */
	public Square getFromSquare()
	{
		return fromSquare;
	}
	/**
	 * Generic setter method used to set a reference to the fromSquare
	 * variable of the <code>Move</code> class. Since it is private,
	 * accessing it using getter and setter methods is recommended.
	 * @param fromSquare The source (opposite of destination, yes)
	 * <code>Square</code> of the <code>Move</code>
	 */
	public void setFromSquare(Square fromSquare)
	{
		this.fromSquare = fromSquare;
		moveString="";
		moveString+=fromSquare.getName();
		pieceMoved=fromSquare.getPiece();
		if(toSquare!=null)
		{
			moveString+=toSquare.getName();
			capturedPiece=toSquare.getPiece();
			if(capturedPiece!=null)
				this.capturingMove=true;
		}
		board=fromSquare.getBoard();
		if(pieceMoved.getClass().getName().matches("Pawn")||
				capturingMove)
				halfMoveClock=board.getGame().getHalfMoveClock();
		whiteCastleKingside=board.getGame().isWhiteCastleKingside();
		whiteCastleQueenside=board.getGame().isWhiteCastleQueenside();
		blackCastleKingside=board.getGame().isBlackCastleKingside();
		blackCastleQueenside=board.getGame().isBlackCastleQueenside();
		enPassantSquare=board.getGame().getEnPassantSquare();
	}
	/**
	 * Generic getter method to access the private member toSquare.
	 * It has been defined as good programming practice, and has not
	 * been used at the time of writing.
	 * @return The destination <code>Square</code> of the <code>Move</code>.
	 */
	public Square getToSquare()
	{
		return toSquare;
	}
	/**
	 * Generic setter method used to set a reference to the fromSquare
	 * variable of the <code>Move</code> class. Since it is private,
	 * accessing it using getter and setter methods is recommended.
	 * @param toSquare The destination <code>Square</code> of the
	 * <code>Move</code>.
	 */
	public void setToSquare(Square toSquare)
	{
		this.toSquare = toSquare;
		moveString="";
		capturedPiece=toSquare.getPiece();
		if(capturedPiece!=null)
			capturingMove=true;
		if(fromSquare!=null)
			moveString+=fromSquare.getName();
		moveString+=toSquare.getName();
		if(pieceMoved.getClass().getName().matches("Pawn")||
				capturingMove)
				halfMoveClock=board.getGame().getHalfMoveClock();
		whiteCastleKingside=board.getGame().isWhiteCastleKingside();
		whiteCastleQueenside=board.getGame().isWhiteCastleQueenside();
		blackCastleKingside=board.getGame().isBlackCastleKingside();
		blackCastleQueenside=board.getGame().isBlackCastleQueenside();
	}
	/**
	 * This method is used to access the private data member hence
	 * defined as a simple getter method. Tells us if the move is a
	 * move which checks the opponent <code>King</code> or not.
	 * @return <code>true</code> if a checking move, false otherwise.
	 */
	public boolean isCheckingMove()
	{
		return checkingMove;
	}
	/**
	 * This method is used to access the private data member hence
	 * defined as a simple getter method. Used to tell the <code>Move
	 * </code> class if the move is a move which checks the opponent
	 * <code>King</code> or not. Since the defualt value is <code>false
	 * </code>, it should be called only during setting.
	 * @param checkingMove <code>true</code> if a checking move
	 */
	public void setCheckingMove(boolean checkingMove)
	{
		this.checkingMove = checkingMove;
	}
	/**
	 * This method is used to access the private data member hence
	 * defined as a simple getter method. Tells us if the move is a
	 * move which checkmates the opponent or not.
	 * @return <code>true</code> if a mating move, false otherwise.
	 */
	public boolean isMatingMove()
	{
		return matingMove;
	}
	/**
	 * This method is used to access the private data member hence
	 * defined as a simple getter method. Used to tell the <code>Move
	 * </code> class if the move is a move which checkmates the opponent
	 * <code>King</code> and ends the <code>Game</code>, or not. Since
	 * the defualt value is <code>false</code>, it should be called only
	 * during setting.
	 * @param matingMove <code>true</code> if a mating move
	 */
	public void setMatingMove(boolean matingMove)
	{
		this.matingMove = matingMove;
	}
	/**
	 * This method is used to access the private data member hence
	 * defined as a simple getter method. Tells us if the move is a
	 * move which captures an opponent <code>Piece</code> or not.
	 * @return <code>true</code> if a capturing move, false otherwise.
	 */
	public boolean isCapturingMove()
	{
		return capturingMove;
	}
	/**
	 * This method is used to access the private data member hence
	 * defined as a simple getter method. Used to tell the <code>Move
	 * </code> class if the move is a move which captures an opponent
	 * <code>Piece</code> or not. Since the defualt value is <code>false
	 * </code>, it should be called only during setting.
	 * @param checkingMove <code>true</code> if a checking move
	 */
	public void setCapturingMove(boolean capturingMove)
	{
		this.capturingMove = capturingMove;
	}
	/**
	 * Generic getter method used to access the value of
	 * the moveString. Defined as good programming practice,
	 * and not used at the time of writing.
	 * @return String representing the <code>Move</code>, as
	 * should be sent as command to the GUI, (eg: "e2e4")
	 */
	public String getMoveString()
	{
		return moveString;
	}
	/**
	 * Generic setter method used to set the value of, or a reference
	 * to, the moveString. Defined as good programming practice,
	 * and used only during <code>Move</code> construction at the time
	 * of writing.
	 * @param moveString String representing the <code>Move</code>, as
	 * should be sent as command to the GUI, (eg: "e2e4")
	 */
	public void setMoveString(String moveString)
	{
		this.moveString=moveString;
		for(byte i=0;i<64;i++)
		{
			if(moveString.startsWith(board.getSquare(i).getName()))
				fromSquare=board.getSquare(i);
			if(moveString.endsWith(board.getSquare(i).getName()))
				toSquare=board.getSquare(i);
			if((fromSquare!=null)&&(toSquare!=null))
				break;
		}
		pieceMoved=fromSquare.getPiece();
		capturedPiece=toSquare.getPiece();
		if(capturedPiece!=null)
			capturingMove=true;
		if(pieceMoved.getClass().getName().matches("Pawn")||
				capturingMove)
				halfMoveClock=board.getGame().getHalfMoveClock();
		whiteCastleKingside=board.getGame().isWhiteCastleKingside();
		whiteCastleQueenside=board.getGame().isWhiteCastleQueenside();
		blackCastleKingside=board.getGame().isBlackCastleKingside();
		blackCastleQueenside=board.getGame().isBlackCastleQueenside();
	}
	/**
	 * Generic getter method used to access the private data member
	 * board of the <code>Move</code> class.
	 * @return The <code>Board</code> on which the <code>Move</code> is made.
	 */
	public Board getBoard()
	{
		return board;
	}
	/**
	 * Generic setter method used to set the private data member
	 * board of the <code>Move</code> class.
	 * @param board The <code>Board</code> on which the <code>Move</code> is made.
	 */
	public void setBoard(Board board)
	{
		this.board = board;
	}
	/**
	 * Generic getter method used to access the private variable halfMovesClock.
	 * Since it is private, public getter is used to gain access.
	 * @return The half move (50-moves-rule) clock before the move.
	 */
	public byte getHalfMoveClock()
	{
		return halfMoveClock;
	}
	/**
	 * Used to set the halfMoveClock of the <code>Move</code>. Generally
	 * not used except during construction, but defined here as good
	 * programming practice.
	 * @param halfMovesClock The no. of half moves made to account for the
	 * 50 moves rule, before the <code>Move</code>.
	 */
	public void setHalfMoveClock(byte halfMoveClock)
	{
		this.halfMoveClock = halfMoveClock;
	}
	/**
	 * Generic getter method. Since whiteCastleKingside is a private variable,
	 * it has to be accessed using a public getter method. This follows the
	 * rules of data abstraction, thus OOPS in general. This has the value from
	 * <code>Game</code> of the <code>Board</code> on which this <code>Move
	 * </code> is made, and stores it for retrieval during unMakeMove().
	 * @return <code>true</code> if white can castle on its kingside, before
	 * this <code>Move</code> has been made.
	 */
	public boolean isWhiteCastleKingside()
	{
		return whiteCastleKingside;
	}
	/**
	 * Generic setter method, used to set the private variable whiteCastleKingside.
	 * Almost never used. Simply defined as good programming practice, so
	 * that we have it when we need it (if at all).
	 * @param whiteCastleKingside <code>true</code> if white can castle on its
	 * kingside.
	 */
	public void setWhiteCastleKingside(boolean whiteCastleKingside)
	{
		this.whiteCastleKingside = whiteCastleKingside;
	}
	/**
	 * Generic getter method. Since whiteCastleQueenside is a private variable,
	 * it has to be accessed using a public getter method. This follows the
	 * rules of data abstraction, thus OOPS in general. This has the value from
	 * <code>Game</code> of the <code>Board</code> on which this <code>Move
	 * </code> is made, and stores it for retrieval during unMakeMove().
	 * @return <code>true</code> if white can castle on its queenside, before
	 * this <code>Move</code> has been made.
	 */
	public boolean isWhiteCastleQueenside()
	{
		return whiteCastleQueenside;
	}
	/**
	 * Generic setter method, used to set the private variable whiteCastleQueenside.
	 * Almost never used. Simply defined as good programming practice, so
	 * that we have it when we need it (if at all).
	 * @param whiteCastleQueenside <code>true</code> if black can castle on its
	 * queenside.
	 */
	public void setWhiteCastleQueenside(boolean whiteCastleQueenside)
	{
		this.whiteCastleQueenside = whiteCastleQueenside;
	}
	/**
	 * Generic getter method. Since blackCastleKingside is a private variable,
	 * it has to be accessed using a public getter method. This follows the
	 * rules of data abstraction, thus OOPS in general. This has the value from
	 * <code>Game</code> of the <code>Board</code> on which this <code>Move
	 * </code> is made, and stores it for retrieval during unMakeMove().
	 * @return <code>true</code> if black can castle on its kingside, before
	 * this <code>Move</code> has been made.
	 */
	public boolean isBlackCastleKingside()
	{
		return blackCastleKingside;
	}
	/**
	 * Generic setter method, used to set the private variable blackCastleKingside.
	 * Almost never used. Simply defined as good programming practice, so
	 * that we have it when we need it (if at all).
	 * @param blackCastleKingside <code>true</code> if black can castle on its
	 * kingside.
	 */
	public void setBlackCastleKingside(boolean blackCastleKingside)
	{
		this.blackCastleKingside = blackCastleKingside;
	}
	/**
	 * Generic getter method. Since blackCastleQueenside is a private variable,
	 * it has to be accessed using a public getter method. This follows the
	 * rules of data abstraction, thus OOPS in general. This has the value from
	 * <code>Game</code> of the <code>Board</code> on which this <code>Move
	 * </code> is made, and stores it for retrieval during unMakeMove().
	 * @return <code>true</code> if black can castle on its queenside, before
	 * this <code>Move</code> has been made.
	 */
	public boolean isBlackCastleQueenside()
	{
		return blackCastleQueenside;
	}
	/**
	 * Generic setter method, used to set the private variable blackCastleQueenside.
	 * Almost never used. Simply defined as good programming practice, so
	 * that we have it when we need it (if at all).
	 * @param blackCastleQueenside <code>true</code> if black can castle on its
	 * queenside.
	 */
	public void setBlackCastleQueenside(boolean blackCastleQueenside)
	{
		this.blackCastleQueenside = blackCastleQueenside;
	}
	/**
	 * Generic getter method. Since enPassantSquare is a private variable,
	 * it has to be accessed using a public getter method. This follows the
	 * rules of data abstraction, thus OOPS in general.
	 * @return The en-passant <code>Square</code> of the <code>Game</code> of
	 * the <code>Board</code> of this <code>Move</code>, before the <code>Move
	 * </code> was made.
	 */
	public Square getEnPassantSquare()
	{
		return enPassantSquare;
	}
	/**
	 * Generic setter method, used to set the private variable fenString.
	 * Almost never used. Simply defined as good programming practice, so
	 * that we have it when we need it (if at all).
	 * @param enPassantSquare The <code>Square</code> representing the
	 * en-passant square of the <code>Game</code> of the <code>Board</code>
	 * on which this <code>Move</code> is played. 
	 */
	public void setEnPassantSquare(Square enPassantSquare)
	{
		this.enPassantSquare = enPassantSquare;
	}
	/**
	 * Returns the string to be displayed to the user as a description
	 * of the move, substituting appropriate strings or adding such
	 * substrings as necessary, in cases of pawn moves, castlings,
	 * captures, checks or mate. Overrides the toString() method in
	 * <code>Object</code> superclass.
	 * @return String representing the move, as should be displayed to
	 * the user, "Illegal Move "+toString() if illegal move.
	 */
	public String toString()
	{
		String returnString="";
		//if the piece moved is a King
		if(pieceMoved.getShortAlgebraicNotation().matches("K"))
		{
			//for short castle
			if(	moveString.matches("e1g1")||
				moveString.matches("e8g8"))
				returnString="O-O";
			//for long castle
			if(	moveString.matches("e1c1")||
				moveString.matches("e8c8"))
				returnString="O-O-O";
		}
		else
		{
			//for pawn and other pieces, as for pawn, it is ""
			if(!pieceMoved.getShortAlgebraicNotation().matches("P"))
				returnString=pieceMoved.getShortAlgebraicNotation();
			//for captures
			if(capturedPiece!=null)
			{
				//if pawn captures, add file of pawn
				if(pieceMoved.getShortAlgebraicNotation().matches("P"))
					returnString+=fromSquare.getFile().getName();
				returnString+="x";
			}
			//add destination square either way
			returnString+=toSquare.toString();
			//for checking and mating moves
			if(matingMove)
				returnString+="#";
			else if(checkingMove)
				returnString+="+";
		}
		return returnString;
	}
}