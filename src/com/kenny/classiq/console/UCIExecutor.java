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
	public UCIExecutor(Command command)
	{
		super(command);
	}
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
					if(splitString.length>2)
					{
						if(splitString[2].matches("moves"))
						{
							int i=0,j=0;
							boolean newGame=false;
							if(chessGame!=null)
							{
								if(chessGame.getMoveList().size()<(splitString.length-3))
								{
									for(;i<chessGame.getMoveList().size();i++)	
										if(chessGame.getMoveList().get(i).toString().
											matches(splitString[i+3]))
											j++;
									if(j==(i-1))
									{
										Move tempMove;
										for(;i<splitString.length;i++)
										{
											tempMove=new Move(chessGame.getGameBoard());
											tempMove.setMoveString(splitString[i]);
											chessGame.getCurrentPlayer().makeMove(tempMove);
										}
									}
									else
										newGame=true;
								}
								else
									newGame=true;
							}
							else
								newGame=true;
							if(newGame)
							{
								chessGame=new Game(Definitions.startPositionFEN);
								Move tempMove;
								for(i=3;i<splitString.length;i++)
								{
									tempMove=new Move(chessGame.getGameBoard());
									tempMove.setMoveString(splitString[i]);
									chessGame.getCurrentPlayer().makeMove(tempMove);
								}
							}
						}
					}
					else
						chessGame=new Game(Definitions.startPositionFEN);
				}
				else if(splitString[1].matches("fen"))
				{
					String fenString=splitString[2]+" "+splitString[3]+" "
						+splitString[4]+" "+splitString[5]+" "
						+splitString[6]+" "+splitString[7];
					System.out.println(fenString);
					if(splitString.length>8)
					{
						if(splitString[8].matches("moves"))
						{
							int i=0,j=0;
							boolean newGame=false;
							if(chessGame!=null)
							{
								if(chessGame.getMoveList().size()<(splitString.length-9))
								{
									for(;i<chessGame.getMoveList().size();i++)	
										if(chessGame.getMoveList().get(i).toString().
											matches(splitString[i+9]))
											j++;
									if(j==(i-1))
									{
										Move tempMove;
										for(;i<splitString.length;i++)
										{
											tempMove=new Move(chessGame.getGameBoard());
											tempMove.setMoveString(splitString[i]);
											chessGame.getCurrentPlayer().makeMove(tempMove);
										}
									}
									else
										newGame=true;
								}
								else
									newGame=true;
							}
							else
								newGame=true;
							if(newGame)
							{
								chessGame=new Game(fenString);
								Move tempMove;
								for(i=3;i<splitString.length;i++)
								{
									tempMove=new Move(chessGame.getGameBoard());
									tempMove.setMoveString(splitString[i]);
									chessGame.getCurrentPlayer().makeMove(tempMove);
								}
							}
						}
					}
					else
						chessGame=new Game(fenString);
				}
			}
			else if(commandString.startsWith("go"))
			{
				System.out.println("bestmove "+
						chessGame.getPlayerTwo().getMove().getMoveString());
			}
			else if(commandString.startsWith("d"))
				chessGame.printStats();
			else
			//commands not implemented properly
				System.out.println(Definitions.debugMessage+"received "
									+splitString[0]);
		}
	}
}