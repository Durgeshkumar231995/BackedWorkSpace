package com.example.demo.controller;
//import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.flight;
import com.example.demo.service.FlightServiceInterface;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1")
@Validated
public class FlightController {
	@Autowired
	private FlightServiceInterface fsi; 
	@GetMapping("/flights")
	public ResponseEntity<?> fethchFlights()
	{
		List<flight> listf=fsi.getAllFlights();
		return new ResponseEntity<>(listf,HttpStatus.OK);
		
	}
	
	@PostMapping("/addflight")
	public ResponseEntity<?> saveFlight(@Valid @RequestBody flight f)
	{
		flight f2=fsi.saveFlight(f);
		return new ResponseEntity<>(f2,HttpStatus.CREATED);
		
		
	}
    @DeleteMapping("delete/{id}")
    public String deleteByIdFlight(@PathVariable int id)
    {
    	fsi.deleteflightById(id);
    	return "Deleted";
    }
    
    @GetMapping("/flight/{id}")
    public ResponseEntity<?> getFlightById(@PathVariable int id)
    {
    	flight f11=fsi.getFlightById(id);
    	return new ResponseEntity<>(f11,HttpStatus.OK);
    }
    
    @PutMapping("update/{id}")
    public ResponseEntity<?> upadeFlight(@PathVariable int id,@RequestBody flight f)
    {
    	return new ResponseEntity<>(fsi.updateFlight(id, f),HttpStatus.OK);
    }
    
    @GetMapping("byname/{name}")
    public ResponseEntity<?> getFlightsByName(@PathVariable String name)
    {
    return new ResponseEntity<>(fsi.getFlightByName(name),HttpStatus.OK);
    }
    @GetMapping("greet/{name}")
    public String getGreet(@PathVariable String name)
    {
    	return fsi.greet(name);
    }
    
}
