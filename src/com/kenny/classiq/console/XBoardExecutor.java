package com.kenny.classiq.console;

public class XBoardExecutor extends Executor
{
	public void execute(String commandString)
	{
		String[] splitString=commandString.split("\\s");
		if(splitString[0].matches("ping"))
		{
			System.out.println("pong "+splitString[1]);
		}
		else if(splitString[0].matches("level"))
		{
			byte movesPerSide=0, baseMinutes=0, incrementSeconds=0;
			movesPerSide=Byte.parseByte(splitString[1]);
			baseMinutes=Byte.parseByte(splitString[2]);
			incrementSeconds=Byte.parseByte(splitString[3]);
			//Pass arguments to proper function
			System.out.println("Level set to "+movesPerSide+"/"+baseMinutes+
					"/"+incrementSeconds);
		}
	}
}
