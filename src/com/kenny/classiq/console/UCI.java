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

import com.kenny.classiq.definitions.Definitions;

/**
 * <code>UCI</code> is the class used to represent the Universal Chess
 * Interface(UCI) communication protocol. It implements the
 * <code>CommunicationProtocol</code> interface to make use of its
 * functions, which are common to both <code>XBoard</code> and
 * <code>UCI</code> protocols. Not fully defined yet. It extends <code>
 * GUIConsole</code>.
 * @author Kenshin Himura  
 * 
 */
public class UCI extends GUIConsole
{
	/**
	 * Overrides the start() of <code>Thread</code>. Constructs an <code>
	 * UCIExecutor</code>, initializes the protocol, and listens.
	 */
	public void start()
	{
		executorRun=new UCIExecutor(command);
		executor=new Thread(executorRun,"Executor");
		init();
		listen();
	}
	/**
	 * Initialization function of the <code>UCI</code> protocol. Sends
	 * the required messages
	 */
	public void init()
	{
		System.out.println("id name "+Definitions.engineName+" "
				+Definitions.engineMainVersion);
		System.out.println("id author "+Definitions.authorName);
		System.out.println("uciok");
		String[] knownCommands={"go",
								"isready",
								"ucinewgame",
								"debug",
								"stop",
								"ponderhit",
								"quit",
								"position",
								"d"};
		listenerRun.setKnownCommands(knownCommands);
	}
}