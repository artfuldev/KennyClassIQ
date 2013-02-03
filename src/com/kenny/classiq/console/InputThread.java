package com.kenny.classiq.console;

import com.kenny.classiq.Main;

/**
 * The <code>InputThread</code> class implements <code>Runnable</code>
 * and is helpful in creating a thread to enable getting inputs quickly from
 * the console or the pipe. It is similar for both protocols (<code>UCI</code>
 * and <code>XBoard</code>)
 * @author Kenshin Himura (Sudarsan Balaji)
 * 
 */
public class InputThread extends Command implements Runnable
{
	/**
	 * Holds a boolean which determines the life of the thread. When
	 * an eception is caught, this is set to false, and the run() ends.
	 */
	private boolean alive=true;
	/**
	 * Overrides the run() of <code>Runnable</code>. Its operation is
	 * very simple. It keeps checking for a new input command every 50 ms,
	 * and saves it in commandString for access by other threads.
	 */
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