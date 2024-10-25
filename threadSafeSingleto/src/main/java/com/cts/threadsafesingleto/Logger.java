package com.cts.threadsafesingleto;

public class Logger{

	private static volatile Logger instance = null;

	private Logger() {

	}

	public static Logger getInstance() {

		if (instance == null) {
			synchronized (Logger.class) {

				if (instance == null) {
					return instance = new Logger();
				}
			}
		}
		return instance;
	}

	public synchronized void log(String message) {

			System.out.println("Hello, Your message is :  "+message);

	}

}
