package com.te.cardekho.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.cardekho.dao.CarDao;
import com.te.cardekho.dto.CarDetails;

@Service
public class CarServiceImp implements CarService{
	
	@Autowired
	private CarDao carDao;
	
	@Override
	public CarDetails addData(CarDetails details) {
		return carDao.save(details);
	}

	@Override
	public CarDetails getData(int id) {
		return carDao.findByCarId(id);
	}

	@Override
	public List<CarDetails> getAll() {
		return (List<CarDetails>) carDao.findAll();
	}

	@Override
	public boolean deleteCar(int id) {
		CarDetails details = carDao.findByCarId(id);
		if (details != null) {
			carDao.delete(details);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean updateCar(int id, CarDetails carDetails) {
		CarDetails details = carDao.findByCarId(id);
		if (details != null) {
			details.setCarName(carDetails.getCarName());
			details.setCarCompany(carDetails.getCarCompany());
			details.setFuelType(carDetails.getFuelType());
			details.setPowerSteering(carDetails.isPowerSteering());
			details.setBreakSystem(carDetails.getBreakSystem());
			details.setShowroomPrice(carDetails.getShowroomPrice());
			details.setOnroadPrice(carDetails.getOnroadPrice());
			details.setImageUrl(carDetails.getImageUrl());
			details.setSeatingCapacity(carDetails.getSeatingCapacity());
			details.setEngineCapacity(carDetails.getEngineCapacity());
			details.setGearType(carDetails.getGearType());
			
			if (carDao.save(details) != null) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

}
