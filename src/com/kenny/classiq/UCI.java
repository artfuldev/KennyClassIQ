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
	public void init()
	{
		System.out.println("id name Kenny ClassIQ 0.0.0.1");
		System.out.println("id author Kenshin Himura (Sudarsan Balaji)");
		System.out.println("uciok");
		listen();
	}
	public void listen()
	{
		
	}
	public void execute(String cmd)
	{
		
	}
}
