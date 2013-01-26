package com.kenny.classiq;

/**
 * <code>CommunicationProtocol</code> is the interface implemented by
 * the <code>UCI</code> and <code>XBoard</code> classes to create a
 * communication object to communicate with the GUI with the help of
 * pipes or standard input/output from the console.
 * @author Kenshin Himura
 *
 */
public interface CommunicationProtocol
{
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
	 * @param command The command to be executed.
	 */
	public void execute(String command);
}
