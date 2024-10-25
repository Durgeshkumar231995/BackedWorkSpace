package com.cts.DocumentFactory;

public class Report extends Document {
	
	@Override
	public void open() {
		
		System.out.println("Opening Report");
	}

	@Override
	public void save() {
		
		System.out.println("Saving Report");
	}

	@Override
	public void close() {
		
		System.out.println("Closing Report");
	}
}
