package com.kenny.classiq.console;

import java.util.Scanner;

import com.kenny.classiq.Main;
import com.kenny.classiq.definitions.Definitions;

/**
 * <code>XBoard</code> is the class used to represent the WinBoard
 * or XBoard communication protocol. It implements the <code>
 * CommunicationProtocol</code> interface to make use of its
 * functions, which are common to both <code>XBoard</code> and
 * <code>UCI</code> protocols. Extends <code>GUIConsole</code> for
 * obvious reasons.
 * @author Kenshin Himura (Sudarsan Balaji)
 * 
 */
public class XBoard extends GUIConsole
{
	/**
	 * Holds the protocol version of the XBoard protocol. The default
	 * protocol version Kenny ClassIQ uses is 1.
	 */
	private byte protocolVersion=1;
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
		
	}
	/**
	 * Overrides the start() of <code>Thread</code>. Constructs a <code>
	 * XBoardExecutor</code>, initializes the protocol, and listens.
	 */
	public void start()
	{
		executorRun=new XBoardExecutor();
		executor=new Thread(executorRun);
		init();
		listen();
	}
	/**
	 * This function is used to initialize the various parameters and
	 * variables of the protocol. In addition to calling the setFeatures()
	 * method, it also sends the known commands to the listener thread.
	 */
	public void init()
	{
		System.out.println("xboard");
		commandString=Main.inputStream.nextLine();
		if(commandString.startsWith("protover"))
		{
			String[] split=commandString.split("\\s");
			if(split.length>1)
				protocolVersion=Byte.parseByte(split[1]);
			System.out.println("accepted protover "+protocolVersion);
			setFeatures();
		}
		else
			System.out.println("defaulted to protover "+protocolVersion);
		String[] knownCommands={"new",
								"post",
								"go",
								"force",
								"hard",
								"random",
								"easy",
								"INPUT MOVES",
								"level",
								"time",
								"ping",
								"usermove",
								"setboard",
								"?",
								"black",//added for protocol 1 support
								"white",//added for protocol 1 support
								"quit"};
		listenerRun.setKnownCommands(knownCommands);
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
			System.out.println(	 "feature analyze=0 usermove=1 setboard=1 "
								+"time=0 sigint=0 sigterm=0 colors=0 ping=1 "
								+"draw=0 pause=0 variants=normal myname="
								+Definitions.engineName+" "
								+Definitions.engineVersion);
			//feature setting done
			System.out.println("feature done=1");
		}
	}
}