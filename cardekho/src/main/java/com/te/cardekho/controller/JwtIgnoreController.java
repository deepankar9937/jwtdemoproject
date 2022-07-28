package com.te.cardekho.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.cardekho.dto.AdminDetails;
import com.te.cardekho.dto.CarDetails;
import com.te.cardekho.jwtutil.JwtUtil;
import com.te.cardekho.model.AuthenticateRequest;
import com.te.cardekho.model.AuthenticationResponse;
import com.te.cardekho.service.AdminService;
import com.te.cardekho.service.CarService;

@RestController
@RequestMapping(path = "/jwtIgnore")
@CrossOrigin(allowedHeaders = "*",origins = "*")
public class JwtIgnoreController {
	
	@Autowired
	private CarService carService;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private AdminService service;

	
	@GetMapping("/carall")
	public ResponseEntity<?> getAll() {
		List<CarDetails> all = carService.getAll();
		
		if (all != null) {
			return new ResponseEntity<List<CarDetails>>(all,HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("No car found",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody AuthenticateRequest authenticateRequest) {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticateRequest.getUserName(), authenticateRequest.getPassword()));
		} catch (AuthenticationException e) {
			return ResponseEntity.ok(new AuthenticationResponse(null,null,0));
		}
		UserDetails userDetails = userDetailsService.loadUserByUsername(authenticateRequest.getUserName());
		String token = jwtUtil.generateToken(userDetails);
		AdminDetails adminDetails = service.getData(userDetails.getUsername());
		return ResponseEntity.ok(new AuthenticationResponse(token,adminDetails.getAdminRole(),adminDetails.getAdminId()));
	}
	
	@GetMapping("/carget/{id}")
	public ResponseEntity<?> getData(@PathVariable int id) {
		CarDetails data = carService.getData(id);
		if (data != null) {
			return new ResponseEntity<CarDetails>(data,HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("data not found",HttpStatus.OK);
		}
	}
}
