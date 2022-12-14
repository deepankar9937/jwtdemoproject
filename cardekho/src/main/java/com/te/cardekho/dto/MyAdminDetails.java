package com.te.cardekho.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@SuppressWarnings("serial")
public class MyAdminDetails implements UserDetails{
	
	private AdminDetails adminDetails;

	public MyAdminDetails(AdminDetails adminDetails) {
		this.adminDetails = adminDetails;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority authority = new SimpleGrantedAuthority(adminDetails.getAdminRole());
		List<SimpleGrantedAuthority> list = new ArrayList<SimpleGrantedAuthority>();
		list.add(authority);
		return list;
	}

	@Override
	public String getPassword() {
		return adminDetails.getPassword();
	}

	@Override
	public String getUsername() {
		return adminDetails.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
