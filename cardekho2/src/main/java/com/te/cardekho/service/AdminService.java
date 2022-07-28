package com.te.cardekho.service;

import java.util.List;

import com.te.cardekho.dto.AdminDetails;


public interface AdminService {

public AdminDetails getData(String username);
	
	public AdminDetails addData(AdminDetails details);
	
	public List<AdminDetails> allData();

	public boolean updateData(int id, AdminDetails adminDetails);
	
	public AdminDetails getDataById(int id);
	
}
