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

package com.kenny.classiq.definitions;

/**
 * Includes the standard definitions needed.
 * I previously used to work with C++. Since Java lacks the <code>#define</code>
 * tags used to define constants in C++, I found this workaround. Making
 * the members static makes them accessible without using an object, and making
 * them final makes them constant, just the functionality offered by the 
 * <code>#define</code> tags. I have to include the class name, yes, but its
 * better than not having such a functionality at all!
 * @author Kenshin Himura  
 *
 */
public class Definitions
{
	/**
	 * Holds the author name of the program.
	 */
	public static final String authorName="Kenshin Himura";
	/**
	 * Holds the internal (original) author name.
	 */
	public static final String internalAuthorName="Sudarsan Balaji";
	/**
	 * Holds the name of the engine.
	 */
	public static final String engineName="Kenny ClassIQ";
	/**
	 * Holds the main version (MaVN.MiVn) of the engine.
	 */
	public static final String engineMainVersion="0.3";
	/**
	 * Holds the sub version (.MaRN.MiRN build BN) of the engine.
	 */
	public static final String engineSubVersion=" build 3236";
	/**
	 * Holds the complete version of the engine
	 */
	public static final String engineVersion=engineMainVersion+engineSubVersion;
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
