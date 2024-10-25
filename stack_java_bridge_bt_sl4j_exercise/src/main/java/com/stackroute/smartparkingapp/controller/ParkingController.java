package com.stackroute.smartparkingapp.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.smartparkingapp.dto.ParkingDto;
import com.stackroute.smartparkingapp.model.Parking;
import com.stackroute.smartparkingapp.repo.ParkingRepo;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * As in this assignment, we are working with demonstrating the  use of sl4j for logging in microservices
 * annotate the class with @RestController annotation,@CrossOrigin and @RequestMapping
 * Please note that the default path to use this controller should be "/api/v1"
 */


@CrossOrigin("*")
@RequestMapping("api/v1")
@RestController
public class ParkingController {


    private static Logger logger = LoggerFactory.getLogger(ParkingController.class);

    private ParkingRepo parkingRepo;
    private ModelMapper modelMapper;

    /**
     * Constructor autowiring should be implemented for the ParkingRepo, ModelMapper
     * without using the new keyword
     **/
    @Autowired
    public ParkingController(ParkingRepo parkingRepo, ModelMapper modelMapper) {

        this.parkingRepo = parkingRepo;
        this.modelMapper = modelMapper;
    }

    /**
     * API Version: 1.0
     * Define a handler method which will add new parking details by reading the Serialized
     * ParkingDto object from request body and save the Parking in database.The logger should log the required info
     * This handler method should return the status messages basis on
     * different situations:
     * 1. 201(CREATED - In case of successful creation of the task
     * 2. 400(Bad Request - In case the request is not readable
     * This handler method should map to the URL "/api/v1/parking" using HTTP POST
     * method".
     * @throws JsonProcessingException 
     */

    @PostMapping("parking")
    public ResponseEntity<String> saveParkingDetails(@RequestBody ParkingDto parkingDto) throws JsonProcessingException {

        logger.info("Inside Post Mapping");


        Parking parking = parkingRepo.save(convertToEntity(parkingDto));

        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = null;
        try {
        	int a=19/0;
        	logger.debug("Inside try block");
            jsonInString = mapper.writeValueAsString(convertToDto(parking));
        } catch (ArithmeticException e) {
            logger.error("json.parser.error", e.getMessage());

        }

        logger.debug("Parking details saved to db");
        ResponseEntity<String> responseEntity = new ResponseEntity<>(jsonInString, HttpStatus.CREATED);
        logger.info("Parking details created");
        return responseEntity;


    }

    /**
     * API Version: 1.0
     * Define a handler method which will update new parking details by reading the Serialized
     * ParkingDto object from request body and update the Parking in database.The logger should log the required info
     * This handler method should return the status messages basis on
     * different situations:
     * 1. 201(CREATED - In case of successful creation of the task
     * 2. 400(Bad Request - In case the request is not readable
     * This handler method should map to the URL "/api/v1/parking" using HTTP PUT
     * method".
     */
    @PutMapping("parking")
    public ResponseEntity<String> updateParkingDetails(@RequestBody ParkingDto parkingDto) {


        logger.info("Inside PutMapping");


        Parking parking = parkingRepo.save(convertToEntity(parkingDto));

        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = null;
        try {
            jsonInString = mapper.writeValueAsString(convertToDto(parking));
        } catch (JsonProcessingException e) {
            logger.error("json.parser.error", e.getMessage());

        }
        ResponseEntity<String> responseEntity = new ResponseEntity<>(jsonInString, HttpStatus.CREATED);
        logger.info("Parking details updated");
        return responseEntity;


    }

    /**
     * API Version: 1.0
     * Define a handler method which will retrieve all parking details
     * The logger should log the required info
     * This handler method should return the status messages basis on
     * different situations:
     * 1. 200(OK) - If the tasks found successfully
     * This handler method should map to the URL "/api/v1/parkings" using HTTP POST
     * method".
     */
    @GetMapping("parkings")
    public ResponseEntity<String> getParkingDetails() {


        logger.info("Inside get all parking details");

        List<Parking> parkingList = parkingRepo.findAll();

        List<ParkingDto> parkingDtos = parkingList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        logger.debug("Parking details retrieved to list");

        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = null;
        try {
            jsonInString = mapper.writeValueAsString(parkingDtos);
        } catch (JsonProcessingException e) {
            logger.error("json.parser.error", e.getMessage());

        }
        ResponseEntity<String> responseEntity = new ResponseEntity<>(jsonInString, HttpStatus.OK);
        logger.info("Parking details retrieved");
        return responseEntity;


    }
    
    @GetMapping("LoggerInfo")
    public String displayLogMessage() {
    	logger.info("Info----");
    	logger.debug("dubug-----");
    	logger.warn("warn----");
    	logger.trace("trace");
    	logger.error("erorr--");

        return "Welcome to logger";
    }

    /**
     * API Version: 1.0
     * Define a handler method which will Delete a parking by reading the Serialized
     * TaskDto object from request body ;
     * This handler method should return any one of the status messages basis on
     * different situations:
     * 1.200(OK) - If the parking deleted successfully.
     * 2.400(BAD REQUEST) - If the request is not readable.
     * This handler method should map to the URL "/api/v1/task" using HTTP DELETE
     * method".
     */
    @DeleteMapping("parking")
    public ResponseEntity<String> getParkingDetails(@RequestBody ParkingDto parkingDto) {

        logger.info("Inside DeleteMapping");

        Optional<Parking> parking = parkingRepo.findById(parkingDto.getParkingId());
        parkingRepo.delete(convertToEntity(parkingDto));

        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = null;
        try {
            jsonInString = mapper.writeValueAsString(convertToDto(parking.get()));
        } catch (JsonProcessingException e) {
            logger.error("json.parser.error", e.getMessage());

        }
        ResponseEntity<String> responseEntity = new ResponseEntity<>(jsonInString, HttpStatus.OK);
        logger.info("Parking details deleted");
        return responseEntity;


    }


    /**
     * This method is used to convert the entity to Dto
     *
     * @param parking
     * @return ParkingDto
     **/
    private ParkingDto convertToDto(Parking parking) {
        ParkingDto parkingDto = null;
        if (parking != null) {

            parkingDto = modelMapper.map(parking, ParkingDto.class);
            if (parkingDto == null) {
                parkingDto = new ParkingDto();
                parkingDto.setParkingId(parking.getParkingId());
                parkingDto.setVehicleType(parking.getVehicleType());
                parkingDto.setDimensions(parking.getDimensions());

            }
            parkingDto = parkingDto == null ? new ParkingDto() : parkingDto;

        }
        return parkingDto;
    }

    /**
     * This method is used to convert the dto to entity
     *
     * @param parkingDto
     * @return Parking
     **/
    private Parking convertToEntity(ParkingDto parkingDto) {
        Parking parking = null;

        if (parkingDto != null) {
            parking = modelMapper.map(parkingDto, Parking.class);
            if (parking == null) {
                parking = new Parking();
                logger.debug("Parking values are being set");

                parking.setParkingId(parkingDto.getParkingId());
                parking.setVehicleType(parkingDto.getVehicleType());
                parking.setDimensions(parkingDto.getDimensions());

            }
        }

        return parking;
    }

}
