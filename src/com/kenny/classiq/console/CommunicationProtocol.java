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
	/**
	 * It is the function which executes the commands parsed by the
	 * listener. It is used to check for specific cases and then call
	 * the respective functions to execute such commands, by passing
	 * the correct corresponding paramaters to those functions.
	 * @param commandString The full command to be executed, as a
	 * <code>String</code>.
	 */
	public void execute(String commandString);
}
