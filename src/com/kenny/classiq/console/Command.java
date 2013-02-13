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

import java.util.ArrayList;

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
	 * access it. Made volatile so multiple threads can access it
	 * simultaneously.
	 */
	protected static volatile String previousCommandString=null;
	/**
	 * Holds the command string, which is the line absorbed from
	 * the console in the case of a user, or the pipe in case of a GUI.
	 * Made volatile so multiple threads can access it simultaneously.
	 */
	protected static volatile String commandString=null;
	/**
	 * Holds the commands from the GUI as an <code>ArrayList</code> of 
	 * <code>String</code>s. Used to capture and execute all command inputs,
	 * without missing even one. Solves a lot of issues. Also removes the
	 * necessity of using a boolean newCommand. Made volatile so that multiple
	 * threads can access it simultaneously.
	 */
	protected static volatile ArrayList<String> commandArray=new ArrayList<String>();
}