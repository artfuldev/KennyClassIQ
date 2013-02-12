package com.kenny.classiq.console;

import com.kenny.classiq.definitions.Definitions;
import com.kenny.classiq.game.Game;
import com.kenny.classiq.game.Move;

/**
 * The <code>XBoardExecutor</code> class extends <code>Executor</code> and
 * thus inherits its run() method by default. All that remains is to define
 * its execute() method properly, according to the <code>XBoard</code>
 * protocol.
 * @author Kenshin Himura (Sudarsan Balaji)
 *
 */
public class XBoardExecutor extends Executor
{
	/**
	 * It is the function which executes the commands parsed by the
	 * listener. It is used to check for specific cases and then call
	 * the respective functions to execute such commands, by passing
	 * the correct corresponding paramaters to those functions, according
	 * to the <code>XBoard</code> protocol. It is yet to be defined
	 * fully.
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
			if(commandString.startsWith("ping"))
				System.out.println("pong "+splitString[1]);
			else if(commandString.startsWith("usermove"))
			{
				Move userMove=new Move(chessGame.getGameBoard());
				userMove.setMoveString(splitString[1]);
				chessGame.getCurrentPlayer().makeMove(userMove);
				chessGame.showBoard();
				System.out.println("move "+chessGame.getCurrentPlayer().getMove().
						getMoveString());
			}
			else if(commandString.startsWith("go"))
				System.out.println("move "+
						chessGame.getPlayerTwo().getMove().getMoveString());
			else if(commandString.startsWith("?"))
				System.out.println("move "+
						chessGame.getPlayerTwo().getMove().getMoveString());
			else if(commandString.startsWith("setboard"))
				chessGame=new Game(splitString[1]+" "+splitString[2]+" "
						+splitString[3]+" "+splitString[4]+" "
						+splitString[5]+" "+splitString[6]);
			else if(commandString.startsWith("new"))
				chessGame=new Game(Definitions.startPositionFEN);
			//commands not yet implemented properly
			else
				System.out.println(Definitions.debugMessage+"received "
									+splitString[0]);
		}
	}
}