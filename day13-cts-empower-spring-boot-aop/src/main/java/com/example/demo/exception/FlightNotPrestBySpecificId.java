package com.example.demo.exception;

public class FlightNotPrestBySpecificId extends RuntimeException{
	public FlightNotPrestBySpecificId(String msg)
	{
		super(msg);
	}

}
