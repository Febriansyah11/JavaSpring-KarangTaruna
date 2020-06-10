package com.karang.taruna.models;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class JWTRequest implements Serializable, UserDetails {
	private static final long serialVersionUID = 1L;

	private Users users;

	public JWTRequest() {
	}

	public JWTRequest(Users users) {
		this.users = users;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return this.users.getPassword();
	}

	@Override
	public String getUsername() {
		return this.users.getUsername();
	}

	public String getId() {
		return users.getId();
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