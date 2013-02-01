package com.kenny.classiq.players;

import com.kenny.classiq.game.Game;

public class User extends Player
{
	public User(Game gameReference, String colour)
	{
		if(colour.matches("black"))
			setWhite(false);
		setPlayerType("user");
		setGame(gameReference);
	}
}
