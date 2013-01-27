package com.kenny.classiq;

import java.util.Scanner;

/**
 * <code>XBoard</code> is the class used to represent the WinBoard
 * or XBoard communication protocol. It implements the
 * <code>CommunicationProtocol</code> interface to make use of its
 * functions, which are common to both <code>XBoard</code> and
 * <code>UCI</code> protocols.
 * @author Kenshin Himura
 *
 */
public class XBoard implements CommunicationProtocol
{
	public void start()
	{
		init();
		listen();
	}
	public void init()
	{
		System.out.println("xboard");
		System.out.println(Definitions.engineName+" "+Definitions.engineVersion
				+" by "+Definitions.authorName);
	}
	public void listen()
	{
		Scanner inputStream=new Scanner(System.in);
		String commandString;
		String[] cmdString;
		while(true)
		{
			commandString=inputStream.nextLine();
			cmdString=commandString.split("\\s");
			if(	cmdString[0].matches("new")||
				cmdString[0].matches("go")||
				cmdString[0].matches("force")||
				cmdString[0].matches("INPUT MOVES")||
				cmdString[0].matches("level")||
				cmdString[0].matches("time")||
				cmdString[0].matches("usermove")||
				cmdString[0].matches("protover")||
				cmdString[0].matches("setboard"))
				execute(commandString);
			else if(cmdString[0].matches("quit"))
				break;
			else
				execute(Definitions.errorString+" "+commandString);
		}
		inputStream.close();
	}
	public void execute(String cmd)
	{
		String[] splitString=cmd.split("\\s");
		if(splitString[0].matches(Definitions.errorString))
			System.out.println(Definitions.errorInCommandString+splitString[1]);
		else
			System.out.println(cmd);
	}
}