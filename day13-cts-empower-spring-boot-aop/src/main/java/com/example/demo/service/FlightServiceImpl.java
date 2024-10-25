package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.FlightAlreadyExist;
import com.example.demo.exception.FlightNotPrestBySpecificId;
import com.example.demo.model.flight;
import com.example.demo.repository.FlightRepo;
@Service
public class FlightServiceImpl implements FlightServiceInterface {
@Autowired
private FlightRepo frepo;
	@Override
	public List<flight> getAllFlights() {
		// TODO Auto-generated method stub
		
		List<flight> flist=frepo.findAll();
		return flist;
	}

	@Override
	public flight getFlightById(int id) {
		// TODO Auto-generated method stub
	     Optional<flight> oflight=frepo.findById(id);
	     if(!oflight.isPresent())
	     {
	    	 throw new FlightNotPrestBySpecificId("Flight not there by "+id+" flight id");
	     }
	    
		return oflight.get();
	}

	@Override
	public void deleteflightById(int id) {
		// TODO Auto-generated method stub
		frepo.deleteById(id);
		
	}
	

	@Override
	public flight updateFlight(int id, flight f) {
		// TODO Auto-generated method stub
		
		Optional<flight> oldflight=frepo.findById(id);
		flight ff=oldflight.get();
		ff.setFlightname(f.getFlightname());
		ff.setFlightno(f.getFlightno());
       return frepo.save(ff);
		
	}

	@Override
	public flight saveFlight(flight f) {
		// TODO Auto-generated method stub
		Optional<flight> optf=frepo.findById(f.getFlightid());
		if(optf.isPresent())
		{
			throw new FlightAlreadyExist("Fligh already present");
		}
		return frepo.save(f);
	}
	
	public List<flight> getFlightByName(String flight)
	{
		return frepo.findByFlightnam(flight);
	}
    
	@Override
	public String greet(String name) {
		// TODO Auto-generated method stub
		System.out.println("I am from greet" );
		return "welcome "+name;
	}
	

}
