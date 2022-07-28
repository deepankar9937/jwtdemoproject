package com.te.cardekho.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.te.cardekho.dto.CarDetails;

@Repository
public interface CarDao extends CrudRepository<CarDetails, Integer> {

	public CarDetails findByCarId(int id);
}
