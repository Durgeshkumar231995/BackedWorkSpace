package com.cts.DocumentFactory;

public class Presentation extends Document {

	@Override
	public void open() {
		
		System.out.println("Opening Presentation");
	}

	@Override
	public void save() {
		
		System.out.println("Saving Presentation");
	}

	@Override
	public void close() {
		
		System.out.println("Closing Presentation");
	}
}