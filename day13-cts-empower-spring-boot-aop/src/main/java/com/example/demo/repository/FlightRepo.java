package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.flight;
@Repository
public interface FlightRepo extends JpaRepository<flight,Integer>{
	
	//public List<flight> findByFlightname(String fname);
	
	@Query("select f FROM flight f where f.flightname=:f1") // JPQL
	public List<flight> findByFlightnam(@Param("f1") String name);
	
	// native sql query
	
//	@Query(value="select * from flight",nativeQuery=true)
//	public List<flight> getAllF();

}
