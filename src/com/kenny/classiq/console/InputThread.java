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

import com.kenny.classiq.Main;

/**
 * The <code>InputThread</code> class implements <code>Runnable</code>
 * and is helpful in creating a thread to enable getting inputs quickly from
 * the console or the pipe. It is similar for both protocols (<code>UCI</code>
 * and <code>XBoard</code>)
 * @author Kenshin Himura  
 * 
 */
public class InputThread implements Runnable
{
	private Command command;
	/**
	 * Holds a boolean which determines the life of the thread. When
	 * an eception is caught, this is set to false, and the run() ends.
	 */
	private boolean alive=true;
	public InputThread(Command command)
	{
		this.command=command;
	}
	/**
	 * Overrides the run() of <code>Runnable</code>. Its operation is
	 * very simple. It keeps checking for a new input command every 50 ms,
	 * and saves it in commandString for access by other threads.
	 */
	public void run()
	{
		while(alive)
		{
			try
			{
				
				synchronized(command)
				{
					if(command.commandArray.isEmpty())
					{
						command.commandString=Main.inputStream.nextLine().toLowerCase();
						command.newCommand=true;
					}
					command.notifyAll();
					command.wait();
				}
			}
			catch(Exception ex)
			{
		      alive=false;
		      System.out.println("Reading input failed.");
		      ex.printStackTrace();
		    }
		  }
	}
}