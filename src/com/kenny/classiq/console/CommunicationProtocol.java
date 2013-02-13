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
 * <code>CommunicationProtocol</code> is the interface implemented by
 * the <code>UCI</code> and <code>XBoard</code> classes to create a
 * communication object to communicate with the GUI with the help of
 * pipes or standard input/output from the console.
 * @author Kenshin Himura (Sudarsan Balaji)
 *
 */
public interface CommunicationProtocol
{
	/**
	 * Used to start the communication protocol. Usually has the definition
	 * of invoking the initializer, then calling the function which sets
	 * certain features(depending upon response from GUI during initialization),
	 * and then finally invoking the listener.
	 */
	public void start();
	/**
	 * Used to initialize the protocol listener, and start the listener
	 * for the specified protocol.
	 */
	public void init();
	/**
	 * Is the listener function which listens to the commands in the
	 * current protocol, ignores the invalid ones, and sends the
	 * properly parsed commands to the <code>execute()</code> function.
	 */
	public void listen();
}
