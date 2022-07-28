package com.te.cardekho.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.te.cardekho.dto.AdminDetails;
@Repository
public interface AdminDao extends CrudRepository<AdminDetails, String>{

	public AdminDetails findByUserName(String username);
	
	public AdminDetails findByAdminId(int id);
}
