package com.kenny.classiq.players;

import com.kenny.classiq.game.Game;
import com.kenny.classiq.game.Move;

/**
 * The <code>AI</code> represents the <code>AI Player</code> which
 * calculates the best <code>Move</code> and returns it.
 * @author Kenshin Himura (Sudarsan Balaji)
 */
public class AI extends Player
{
	public AI(Game gameReference, String colour)
	{
		if(colour.matches("black"))
			setWhite(false);
		setPlayerType("ai");
		setGame(gameReference);
	}

	/**
	 * Used to get the <code>Move</code> played by this <code>Player</code>.
	 * Varies in execution, as each type of <code>Player</code> may process
	 * the returnMove differently (<code>AI</code> calculates, <code>User</code>
	 * thinks, and <code>GUI</code> provides). 
	 * @return The <code>Move</code> this <code>Player</code> wants to play.
	 */
	@Override
	public Move getMove()
	{
		Move returnMove=new Move(getGame().getGameBoard());
		returnMove.setMoveString("e2e4");
		return returnMove;
	}
}
