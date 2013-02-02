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
		}
		System.out.println("accepted protover "+protocolVersion);
		setFeatures();
		String[] knownCommands={"new",
								"post",
								"go",
								"force",
								"INPUT MOVES",
								"level",
								"time",
								"ping",
								"usermove",
								"setboard"};
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
								+"time=0 sigint=0 sigterm=0 feature colors=0 "
								+"feature ping=1 feature draw=0 pause=0 "
								+"variants=normal myname="+Definitions.engineName
								+" "+Definitions.engineVersion);
			//feature setting done
			System.out.println("feature done=1");
		}
	}
}