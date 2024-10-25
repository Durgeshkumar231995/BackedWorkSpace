package com.cts.DocumentFactory;

public class DocumentFactoryImpl implements DocumentFactory {
	
    @Override
    public Document createDocument(String documentType) {
    	
        switch (documentType.toLowerCase()) {
        
            case "report":
                return new Report();
                
            case "spreadsheet":
                return new Spreadsheet();
                
            case "presentation":
                return new Presentation();
                
            default:
               return null;
        }
    }
}
