package com.te.cardekho.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.te.cardekho.dto.CarDetails;


public interface CarService {

	public CarDetails addData(CarDetails details);

	public CarDetails getData(int id); 
	
	public List<CarDetails> getAll();

	public boolean deleteCar(int id);
	
	public boolean updateCar(int id, CarDetails carDetails);
}
