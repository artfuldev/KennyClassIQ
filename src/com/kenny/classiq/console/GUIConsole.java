package com.kenny.classiq.console;

public abstract class GUIConsole extends Command implements CommunicationProtocol
{
	protected Listener listenerRun=new Listener();
	protected InputThread inputReaderRun=new InputThread();
	protected Executor executorRun;
	protected Thread listener=new Thread(listenerRun);
	protected Thread inputReader=new Thread(inputReaderRun);
	protected Thread executor;
	public void listen()
	{
			inputReader.start();
			listener.start();
			executor.start();
	}
}
