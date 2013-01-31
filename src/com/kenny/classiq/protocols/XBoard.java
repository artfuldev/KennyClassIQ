package com.kenny.classiq.protocols;

import java.util.Scanner;
import com.kenny.classiq.definitions.Definitions;

/**
 * <code>XBoard</code> is the class used to represent the WinBoard
 * or XBoard communication protocol. It implements the
 * <code>CommunicationProtocol</code> interface to make use of its
 * functions, which are common to both <code>XBoard</code> and
 * <code>UCI</code> protocols.
 * @author Kenshin Himura (Sudarsan Balaji)
 */
public class XBoard implements CommunicationProtocol
{
	/**
	 * Holds the protocol version of the XBoard protocol. The default
	 * value is 1.
	 */
	private byte protocolVersion=1;
	/**
	 * Holds an object of class <code>UCI</code>. In the case of automatic
	 * detection of protocol, sometimes the command <code>"uci"</code>
	 * is sent after the command <code>"xboard"</code>. This is done by the
	 * GUI in order to check which of the two protocols the engine supports.
	 * In such cases, we go with <code>UCI</code> when both are
	 * supported, and with <code>XBoard</code> when only <code>XBoard</code>
	 * is supported by the GUI. Hence, a uciConsole is necessary, even from
	 * within <code>XBoard</code>.
	 */
	UCI uciConsole;
	/**
	 * Default constructor of <code>XBoard</code>, overridden to create a reference
	 * to the <code>UCI</code> object, {@link #uciConsole}
	 */
	public XBoard()
	{
		uciConsole=new UCI();
	}
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
			commandString=commandString.toLowerCase();
			cmdString=commandString.split("\\s");
			if(	cmdString[0].matches("new")||
				cmdString[0].matches("post")||
				cmdString[0].matches("go")||
				cmdString[0].matches("force")||
				cmdString[0].matches("INPUT MOVES")||
				cmdString[0].matches("level")||
				cmdString[0].matches("time")||
				cmdString[0].matches("ping")||
				cmdString[0].matches("usermove")||
				cmdString[0].matches("protover")||
				cmdString[0].matches("setboard")||
				cmdString[0].matches("random"))
				execute(commandString);
			else if(cmdString[0].matches("uci"))
			{
				uciConsole.start();
				break;
			}
			else if(cmdString[0].matches("accepted")||
					cmdString[0].matches("rejected"))
			{
				//ignore
			}
			else if(cmdString[0].matches("quit"))
				break;
			else
				execute(Definitions.errorString+" "+commandString);
		}
		inputStream.close();
	}
	public void execute(String commandString)
	{
		String[] splitString=commandString.split("\\s");
		if(splitString[0].matches(Definitions.errorString))
			System.out.println(Definitions.errorInCommandString+splitString[1]);
		else
		{
			if(splitString[0].matches("protover"))
			{
				protocolVersion=Byte.parseByte(splitString[1]);
				System.out.println("protocol version "+protocolVersion+" accepted");
				setFeatures();
			}
			else if(splitString[0].matches("ping"))
			{
				System.out.println("pong "+splitString[1]);
			}
			else if(splitString[0].matches("new"))
			{
				//create new game
				System.out.println("New Game Created");
			}
			else if(splitString[0].matches("post"))
			{
				//send output
			}
			else if(splitString[0].matches("random"))
			{
				//ignore, or add random value to evaluation.
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
				System.out.println(commandString);
		}
	}
	/**
	 * This is the function which sets the features depending upon the
	 * XBoard protocol version. If it is greater than 2, feature commands
	 * are to be passed to the GUI. Should start with "feature done=0" and end
	 * with "feature done=1"
	 */
	private void setFeatures()
	{
		//start setting features
		System.out.println("feature done=0");
		//set features here
		System.out.println("feature analyze=0");
		System.out.println("feature usermove=1");
		System.out.println("feature setboard=1");
		System.out.println("feature time=0");
		System.out.println("feature sigint=0");
		System.out.println("feature sigterm=0");
		System.out.println("feature colors=0");
		System.out.println("feature ping=1");
		System.out.println("feature draw=0");
		System.out.println("feature pause=0");
		System.out.println("feature variants=normal");
		System.out.println("feature myname="+Definitions.engineName+
				" "+Definitions.engineVersion);
		//feature setting done
		System.out.println("feature done=1");
	}
}