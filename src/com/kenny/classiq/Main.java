package com.kenny.classiq;

import java.util.Scanner;

import com.kenny.classiq.protocols.UCI;
import com.kenny.classiq.protocols.XBoard;

public class Main
{
	public static void main(String[] args)
	{
		Scanner inputStream=new Scanner(System.in);
		String protocolType;
		UCI uciConsole=new UCI();
		XBoard xboardConsole=new XBoard();
		protocolType=inputStream.nextLine();
		if(protocolType.matches("uci"))
			uciConsole.start();
		if(protocolType.matches("xboard"))
			xboardConsole.start();
		//else, create custom console or GUI
		inputStream.close();
	}
}
