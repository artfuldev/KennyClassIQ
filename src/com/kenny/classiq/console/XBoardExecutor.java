package com.kenny.classiq.console;

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
		if(splitString[0].matches("ping"))
		{
			System.out.println("pong "+splitString[1]);
		}
		else if(splitString[0].matches("level"))
		{
			byte movesPerSide=0, baseMinutes=0, incrementSeconds=0;
			movesPerSide=Byte.parseByte(splitString[1]);
			baseMinutes=Byte.parseByte(splitString[2]);
			incrementSeconds=Byte.parseByte(splitString[3]);
			//Pass arguments to proper function
			System.out.println("Level set to "+movesPerSide+"/"+baseMinutes+
					"/"+incrementSeconds);
		}
		else
			System.out.println("ignored "+splitString[0]);
	}
}
