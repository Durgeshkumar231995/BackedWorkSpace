package com.stackroute.exception;

public class ResponseMessage {
	
	private int statusCode;
    private String message;

    public ResponseMessage(String message)
    {
        super();
        this.message = message;
    }

	public ResponseMessage(int statusCode, String message) {
		super();
		this.statusCode = statusCode;
		this.message = message;
	}
    

}
