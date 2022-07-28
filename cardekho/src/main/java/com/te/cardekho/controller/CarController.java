package com.te.cardekho.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.cardekho.dto.CarDetails;
import com.te.cardekho.model.ResponceMessage;
import com.te.cardekho.service.CarService;


@RestController
@RequestMapping(path = "/car")
@CrossOrigin(allowedHeaders = "*" ,origins = "*")

public class CarController {

	@Autowired
	private CarService service;

	@PostMapping("/caradd")
	public ResponseEntity<?> addData(@RequestBody CarDetails details) {
		try {
			service.addData(details);
			return ResponseEntity.ok(new ResponceMessage(false,HttpStatus.OK,"Car Addded Succcessfully"));
		} catch (Exception e) {
			return ResponseEntity.ok(new ResponceMessage(true, HttpStatus.INTERNAL_SERVER_ERROR, "SomeThing Went Worng"));
		}
	}
	
	@DeleteMapping("/cardelete/{id}")
	public ResponseEntity<?> deleteCar(@PathVariable int id) {
		if (service.deleteCar(id)) {
			return ResponseEntity.ok(new ResponceMessage(false, HttpStatus.OK, "Car Deleted Successfully"));
		} else {
			return ResponseEntity.ok(new ResponceMessage(true, HttpStatus.INTERNAL_SERVER_ERROR, "Car Not Deleted"));
		}
		
	}
	
	
	@PutMapping("/carUpdate/{id}")
	public ResponseEntity<?> updateCar(@PathVariable int id, @RequestBody CarDetails carDetails) {
		try {
			service.updateCar(id, carDetails);
			return ResponseEntity.ok(new ResponceMessage(false, HttpStatus.OK, "Car Updated Successfully"));
		} catch (Exception e) {
			return ResponseEntity.ok(new ResponceMessage(true, HttpStatus.INTERNAL_SERVER_ERROR, "Car Update Unsuccessfully"));
		}
	}
	
	
}
