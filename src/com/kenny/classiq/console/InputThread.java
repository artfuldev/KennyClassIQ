package com.kenny.classiq.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputThread extends Thread
{

	/**
	 * Holds the commands sent to the console.
	 */
	protected String commandString;
	private boolean alive=true;
	private boolean available=false;
	public void run()
	{
		InputStreamReader inputReader=new InputStreamReader(System.in);
		BufferedReader inputStream = new BufferedReader(inputReader);
		while(alive)
		{
			try
			{
				Thread.sleep(50);
				if(available)
					continue;
				commandString = inputStream.readLine();
				available = true;
		    }
			catch(InterruptedException | IOException ex)
			{
		      alive=false;
		      System.out.println("Reading input failed.");
		      ex.printStackTrace();
		    }
		  }
	}
}
