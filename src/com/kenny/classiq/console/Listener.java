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

/**
 * The <code>Listener</code> class, which implements <code>Runnable
 * </code>, serves as a prototype for a genral listener. It has
 * certain known commands, and matches it with the commandString
 * to see if it is a new command, and sets the newCommand variable,
 * so that the executor thread can perform its action.
 * @author Kenshin Himura  
 * 
 */
public class Listener extends Command implements Runnable
{
	/**
	 * Holds a boolean which determines the life of the thread. When
	 * an eception is caught, this is set to false, and the run() ends.
	 */
	private boolean alive=true;
	/**
	 * Holds the known commands of the protocol. Set by the class
	 * representing the protocol upon its initialization.
	 */
	private String knownCommands[];
	/**
	 * Used to set the known commands of a listener, according to the
	 * protocol it belongs to.
	 * @param knownCommands an array of String objects, representing
	 * the commands expected in that particular protocol.
	 */
	public void setKnownCommands(String[] knownCommands)
	{
		this.knownCommands = knownCommands;
	}
	/**
	 * Overrides the run() of <code>Runnable</code>. Its operation is
	 * very simple. It keeps checking for a new commandString every 50 ms,
	 * by comparing with the previousCommand, and then validates it
	 */
	public void run()
	{
		while(alive)
		{
			try
			{
				Thread.sleep(50);
				if((commandString!=null)&&(commandString!=previousCommandString))
					validate();
		    }
			catch(Exception ex)
			{
		      alive=false;
		      System.out.println("Listening failed.");
		      ex.printStackTrace();
		    }
		  }
	}
	/**
	 * This function is used to validate the new commandString as a known
	 * new command. Additionally, it sets the previousCommandString to
	 * reflect the value of the commandString.
	 */
	public void validate()
	{
		previousCommandString=commandString;
		for(byte i=0;i<knownCommands.length;i++)
			if(commandString.startsWith(knownCommands[i].toLowerCase()))
				commandArray.add(commandString);
	}
}