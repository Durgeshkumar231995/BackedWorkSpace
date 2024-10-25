package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.demo.model.flight;
import com.example.demo.repository.FlightRepo;
//@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase
class RepoLayerTest {
@Autowired 
private FlightRepo frepo;
	
	@Test
	public void checkSaveMethod()
	{
		flight f=new flight();
//		f.setFlightid(890);
		f.setFlightno("Air-0001");
		f.setFlightname("AirIndia");
		frepo.save(f);
		flight f1=frepo.findById(f.getFlightid()).get();
		
		assertEquals("AirIndia",f1.getFlightname());
		
	}
	

}
