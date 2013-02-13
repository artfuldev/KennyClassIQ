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

package com.kenny.classiq.console;

import com.kenny.classiq.game.Game;

/**
 * The <code>Executor</code> class is like the prototype of an
 * executor thread, which simply looks to execute the commands
 * flagged as new known commands by the listener thread. It extends
 * <code>Command</code> to inherit the static member commandString,
 * and implements <code>Runnable</code>. It is made abstract so that
 * separate UCI and XBoard executors may be defined.
 * @author Kenshin Himura (Sudarsan Balaji)
 * 
 */
public abstract class Executor extends Command implements Runnable
{
	/**
	 * Holds a boolean which determines the life of the thread. When
	 * an eception is caught, this is set to false, and the run() ends.
	 */
	private boolean alive=true;
	/**
	 * Holds a reference to the chess <code>Game</code> with which this
	 * <code>Executor</code> is involved.
	 */
	protected Game chessGame;
	/**
	 * Overrides the run() of <code>Runnable</code>. Its operation is
	 * very simple. It keeps checking for new command every 50 ms, and
	 * executes them.
	 */
	public void run()
	{
		while(alive)
		{
			try
			{
				Thread.sleep(50);
				while(!commandArray.isEmpty())
				{
					execute(commandArray.get(0));
					commandArray.remove(0);
				}
		    }
			catch(Exception ex)
			{
		      alive=false;
		      System.out.println("Execution failed");
		      ex.printStackTrace();
		      chessGame.showBoard();
		      System.out.println("white to move: "+chessGame.isWhiteToMove());
		    }
		}
	}
	/**
	 * It is the function which executes the commands parsed by the
	 * listener. It is used to check for specific cases and then call
	 * the respective functions to execute such commands, by passing
	 * the correct corresponding paramaters to those functions.
	 * It is made abstract because UCI and XBoard Executors should have
	 * their own definitions.
	 * @param commandString The full command to be executed, as a
	 * <code>String</code>.
	 */
	public abstract void execute(String commandString);
}
