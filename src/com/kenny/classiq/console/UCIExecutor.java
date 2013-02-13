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

import com.kenny.classiq.definitions.Definitions;
import com.kenny.classiq.game.Game;
import com.kenny.classiq.game.Move;

/**
 * The <code>UCIExecutor</code> class extends <code>Executor</code> and thus
 * inherits its run() method by default. All that remains is to define its
 * execute() method properly, according to the <code>UCI</code> protocol.
 * @author Kenshin Himura  
 *
 */
public class UCIExecutor extends Executor
{
	/**
	 * It is the function which executes the commands parsed by the
	 * listener. It is used to check for specific cases and then call
	 * the respective functions to execute such commands, by passing
	 * the correct corresponding paramaters to those functions, according
	 * to the <code>UCI</code> protocol.
	 * @param commandString The full command to be executed, as a
	 * <code>String</code>.
	 */
	public void execute(String commandString)
	{
		String[] splitString=commandString.split("\\s");
		if(commandString.startsWith("quit"))
			System.exit(0);
		else
		{
			//implemented commands
			if(commandString.startsWith("isready"))
				System.out.println("readyok");
			else if(commandString.startsWith("ucinewgame"))
				chessGame=new Game(Definitions.startPositionFEN);
			else if(commandString.startsWith("position"))
			{
				if(splitString[1].matches("startpos"))
				{
					chessGame=new Game(Definitions.startPositionFEN);
					if(splitString.length>2)
						if(splitString[2].matches("moves"))
						{
							Move tempMove;
							for(byte i=3;i<splitString.length;i++)
							{
								tempMove=new Move(chessGame.getGameBoard());
								tempMove.setMoveString(splitString[i]);
								chessGame.getCurrentPlayer().makeMove(tempMove);
							}
						}
				}
				else if(splitString[1].matches("fen"))
				{
					chessGame=new Game(splitString[2]+" "+splitString[3]+" "
						+splitString[4]+" "+splitString[5]+" "
						+splitString[6]+" "+splitString[7]);
					if(splitString[8].matches("moves"))
					{
						Move tempMove;
						for(byte i=9;i<splitString.length;i++)
						{
							tempMove=new Move(chessGame.getGameBoard());
							tempMove.setMoveString(splitString[i]);
							chessGame.getCurrentPlayer().makeMove(tempMove);
						}
					}
					chessGame.showBoard();
				}
			}
			else if(commandString.startsWith("go"))
				System.out.println("bestmove "+
						chessGame.getPlayerTwo().getMove().getMoveString());
			else
			//commands not implemented properly
				System.out.println(Definitions.debugMessage+"received "
									+splitString[0]);
		}
	}
}