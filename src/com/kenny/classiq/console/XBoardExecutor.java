package com.kenny.classiq.console;

import com.kenny.classiq.definitions.Definitions;

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
			//commands not yet implemented properly
			else
				System.out.println(Definitions.debugMessage+"received "
									+splitString[0]);
		}
	}
}
