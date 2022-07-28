package com.te.cardekho.model;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponceMessage {
	
	private boolean error;
	
	private HttpStatus status;
	
	private String message;

}
