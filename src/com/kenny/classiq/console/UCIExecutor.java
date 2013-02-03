package com.kenny.classiq.console;

/**
 * The <code>UCIExecutor</code> class extends <code>Executor</code> and thus
 * inherits its run() method by default. All that remains is to define its
 * execute() method properly, according to the <code>UCI</code> protocol.
 * @author Kenshin Himura (Sudarsan Balaji)
 *
 */
public class UCIExecutor extends Executor
{
	/**
	 * It is the function which executes the commands parsed by the
	 * listener. It is used to check for specific cases and then call
	 * the respective functions to execute such commands, by passing
	 * the correct corresponding paramaters to those functions, according
	 * to the <code>UCI</code> protocol. It is yet to be defined.
	 * @param commandString The full command to be executed, as a
	 * <code>String</code>.
	 */
	public void execute(String commandString)
	{
		
	}
}