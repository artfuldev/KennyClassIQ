package com.kenny.classiq.players;

import com.kenny.classiq.game.Game;

public class GUI extends Player
{
	public GUI(Game gameReference, String colour)
	{
		if(colour.matches("black"))
			setWhite(false);
		setPlayerType("ai");
		setGame(gameReference);
	}
}
