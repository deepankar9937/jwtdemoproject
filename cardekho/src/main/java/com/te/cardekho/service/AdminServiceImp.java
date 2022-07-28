package com.te.cardekho.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.te.cardekho.dao.AdminDao;
import com.te.cardekho.dto.AdminDetails;
import com.te.cardekho.dto.MyAdminDetails;

@Service
public class AdminServiceImp implements AdminService, UserDetailsService {

	@Autowired
	private AdminDao adminDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AdminDetails adminDetails = adminDao.findByUserName(username);
		if (adminDetails != null) {
			return new MyAdminDetails(adminDetails);
		} else {
			throw new UsernameNotFoundException("username not found");
		}
	}

	@Override
	public AdminDetails getData(String username) {
		return adminDao.findByUserName(username);
	}

	@Override
	public AdminDetails addData(AdminDetails details) {
		return adminDao.save(details);
	}

	@Override
	public List<AdminDetails> allData() {
		return (List<AdminDetails>) adminDao.findAll();
	}

	@Override
	public boolean updateData(int id, AdminDetails adminDetails) {
		AdminDetails details = adminDao.findByAdminId(id);

		if (details != null) {
			details.setAdminEmail(adminDetails.getAdminEmail());
			details.setAdminName(adminDetails.getAdminName());
			details.setPassword(adminDetails.getPassword());
			details.setAdminRole(adminDetails.getAdminRole());
			if (adminDao.save(details) != null) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
		
	}

	@Override
	public AdminDetails getDataById(int id) {
		AdminDetails adminDetails = adminDao.findByAdminId(id);
		if (adminDetails != null) {
			return adminDetails;
		} else {
			return null;
		}
	}

}
