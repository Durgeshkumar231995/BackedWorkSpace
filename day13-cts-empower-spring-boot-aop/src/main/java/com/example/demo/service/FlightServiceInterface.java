package com.example.demo.service;

import java.util.List;

import com.example.demo.model.flight;

public interface FlightServiceInterface {
  public List<flight> getAllFlights();
  public flight getFlightById(int id);
  public void deleteflightById(int id);
  public flight updateFlight(int id,flight f);
  public flight saveFlight(flight f);
  public List<flight> getFlightByName(String flight);
  public String greet(String name);

}
