package com.kenny.classiq.console;

public abstract class Executor extends Command implements Runnable
{
	private boolean alive=true;
	public void run()
	{
		while(alive)
		{
			try
			{
				Thread.sleep(50);
				if(newCommand)
				{
					execute(commandString);
					newCommand=false;
				}
		    }
			catch(Exception ex)
			{
		      alive=false;
		      System.out.println("Reading input failed.");
		      ex.printStackTrace();
		    }
		}
	}
	/**
	 * It is the function which executes the commands parsed by the
	 * listener. It is used to check for specific cases and then call
	 * the respective functions to execute such commands, by passing
	 * the correct corresponding paramaters to those functions.
	 * @param commandString The full command to be executed, as a
	 * <code>String</code>.
	 */
	public abstract void execute(String commandString);
}
