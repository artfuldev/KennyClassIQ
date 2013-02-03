package com.kenny.classiq.console;

import com.kenny.classiq.definitions.Definitions;

/**
 * <code>UCI</code> is the class used to represent the Universal Chess
 * Interface(UCI) communication protocol. It implements the
 * <code>CommunicationProtocol</code> interface to make use of its
 * functions, which are common to both <code>XBoard</code> and
 * <code>UCI</code> protocols. Not fully defined yet. It extends <code>
 * GUIConsole</code>.
 * @author Kenshin Himura (Sudarsan Balaji)
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
		executorRun=new UCIExecutor();
		executor=new Thread(executorRun);
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
				+Definitions.engineVersion);
		System.out.println("id author "+Definitions.authorName);
		System.out.println("uciok");
		String[] knownCommands={"go",
								"isready",
								"ucinewgame",
								"debug",
								"stop",
								"ponderhit",
								"quit",
								"position"};
		listenerRun.setKnownCommands(knownCommands);
	}
}