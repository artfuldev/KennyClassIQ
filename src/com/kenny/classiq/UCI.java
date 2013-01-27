package com.kenny.classiq;

/**
 * <code>UCI</code> is the class used to represent the Universal Chess
 * Interface(UCI) communication protocol. It implements the
 * <code>CommunicationProtocol</code> interface to make use of its
 * functions, which are common to both <code>XBoard</code> and
 * <code>UCI</code> protocols.
 * @author Kenshin Himura
 *
 */
public class UCI implements CommunicationProtocol
{
	public void start()
	{
		init();
		listen();
	}
	public void init()
	{
		System.out.println("id name "+Definitions.engineName+" "
				+Definitions.engineVersion);
		System.out.println("id author "+Definitions.authorName);
		System.out.println("uciok");
	}
	public void listen()
	{
		System.out.println("Listening...");
	}
	public void execute(String cmd)
	{
		
	}
}
