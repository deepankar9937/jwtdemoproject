package com.te.cardekho.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



import lombok.Data;

@Data
@Entity
@Table(name = "car_details")
public class CarDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "car_id")
	private int carId;
	
	@Column(name = "car_name")
	private String carName;
	
	@Column(name = "car_company")
	private String carCompany;
	
	@Column(name = "fuel_type")
	private String fuelType;
	
	@Column(name = "power_steering")
	private boolean powerSteering;
	
	@Column(name = "break_system")
	private String breakSystem;
	
	@Column(name = "showroom_price")
	private double showroomPrice;
	
	@Column(name = "onroad_price")
	private double onroadPrice;
	
	@Column(name = "image_url")
	private String imageUrl;
	
	@Column(name = "car_mileage")
	private double mileage;
	
	@Column(name = "seating_capacity")
	private int seatingCapacity;
	
	@Column(name = "engine_capacity")
	private int engineCapacity;
	
	@Column(name = "gear_type")
	private String gearType;
	
	@ManyToOne
	@JoinColumn(name = "admin_id",referencedColumnName = "admin_id")
	private AdminDetails details;
}
