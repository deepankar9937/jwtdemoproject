package com.te.cardekho.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.cardekho.dto.AdminDetails;
import com.te.cardekho.model.ResponceMessage;
import com.te.cardekho.service.AdminService;

@RestController
@RequestMapping(path = "/admin")
@CrossOrigin(allowedHeaders = "*",origins = "*")
public class AdminController {
	
	@Autowired
	private AdminService service;
	
	@GetMapping("/adminget/{username}")
	public ResponseEntity<?> getData(@PathVariable String username) {
		AdminDetails details = service.getData(username);
		if (details != null) {
			return new ResponseEntity<AdminDetails>(details,HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Data not found for E-mail"+username,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/adminadd")
	public ResponseEntity<?> addData(@RequestBody AdminDetails adminDetails) {
		try {
			service.addData(adminDetails);
			return ResponseEntity.ok(new ResponceMessage(false, HttpStatus.OK, "Admin Added Successfully"));
		} catch (Exception e) {
			return ResponseEntity.ok(new ResponceMessage(true, HttpStatus.INTERNAL_SERVER_ERROR, "Something Went Worng"));
		}
	}
	
	@GetMapping("/adminall")
	public ResponseEntity<?> allData() {
		List<AdminDetails> allData = service.allData();
		if (allData != null) {
			return new ResponseEntity<List<AdminDetails>>(allData,HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Somthing went worng",HttpStatus.OK);
		}
		
	}
	
	@PutMapping("/adminupdate/{id}")
	public ResponseEntity<?> updateData(@PathVariable int id,@RequestBody AdminDetails adminDetails) {
		try {
			service.updateData(id,adminDetails);
			return ResponseEntity.ok(new ResponceMessage(false,HttpStatus.OK,"Admin Details Updated"));
		} catch (Exception e) {
			return ResponseEntity.ok(new ResponceMessage(true, HttpStatus.INTERNAL_SERVER_ERROR, "Something Went Wrong"));
		}
	}
	
	@GetMapping("/getadmin/{id}")
	public ResponseEntity<?> getDataById(@PathVariable int id) {
		AdminDetails adminDetails = service.getDataById(id);
		if (adminDetails != null) {
			return new ResponseEntity<AdminDetails>(adminDetails,HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("data not found",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
