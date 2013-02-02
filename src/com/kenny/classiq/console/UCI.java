package com.kenny.classiq.console;

import com.kenny.classiq.definitions.Definitions;

/**
 * <code>UCI</code> is the class used to represent the Universal Chess
 * Interface(UCI) communication protocol. It implements the
 * <code>CommunicationProtocol</code> interface to make use of its
 * functions, which are common to both <code>XBoard</code> and
 * <code>UCI</code> protocols.
 * @author Kenshin Himura (Sudarsan Balaji)
 *
 */
public class UCI extends GUIConsole
{
	public void start()
	{
		executorRun=new UCIExecutor();
		executor=new Thread(executorRun);
		init();
		listen();
	}
	public void init()
	{
		System.out.println("id name "+Definitions.engineName+" "
				+Definitions.engineVersion);
		System.out.println("id author "+Definitions.authorName);
		System.out.println("uciok");
		System.exit(0);
	}
}
