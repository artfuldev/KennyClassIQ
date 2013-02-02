package com.kenny.classiq;

import java.util.Scanner;

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
 * @author Kenshin Himura (Sudarsan Balaji)
 */
public class Main
{
	/**
	 * A <code>Scanner</code> object representing the input stream
	 * of the console, or the pipe, in case of GUI communication.
	 */
	private static Scanner inputStream=new Scanner(System.in);
	/**
	 * A <code>String</code> representing the protocol type, as
	 * obtained through the <code>Scanner</code> object. As of now,
	 * it is used to decide if the communication protocol is
	 * <code>XBoard</code> or <code>UCI</code>, but later it can
	 * be used to identify if it is a GUI at all.
	 */
	private static String protocolType;
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
		UCI uciConsole=new UCI();
		XBoard xboardConsole=new XBoard();
		System.out.println(Definitions.engineName+" "+Definitions.engineVersion
				+" by "+Definitions.authorName);
		protocolType=inputStream.nextLine();
		if(protocolType.matches("uci"))
			uciConsole.start();
		if(protocolType.matches("xboard"))
			xboardConsole.start();
		//else, create custom console or GUI
		inputStream.close();
	}
}