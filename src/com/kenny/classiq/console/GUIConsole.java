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
 * The <code>GUI</code> class represents a Console which will accept
 * commands from the GUI and send appropriate replies. Hence it implements
 * the <code>CommunicationProtocol</code> interface. It extends the <code>
 * Command</code> class to have access to the inherited static data member
 * <code>commandString</code>. It contains an inputReader, a listener and
 * an executor. Additionally, it defines the listen() inherited from the
 * interface.
 * <p>
 * It is defined as an abstract class because the <code>UCI</code> and
 * <code>XBoard</code> classes alone will have objects.
 * @author Kenshin Himura  
 *
 */
public abstract class GUIConsole implements CommunicationProtocol
{
	Command command=new Command();
	/**
	 * Holds an instance of the <code>Runnable</code> class <code>
	 * Listener</code> to faciliatate creation of a listener <code>
	 * Thread</code>.
	 */
	protected Listener listenerRun=new Listener(command);
	/**
	 * Holds an instance of the <code>Runnable</code> class <code>
	 * Listener</code> to faciliatate creation of a listener <code>
	 * Thread</code>.
	 */
	protected InputThread inputReaderRun=new InputThread(command);
	/**
	 * Holds an instance of the <code>Runnable</code> class <code>
	 * Executor</code> to faciliatate creation of a corresponding
	 * executor <code>Thread</code>, depending upon the protocol
	 * of the <code>GUIConsole</code> object.
	 */
	protected Executor executorRun;
	/**
	 * Creates a listener <code>Thread</code> with an instance of the <code>
	 * Runnable</code> class.
	 */
	protected Thread listener=new Thread(listenerRun,"Listener");
	/**
	 * Creates an inputReader <code>Thread</code> with an instance of the <code>
	 * Runnable</code> class.
	 */
	protected Thread inputReader=new Thread(inputReaderRun,"InputReader");
	/**
	 * Declares an executor <code>Thread</code> with an instance of the <code>
	 * Runnable</code> class. The instantiation is done from within the
	 * <code>UCI</code> or <code>XBoard</code> classes.
	 */
	protected Thread executor;
	/**
	 * The overriding method of the listen() declared in the <code>
	 * CommunicationProtocol</code> interface. Has been defined here, as
	 * both protocols will do similar processing with the same threads.
	 */
	public void listen()
	{
		listener.start();
		executor.start();
		inputReader.start();
	}
}
