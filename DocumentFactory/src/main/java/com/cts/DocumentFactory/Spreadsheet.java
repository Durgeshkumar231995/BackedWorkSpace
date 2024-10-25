package com.cts.DocumentFactory;

public class Spreadsheet extends Document {

	@Override
	public void open() {
		
		System.out.println("Opening Spreadsheet");
	}

	@Override
	public void save() {
		
		System.out.println("Saving Spreadsheet");
	}

	@Override
	public void close() {
		
		System.out.println("Closing Spreadsheet");
	}
}