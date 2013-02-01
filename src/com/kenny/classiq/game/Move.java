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
		setBoard(boardReference);
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
		setFromSquare(fromSquare);
		setToSquare(toSquare);
		setPieceMoved(fromSquare.getPiece());
		setMoveString(fromSquare.getName()+toSquare.getName());
		setPieceMoved(fromSquare.getPiece());
		setBoard(fromSquare.getBoard());
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
		if(toSquare!=null)
			moveString+=toSquare.getName();
		setPieceMoved(fromSquare.getPiece());
		setBoard(fromSquare.getBoard());
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
		if(fromSquare!=null)
			moveString+=fromSquare.getName();
		moveString+=toSquare.getName();
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
		this.moveString = moveString;
		for(byte i=0;i<64;i++)
		{
			if(moveString.startsWith(getBoard().getSquare(i).getName()))
				setFromSquare(getBoard().getSquare(i));
			if(moveString.endsWith(getBoard().getSquare(i).getName()))
				setToSquare(getBoard().getSquare(i));
		}
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
	 * Returns the string to be displayed to the user as a description
	 * of the move, substituting appropriate strings or adding such
	 * substrings as necessary, in cases of pawn moves, castlings,
	 * captures, checks or mate. Overrides the toString() method in
	 * <code>Object</code> superclass.
	 * @return String representing the move, as should be displayed to
	 * the user.
	 */
	public String toString()
	{
		String returnString="";
		//if the piece moved is a King
		if(pieceMoved.getShortAlgebraicNotation()=="K")
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
			if(pieceMoved.getShortAlgebraicNotation().toUpperCase()!="P")
				returnString=pieceMoved.getShortAlgebraicNotation().toUpperCase();
			//for captures
			if(toSquare.getPiece()!=null)	
				if(toSquare.getPiece().isWhite()!=fromSquare.getPiece().isWhite())
					returnString+="x";
			//add destination square either way
			returnString+=toSquare.toString();
			//for checking and mating moves
			if(toSquare.getPiece()!=null)
				if(toSquare.getPiece().checks())
				{
					if(toSquare.getPiece().mates())
						returnString+="#";
					else
						returnString+="+";
				}
		}
		return returnString;
	}
}