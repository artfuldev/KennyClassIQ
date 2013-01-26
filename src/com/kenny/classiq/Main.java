package com.kenny.classiq;

import java.util.Scanner;

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
			uciConsole.init();
		if(protocolType.matches("xboard"))
		{
//			protocolType=inputStream.nextLine();
//			if(protocolType.matches("uci"))
//				uciConsole.init();
//			else
				xboardConsole.init();
		}
		inputStream.close();
	}

}
