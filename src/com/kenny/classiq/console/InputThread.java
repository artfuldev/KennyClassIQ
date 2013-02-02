package com.kenny.classiq.console;

import com.kenny.classiq.Main;

public class InputThread extends Command implements Runnable
{
	private boolean alive=true;
	public void run()
	{
		while(alive)
		{
			try
			{
				Thread.sleep(50);
				commandString=Main.inputStream.nextLine().toLowerCase();
			}
			catch(Exception ex)
			{
		      alive=false;
		      System.out.println("Reading input failed.");
		      ex.printStackTrace();
		    }
		  }
	}
}