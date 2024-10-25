package com.cts.DocumentFactory;

public class TestDocumentFactoryApp {
	
	public static void main(String[] args) {
		
		DocumentFactory factory = new DocumentFactoryImpl();

		// Report
		Document report = factory.createDocument("report");
		
		report.open();
		report.save();
		report.close();
		
		System.out.println();

		// Spreadsheet
		Document spreadsheet = factory.createDocument("spreadsheet");
		
		spreadsheet.open();
		spreadsheet.save();
		spreadsheet.close();
		
		System.out.println();

		// Presentation
		Document presentation = factory.createDocument("presentation");
		
		presentation.open();
		presentation.save();
		presentation.close();
	}
}
