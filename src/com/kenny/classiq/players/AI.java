package com.kenny.classiq.players;

import com.kenny.classiq.game.Game;

public class AI extends Player
{
	public AI(Game gameReference, String colour)
	{
		if(colour.matches("black"))
			setWhite(false);
		setPlayerType("ai");
		setGame(gameReference);
	}
}
