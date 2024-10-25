package com.stackroute.swaggerautoconfbean.config;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.stereotype.Component;

import jakarta.activation.DataSource;

//implement DataSource interface in CustomDataSource Class to override the methods
@Component
public class CustomDataSource  implements DataSource{

	@Override
	public InputStream getInputStream() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OutputStream getOutputStream() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getContentType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
    
	//Override the DataSource interface methods

	    
	}