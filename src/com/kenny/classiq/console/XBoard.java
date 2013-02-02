package com.kenny.classiq.console;

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
public class XBoard extends GUIConsole
{
	/**
	 * Holds the protocol version of the XBoard protocol. The default
	 * protocol version Kenny ClassIQ uses is 2.
	 */
	private byte protocolVersion=2;
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
	 * Holds the object of <code>Scanner</code> used to represent the input
	 * stream of the application. Console in the case of console program, or
	 * pipes in the case of GUI interaction.
	 */
	Scanner inputStream;
	/**
	 * Holds an array of Strings, with each String representing a single word
	 * of the command sent by the GUI and received by the listener. 
	 */
	public XBoard()
	{
		uciConsole=new UCI();
		inputStream=new Scanner(System.in);
	}
	public void start()
	{
		run();
		init();
		listen();
	}
	public void init()
	{
		System.out.println("xboard");
		if(commandString.startsWith("protover"))
			execute(commandString);
		else if(commandString.startsWith("uci"))
			uciConsole.start();
		else
		{
			System.out.println("defaulting to protover "+protocolVersion);
			setFeatures();
			validate();
		}
	}
	public void listen()
	{
		while(true)
		{
			validate();
		}
	}
	public void validate()
	{
		if(	commandString.startsWith("new")||
			commandString.startsWith("post")||
			commandString.startsWith("go")||
			commandString.startsWith("force")||
			commandString.startsWith("INPUT MOVES")||
			commandString.startsWith("level")||
			commandString.startsWith("time")||
			commandString.startsWith("ping")||
			commandString.startsWith("usermove")||
			commandString.startsWith("setboard"))
			execute(commandString);
		else if(commandString.startsWith("quit"))
			System.exit(0);
		else if(commandString.startsWith("random")||
				commandString.startsWith("accepted")||
				commandString.startsWith("rejected"))
		{
			//ignore
		}
		else
			execute(Definitions.errorString+" "+commandString);
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
				if(splitString.length>1)
					protocolVersion=Byte.parseByte(splitString[1]);
				System.out.println("protocol version "+protocolVersion+" accepted");
				setFeatures();
			}
			else if(splitString[0].matches("ping"))
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
			//else ignore
				//System.out.println("ignored "+commandString);
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
		if(protocolVersion>1)
		{
			//start setting features, make engine wait
			System.out.println("feature done=0");
			//set features here
			System.out.println("feature analyze=0 usermove=1 setboard=1 "
								+"time=0 sigint=0 sigterm=0 feature colors=0 "
								+"feature ping=1 feature draw=0 pause=0 "
								+"variants=normal myname="+Definitions.engineName
								+" "+Definitions.engineVersion);
			//feature setting done
			System.out.println("feature done=1");
		}
	}
}