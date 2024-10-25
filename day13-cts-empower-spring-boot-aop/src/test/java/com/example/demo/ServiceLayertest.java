package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.repository.CrudRepository;
import static org.mockito.ArgumentMatchers.any;
import com.example.demo.model.flight;
import com.example.demo.repository.FlightRepo;
import com.example.demo.service.FlightServiceImpl;
import static org.mockito.Mockito.verify;
@SpringBootTest
class ServiceLayertest {
   @Mock 
   private FlightRepo frepo;
   
   @InjectMocks
   private FlightServiceImpl fser;
   private flight f;
   @BeforeEach
   public void setUP()
   {
	   f=new flight();
	   f.setFlightid(111);
	   f.setFlightname("AirAsia");
	   f.setFlightno("AirAsia1");
	   
   }
   
	@Test
	 void testSaveFlight()
	{
	   when(frepo.save(f)).thenReturn(f);
	   assertEquals("AirAsia",fser.saveFlight(f).getFlightname());
	   verify(frepo,times(1)).save(any());
	}
	@Test
	void testGetAll()
	{
	  	flight f2=new flight();
	  	f2.setFlightid(321);
	  	f2.setFlightname("6E-111");
	  	f2.setFlightname("Indigo");
	  	
	  	flight f3=new flight();
	  	f3.setFlightid(444);
	  	f3.setFlightname("6E-201");
	  	f2.setFlightname("Indigo");
	  	
	  	when(frepo.findAll()).thenReturn(Arrays.asList(f2,f3));
	  	assertEquals(2,fser.getAllFlights().size());
	  	verify(frepo,times(1)).findAll();
	}

}
