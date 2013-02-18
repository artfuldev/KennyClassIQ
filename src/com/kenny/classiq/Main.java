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

package com.kenny.classiq;

import java.util.Scanner;
import com.kenny.classiq.console.GUIConsole;
import com.kenny.classiq.console.UCI;
import com.kenny.classiq.console.XBoard;
import com.kenny.classiq.definitions.Definitions;

/**
 * The <code>Main</code> class serves just like a main() function
 * in a C++ program. It is used to call other functions. Here, the
 * communication protocols of the GUI are created according to the
 * first received commands. Later, this may be expanded to tell
 * the difference between GUI and a user. The commands received from
 * the GUI are used to play the game (internally).
 * @author Kenshin Himura  
 * 
 */
public class Main
{
	/**
	 * A <code>Scanner</code> object representing the input stream
	 * of the console, or the pipe, in case of GUI communication.
	 * Made public so that the <code>Scanner</code> may be used by
	 * threads other than the main thread.
	 */
	public static Scanner inputStream=new Scanner(System.in);
	/**
	 * A <code>String</code> representing the protocol type, as
	 * obtained through the <code>Scanner</code> object. As of now,
	 * it is used to decide if the communication protocol is
	 * <code>XBoard</code> or <code>UCI</code>, but later it can
	 * be used to identify if it is a GUI at all.
	 */
	public static String protocolType;
	/**
	 * A <code>GUIConsole</code> representing the GUI console. It can
	 * be of either protocol, so is instantiated later.
	 */
	public static GUIConsole guiConsole=null;
	public static boolean uci=false;
	/**
	 * The main function of the <code>Main</code> class is declared as
	 * a static function so that it can be called without an instance
	 * of the <code>Main</code> class. It gets inputs and then starts
	 * the corresponding communication protocol, <code>UCI</code>
	 * or <code>XBoard</code>.
	 * <p>
	 * As of now, no arguments have been defined which can be passed.
	 * @param args Arguments to the <code>main</code> function.
	 */
	public static void main(String[] args)
	{
		//Print introductory and debug messages
		System.out.println(Definitions.engineName+" "+Definitions.engineVersion
				+" by "+Definitions.authorName+" ("+Definitions.internalAuthorName
				+")");
		System.out.println("Available Processors: "
				+Runtime.getRuntime().availableProcessors());
		System.out.println("Available Memory: "
				+Runtime.getRuntime().freeMemory()/1024/1024
				+" MB");
		//Get protocol type from console/pipe and start proper guiConsole
		protocolType=inputStream.nextLine();
		if(protocolType.matches("uci"))
		{
			uci=true;
			guiConsole=new UCI();
		}
		if(protocolType.matches("xboard"))
			guiConsole=new XBoard();
		guiConsole.start();
		//else, create custom console or GUI
	}
}