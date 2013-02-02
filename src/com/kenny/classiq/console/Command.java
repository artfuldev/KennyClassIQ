package com.kenny.classiq.console;

/**
 * The <code>Command</code> class is used simple to provide for
 * something equivalent to a global variable, whose value can be
 * accessed by many threads. Unfortunately, as java does not support
 * the use of global variables, every <code>Runnable</code> class which
 * should be used in a <code>Thread</code> extends this class, as, again,
 * java does not support extending a class from more than one class.
 * @author Kenshin Himura (Sudarsan Balaji)
 * 
 */
public class Command
{
	/**
	 * Holds the previous command string, used to check if it has changed
	 * between the time it was last checked for change by the threads which
	 * access it.
	 */
	protected static String previousCommandString=null;
	/**
	 * Holds the command string, which is the line absorbed from
	 * the console in the case of a user, or the pipe in case of a GUI.
	 */
	protected static String commandString=null;
	/**
	 * Used to know if the command is a new command, and if it is a command
	 * that the listener understands at all, for each protocol.
	 */
	protected static boolean newCommand=false;
}