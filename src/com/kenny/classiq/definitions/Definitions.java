package com.kenny.classiq.definitions;

/**
 * Includes the standard definitions needed.
 * I previously used to work with C++. Since Java lacks the <code>#define</code>
 * tags used to define constants in C++, I found this workaround. Making
 * the members static makes them accessible without using an object, and making
 * them final makes them constant, just the functionality offered by the 
 * <code>#define</code> tags. I have to include the class name, yes, but its
 * better than not having such a functionality at all!
 * @author Kenshin Himura (Sudarsan Balaji)
 *
 */
public class Definitions
{
	/**
	 * Holds the author name of the program.
	 */
	public static final String authorName="Kenshin Himura (Sudarsan Balaji)";
	/**
	 * Holds the name of the engine.
	 */
	public static final String engineName="Kenny ClassIQ";
	/**
	 * Holds the version of the engine.
	 */
	public static final String engineVersion="0.0.12.4 build 1086";
	/**
	 * Holds the error string.
	 */
	public static final String errorString="error";
	/**
	 * Holds the string to output an error in the recieved command,
	 * usually one which is not understood by the engine.
	 */
	public static final String errorInCommandString="Error (unknown command): ";
	/**
	 * Holds the string to output a debug message.
	 */
	public static final String debugMessage="##debugMsg: ";
	/**
	 * Holds the string representinng the FEN String of the starting
	 * position. Used in the construction of a new <code>Game</code>.
	 */
	public static final String startPositionFEN="rnbqkbnr/pppppppp/8/8/8/8/"
			+"PPPPPPPP/RNBQKBNR w KQkq - 0 1";
}
