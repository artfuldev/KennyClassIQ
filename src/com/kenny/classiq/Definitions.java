package com.kenny.classiq;

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
	public static final String authorName="Kenshin Himura (Sudarsan Balaji)";
	public static final String engineName="Kenny ClassIQ";
	public static final String engineVersion="0.0.0.3";
	public static final String errorString="error";
	public static final String errorInCommandString="Error (unknown command): ";
}
