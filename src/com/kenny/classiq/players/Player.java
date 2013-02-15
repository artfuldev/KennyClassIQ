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

package com.kenny.classiq.players;

import java.util.ArrayList;

import com.kenny.classiq.board.Square;
import com.kenny.classiq.game.Game;
import com.kenny.classiq.game.Move;

/**
 * The <code>Player</code> class represents a chess player in the
 * <code>Game</code> class. It used to get moves from a player, and the
 * method for getting the move from the player should depend upon the
 * type of the player (ie, human or ai).
 * @author Kenshin Himura  
 *
 */
public abstract class Player
{
	/**
	 * Holds a reference to the game that this player is a part of. Simply
	 * used to be able to get extra functionality in case they should(can) be
	 * provided.
	 */
	protected Game game;
	/**
	 * Holds a String, whose value specifies the type of the player. Used in
	 * place of a boolean, because AI and User are not the only two types of
	 * player. In the case of chess engines, a player may be a GUI.
	 * The three accepted String values for this data member are: "ai", "user"
	 * and "gui". "user" values are not used as of now (version 0.04.04.04).
	 */
	protected String playerType;
	/**
	 * Holds a value representing the state of being the white side of the
	 * chess board of a <code>Player</code>. Default value is true.
	 */
	protected boolean white=true;
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
	 * access to it.
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
	 * Used to make a move on the <code>Board</code> of the <code>Game</code>
	 * which this <code>Player</code> is a part.
	 * <p>
	 * The complex code inside can be explained as follows:
	 * <p>
	 * First, if the move is non-capturing move, the fromSquare's piece is 
	 * made the toSquare's piece, and the fromSquare's piece is made null.
	 * Otherwise, the captured piece is sent to the <code>PieceSet</code> of
	 * the corresponding <code>game</code>, and then, the previous step is
	 * taken.
	 * <p>
	 * Then, the move is added to the <code>MoveList</code> of the <code>
	 * Game</code> of the <code>Board</code> on which the <code>Move</code>
	 * is made.
	 * <p>
	 * If the move is made by black, the moveNumber of the corresponding
	 * <code>Game</code> is incremented. Then, the halfMoveClock is modified
	 * accordingly.
	 * <p>
	 * Then, the castling flags are reset if the moves are made from e1,h1
	 * or a1 if the playing side is white, and if they are made from r8,h8
	 * or a8 if the playing side is black.
	 * <p>
	 * And then, if a double pawn move has been made, the enPassantSquare of
	 * the corresponding <code>Game</code> is changed to reflect the latest
	 * proper value.
	 * <p>
	 * Finally, it sets the whiteToMove variable to its complementary value.
	 * @param moveToMake The <code>Move</code> to be made.
	 */
	public void makeMove(Move moveToMake)
	{
		if(moveToMake.isCapturingMove())
		{
			moveToMake.getBoard().getGame().getPieceSet().setPiece(
			moveToMake.getCapturedPiece());
			if(moveToMake.getToSquare().equals(moveToMake.getEnPassantSquare()))
				if(moveToMake.getPieceMoved().getShortAlgebraicNotation().
					matches("P"))
					moveToMake.getCapturedPiece().getSquare().setPiece(null);
		}
		moveToMake.getFromSquare().setPiece(null);
		moveToMake.getToSquare().setPiece(moveToMake.getPieceMoved());
		moveToMake.getBoard().getGame().getMoveList().add(moveToMake);
		moveToMake.getBoard().getGame().setEnPassantSquare(null);
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
				if(moveToMake.getMoveString().contains("g1"))
				{
					moveToMake.getBoard().getRank((byte)0).getSquare((byte)5).
					setPiece(moveToMake.getBoard().getRank((byte)0).
							getSquare((byte)7).getPiece());
					moveToMake.getBoard().getRank((byte)0).
					getSquare((byte)7).setPiece(null);
				}
				else if(moveToMake.getMoveString().contains("c1"))
				{
					moveToMake.getBoard().getRank((byte)0).getSquare((byte)3).
					setPiece(moveToMake.getBoard().getRank((byte)0).
							getSquare((byte)0).getPiece());
					moveToMake.getBoard().getRank((byte)0).
					getSquare((byte)0).setPiece(null);
				}
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
				if(moveToMake.getMoveString().contains("g8"))
				{
					moveToMake.getBoard().getRank((byte)7).getSquare((byte)5).
					setPiece(moveToMake.getBoard().getRank((byte)7).
							getSquare((byte)7).getPiece());
					moveToMake.getBoard().getRank((byte)7).
					getSquare((byte)7).setPiece(null);
				}
				else if(moveToMake.getMoveString().contains("c8"))
				{
					moveToMake.getBoard().getRank((byte)7).getSquare((byte)3).
					setPiece(moveToMake.getBoard().getRank((byte)7).
							getSquare((byte)0).getPiece());
					moveToMake.getBoard().getRank((byte)7).
					getSquare((byte)0).setPiece(null);
				}
			}
			if(moveToMake.getBoard().getGame().isBlackCastleKingside())
				if(moveToMake.getMoveString().startsWith("h8"))
					moveToMake.getBoard().getGame().setWhiteCastleKingside(false);
			if(moveToMake.getBoard().getGame().isWhiteCastleQueenside())
				if(moveToMake.getMoveString().startsWith("a8"))
					moveToMake.getBoard().getGame().setWhiteCastleQueenside(false);
		}
		if(moveToMake.getPieceMoved().getShortAlgebraicNotation().matches("P"))
		{
			if(moveToMake.getPieceMoved().isWhite())
			{
				if(moveToMake.getFromSquare().getRankIndex()==1)
					if(moveToMake.getToSquare().getRankIndex()==3)
						moveToMake.getBoard().getGame().setEnPassantSquare(
						moveToMake.getBoard().getSquare(moveToMake.getFromSquare().
						getFile().getName()+3));
			}
			else
			{
				if(moveToMake.getFromSquare().getRankIndex()==6)
					if(moveToMake.getToSquare().getRankIndex()==4)
						moveToMake.getBoard().getGame().setEnPassantSquare(
						moveToMake.getBoard().getSquare(moveToMake.getFromSquare().
						getFile().getName()+6));
			}
			if(moveToMake.isPromotingMove())
				moveToMake.getToSquare().setPiece(moveToMake.getPromotedPiece());
		}
		moveToMake.getBoard().getGame().setWhiteToMove(!moveToMake.getBoard().
				getGame().isWhiteToMove());
	}
	/**
	 * Used to make a move on the <code>Board</code> of the <code>Game</code>
	 * which this <code>Player</code> is a part.
	 * <p>
	 * Unmakes all the changes made in makeMove() to the <code>Game</code> of
	 * the <code>Board</code> in which this <code>Move</code> is made,
	 * re-assigning the backup values stored in the <code>Move</code> to the
	 * <code>Game</code>.
	 * @param moveToUnMake The <code>Move</code> to be un-made.
	 */
	public void unMakeMove(Move moveToUnMake)
	{
		moveToUnMake.getFromSquare().setPiece(moveToUnMake.getPieceMoved());
		if(!moveToUnMake.isCapturingMove())
			moveToUnMake.getToSquare().setPiece(null);
		else
		{
			moveToUnMake.getCapturedPiece().getSquare().setPiece(
			moveToUnMake.getCapturedPiece());
			if(moveToUnMake.getEnPassantSquare()!=null)
				if(moveToUnMake.getEnPassantSquare().equals(moveToUnMake.getToSquare()))
					if(moveToUnMake.getPieceMoved().getShortAlgebraicNotation().
						matches("P"))
						moveToUnMake.getToSquare().setPiece(null);
		}
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
				if(moveToUnMake.getMoveString().contains("g1"))
				{
					moveToUnMake.getBoard().getRank((byte)0).getSquare((byte)7).
					setPiece(moveToUnMake.getBoard().getRank((byte)0).
							getSquare((byte)5).getPiece());
					moveToUnMake.getBoard().getRank((byte)0).
					getSquare((byte)5).setPiece(null);
				}
				if(moveToUnMake.getMoveString().contains("c1"))
				{
					moveToUnMake.getBoard().getRank((byte)0).getSquare((byte)0).
					setPiece(moveToUnMake.getBoard().getRank((byte)0).
							getSquare((byte)3).getPiece());
					moveToUnMake.getBoard().getRank((byte)0).
					getSquare((byte)3).setPiece(null);
				}
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
				if(moveToUnMake.getMoveString().contains("g8"))
				{
					moveToUnMake.getBoard().getRank((byte)7).getSquare((byte)7).
					setPiece(moveToUnMake.getBoard().getRank((byte)7).
							getSquare((byte)5).getPiece());
					moveToUnMake.getBoard().getRank((byte)7).
					getSquare((byte)5).setPiece(null);
				}
				if(moveToUnMake.getMoveString().contains("c8"))
				{
					moveToUnMake.getBoard().getRank((byte)7).getSquare((byte)0).
					setPiece(moveToUnMake.getBoard().getRank((byte)7).
							getSquare((byte)3).getPiece());
					moveToUnMake.getBoard().getRank((byte)7).
					getSquare((byte)3).setPiece(null);
				}
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
		moveToUnMake.getBoard().getGame().setEnPassantSquare(
			moveToUnMake.getEnPassantSquare());
		moveToUnMake.getBoard().getGame().setWhiteToMove(!moveToUnMake.getBoard().
				getGame().isWhiteToMove());
	}
	public Move getMove()
	{
		return null;
	}
	public ArrayList<Move> getLegalMoves(boolean white)
	{
		ArrayList<Move> allMoves=new ArrayList<Move>();
		ArrayList<Move> legalMoves=new ArrayList<Move>();
		ArrayList<Square> occupiedSquares;
		if(white)
			occupiedSquares=game.getGameBoard().
				getWhiteOccupiedSquares();
		else
			occupiedSquares=game.getGameBoard().
				getBlackOccupiedSquares();
		while(!occupiedSquares.isEmpty())
		{
			if(occupiedSquares.get(0).getPiece().getMoves()!=null)
				allMoves.addAll(occupiedSquares.get(0).
						getPiece().getMoves());
			occupiedSquares.remove(0);
		}
		boolean inCheck=false,legal;
		if(game.getGameBoard().isChecked(false))
			inCheck=true;
		if(!allMoves.isEmpty())
		{
			Move newMove;
			if(white)
				for(byte i=0;i<allMoves.size();i++)
				{
					legal=true;
					newMove=allMoves.get(i);
					makeMove(newMove);
					if(game.getGameBoard().isChecked(white))
						legal=false;
					unMakeMove(newMove);
					if(legal==false)
						continue;
					else if(newMove.getMoveString().matches("e1g1"))
					{
						if(game.getGameBoard().getSquare("f1").isThreatenedBy(false))
							legal=false;
						else if(inCheck)
							legal=false;
					}
					else if(newMove.getMoveString().matches("e1c1"))
					{
						if(game.getGameBoard().getSquare("d1").isThreatenedBy(false))
							legal=false;
						else if(inCheck)
							legal=false;
					}
					else
						legalMoves.add(newMove);
				}
			else
				for(byte i=0;i<allMoves.size();i++)
				{
					legal=true;
					newMove=allMoves.get(i);
					makeMove(newMove);
					if(game.getGameBoard().isChecked(white))
						legal=false;
					unMakeMove(newMove);
					if(legal==false)
						continue;
					else if(allMoves.get(i).getMoveString().matches("e8g8"))
					{
						if(game.getGameBoard().getSquare("f8").isThreatenedBy(true))
							legal=false;
						if(inCheck)
							legal=false;
					}
					else if(allMoves.get(i).getMoveString().matches("e8c8"))
					{
						if(game.getGameBoard().getSquare("d8").isThreatenedBy(true))
							legal=false;
						if(inCheck)
							legal=false;
					}
					else
						legalMoves.add(newMove);
				}
		}
		return legalMoves;
	}
}