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
 * @author Kenshin Himura  
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
		executorRun=new XBoardExecutor(command);
		executor=new Thread(executorRun,"Executor");
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
		command.commandString=Main.inputStream.nextLine();
		if(command.commandString.startsWith("protover"))
		{
			String[] split=command.commandString.split("\\s");
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
								"quit",
								"d"};
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
								+Definitions.engineMainVersion);
			//feature setting done
			System.out.println("feature done=1");
		}
	}
}