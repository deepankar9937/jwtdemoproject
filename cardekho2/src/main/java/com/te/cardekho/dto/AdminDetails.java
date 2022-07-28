package com.te.cardekho.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "admin_details")
public class AdminDetails {

	@Id
	@Column(name = "admin_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int adminId;
	
	@Column(name = "admin_username",unique = true)
	private String userName;
	
	@Column(name = "admin_name")
	private String adminName;
	
	@Column(name = "admin_email")
	private String adminEmail;
	
	@Column(name = "admin_password")
	private String password;
	
	@Column(name = "admin_role")
	private String adminRole;
	
}
