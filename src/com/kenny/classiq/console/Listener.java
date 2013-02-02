package com.kenny.classiq.console;

public class Listener extends Command implements Runnable
{
	private boolean alive=true;
	private String knownCommands[];
	public void setKnownCommands(String[] knownCommands)
	{
		this.knownCommands = knownCommands;
	}
	public void run()
	{
		while(alive)
		{
			try
			{
				Thread.sleep(50);
				if((commandString!=null)&&(commandString!=previousCommandString))
					validate();
		    }
			catch(Exception ex)
			{
		      alive=false;
		      System.out.println("Reading input failed.");
		      ex.printStackTrace();
		    }
		  }
	}
	public void validate()
	{
		previousCommandString=commandString;
		newCommand=false;
		for(byte i=0;i<knownCommands.length;i++)
			if(commandString.startsWith(knownCommands[i].toLowerCase()))
				newCommand=true;
		if(newCommand)
			System.out.println(commandString);
		if(commandString.matches("quit"))
			System.exit(0);
	}
}