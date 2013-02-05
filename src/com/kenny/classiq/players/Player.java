package com.kenny.classiq.players;

import com.kenny.classiq.game.Game;
import com.kenny.classiq.game.Move;

/**
 * The <code>Player</code> class represents a chess player in the
 * <code>Game</code> class. It used to get moves from a player, and the
 * method for getting the move from the player should depend upon the
 * type of the player (ie, human or ai).
 * @author Kenshin Himura (Sudarsan Balaji)
 *
 */
public abstract class Player
{
	/**
	 * Holds a reference to the game that this player is a part of. Simply
	 * used to be able to get extra functionality in case they should(can) be
	 * provided.
	 */
	private Game game;
	/**
	 * Holds a String, whose value specifies the type of the player. Used in
	 * place of a boolean, because AI and User are not the only two types of
	 * player. In the case of chess engines, a player may be a GUI.
	 * The three accepted String values for this data member are: "ai", "user"
	 * and "gui". "user" values are not used as of now (version 0.04.04.04).
	 */
	private String playerType;
	/**
	 * Holds a value representing the state of being the white side of the
	 * chess board of a <code>Player</code>. Default value is true.
	 */
	private boolean white=true;
	/**
	 * Default contsructor of the <code>Player</code> class. Does absolutely
	 * nothing.
	 */
	public Player()
	{
		
	}
	/**
	 * This constructor is used in the <code>Game</code> class to construct two
	 * new players of the game, with colour and type.
	 * @param gameReference A reference to the game of which the <code>Player</code>
	 * is a part.
	 * @param colour The colour of the <code>Player</code> as a String.
	 * @param playerType The type of the <code>Player</code> as a String.
	 */
	public Player(Game gameReference, String colour, String playerType)
	{
		if(colour.matches("black"))
			setWhite(false);
		setPlayerType(playerType);
		setGame(gameReference);
	}
	/**
	 * Generic getter method of the variable playerType. As it is a private
	 * member, it has to be accessed using a public getter method. Defined
	 * as good programming practice.
	 * @return The type of <code>Player</code> as a String.
	 */
	public String getPlayerType()
	{
		return playerType;
	}
	/**
	 * Generic setter method of the variable playerType. As it is a private
	 * member, it has to be accessed using a public getter method. Defined
	 * as good programming practice.
	 * @param playerType Type of the <code>Player</code> as a String
	 */
	public void setPlayerType(String playerType)
	{
		this.playerType = playerType;
	}
	/**
	 * Generic getter method used to know if the <code>Player</code> plays
	 * white (if set to true) or black. Since <code>white</code> is a private
	 * data member, public getter and setter methods should be used to gain
	 * access to such variables.
	 * @return <code>True</code> if <code>Player</code> plays white,
	 * <code>False</code> otherwise.
	 */
	public boolean isWhite()
	{
		return white;
	}
	/**
	 * Generic setter method used to tell if the <code>Player</code> plays
	 * white (if set to true) or black. Since <code>white</code> is a private
	 * data member, public getter and setter methods should be used to gain
	 * access to such variables.
	 * @param white true if <code>Player</code> plays white, false otherwise
	 */
	public void setWhite(boolean white)
	{
		this.white = white;
	}
	/**
	 * Generic getter method of the variable game. As it is a private
	 * member, it has to be accessed using a public getter method. Defined
	 * as good programming practice.
	 * @return The game to which the player belongs.
	 */
	public Game getGame()
	{
		return game;
	}
	/**
	 * Generic setter method used to set the reference to the <code>Game</code>
	 * to which the <code>Player</code> belongs.
	 * @param game <code>Game</code> to which the <code>Player</code> belongs.
	 */
	public void setGame(Game game)
	{
		this.game = game;
	}
	/**
	 * Used to get the <code>Move</code> played by this <code>Player</code>.
	 * Varies in execution, as each type of <code>Player</code> may process
	 * the returnMove differently (<code>AI</code> calculates, <code>User</code>
	 * thinks, and <code>GUI</code> provides). 
	 * @return The <code>Move</code> this <code>Player</code> wants to play.
	 */
	public Move getMove()
	{
		Move returnMove=null;
		return returnMove;
	}
	/**
	 * Used to make a move on the <code>Board</code> of the <code>Game</code>
	 * which this <code>Player</code> is a part.
	 * @param moveToMake The <code>Move</code> to be made.
	 */
	public void makeMove(Move moveToMake)
	{
		if(moveToMake.isCapturingMove())
			moveToMake.getBoard().getGame().getPieceSet().setPiece(
							moveToMake.getCapturedPiece());
		moveToMake.getFromSquare().setPiece(null);
		moveToMake.getToSquare().setPiece(moveToMake.getPieceMoved());
		moveToMake.getBoard().getGame().getMoveList().add(moveToMake);
		if(!moveToMake.getPieceMoved().isWhite())
			moveToMake.getBoard().getGame().setMoveNumber(
				moveToMake.getBoard().getGame().getMoveNumber()+1);
		if(moveToMake.getHalfMoveClock()!=0)
			moveToMake.getBoard().getGame().setHalfMoveClock((byte)0);
		else
			moveToMake.getBoard().getGame().setHalfMoveClock((byte)
					(moveToMake.getBoard().getGame().getHalfMoveClock()+1));
		if(moveToMake.getPieceMoved().isWhite())
		{
			if(moveToMake.getMoveString().startsWith("e1"))
			{
				moveToMake.getBoard().getGame().setWhiteCastleKingside(false);
				moveToMake.getBoard().getGame().setWhiteCastleQueenside(false);
			}
			if(moveToMake.getBoard().getGame().isWhiteCastleKingside())
				if(moveToMake.getMoveString().startsWith("h1"))
					moveToMake.getBoard().getGame().setWhiteCastleKingside(false);
			if(moveToMake.getBoard().getGame().isWhiteCastleQueenside())
				if(moveToMake.getMoveString().startsWith("a1"))
					moveToMake.getBoard().getGame().setWhiteCastleQueenside(false);
		}
		else
		{
			if(moveToMake.getMoveString().startsWith("e8"))
			{
				moveToMake.getBoard().getGame().setBlackCastleKingside(false);
				moveToMake.getBoard().getGame().setBlackCastleQueenside(false);
			}
			if(moveToMake.getBoard().getGame().isBlackCastleKingside())
				if(moveToMake.getMoveString().startsWith("h8"))
					moveToMake.getBoard().getGame().setWhiteCastleKingside(false);
			if(moveToMake.getBoard().getGame().isWhiteCastleQueenside())
				if(moveToMake.getMoveString().startsWith("a8"))
					moveToMake.getBoard().getGame().setWhiteCastleQueenside(false);
		}
	}
	/**
	 * Used to make a move on the <code>Board</code> of the <code>Game</code>
	 * which this <code>Player</code> is a part.
	 * @param moveToUnMake The <code>Move</code> to be un-made.
	 */
	public void unMakeMove(Move moveToUnMake)
	{
		moveToUnMake.getFromSquare().setPiece(moveToUnMake.getPieceMoved());
		moveToUnMake.getFromSquare().getPiece().setSquare(
											moveToUnMake.getFromSquare());
		if(!moveToUnMake.isCapturingMove())
			moveToUnMake.getToSquare().setPiece(null);
		else
			moveToUnMake.getToSquare().setPiece(moveToUnMake.getCapturedPiece());
		moveToUnMake.getBoard().getGame().getMoveList().remove(moveToUnMake);
		if(!moveToUnMake.getPieceMoved().isWhite())
			moveToUnMake.getBoard().getGame().setMoveNumber(
				moveToUnMake.getBoard().getGame().getMoveNumber()-1);
		if(moveToUnMake.getHalfMoveClock()!=0)
			moveToUnMake.getBoard().getGame().setHalfMoveClock(moveToUnMake.
				getHalfMoveClock());
		else
			moveToUnMake.getBoard().getGame().setHalfMoveClock((byte)
					(moveToUnMake.getBoard().getGame().getHalfMoveClock()-1));
		if(moveToUnMake.getPieceMoved().isWhite())
		{
			if(moveToUnMake.getMoveString().startsWith("e1"))
			{
				moveToUnMake.getBoard().getGame().setWhiteCastleKingside(
					moveToUnMake.isWhiteCastleKingside());
				moveToUnMake.getBoard().getGame().setWhiteCastleQueenside(
					moveToUnMake.isWhiteCastleQueenside());
			}
			if(!moveToUnMake.getBoard().getGame().isWhiteCastleKingside())
				if(moveToUnMake.getMoveString().startsWith("h1"))
					moveToUnMake.getBoard().getGame().setWhiteCastleKingside(
						moveToUnMake.isWhiteCastleKingside());
			if(!moveToUnMake.getBoard().getGame().isWhiteCastleQueenside())
				if(moveToUnMake.getMoveString().startsWith("a1"))
					moveToUnMake.getBoard().getGame().setWhiteCastleQueenside(
						moveToUnMake.isWhiteCastleQueenside());
		}
		else
		{
			if(moveToUnMake.getMoveString().startsWith("e8"))
			{
				moveToUnMake.getBoard().getGame().setBlackCastleKingside(
					moveToUnMake.isBlackCastleKingside());
				moveToUnMake.getBoard().getGame().setBlackCastleQueenside(
					moveToUnMake.isBlackCastleQueenside());
			}
			if(!moveToUnMake.getBoard().getGame().isBlackCastleKingside())
				if(moveToUnMake.getMoveString().startsWith("h8"))
					moveToUnMake.getBoard().getGame().setWhiteCastleKingside(
						moveToUnMake.isBlackCastleKingside());
			if(!moveToUnMake.getBoard().getGame().isWhiteCastleQueenside())
				if(moveToUnMake.getMoveString().startsWith("a8"))
					moveToUnMake.getBoard().getGame().setWhiteCastleQueenside(
						moveToUnMake.isBlackCastleQueenside());
		}
	}
}