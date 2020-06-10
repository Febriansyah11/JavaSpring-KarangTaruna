package com.karang.taruna.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.karang.taruna.models.JWTRequest;
import com.karang.taruna.repository.UserRespository;

@Service
public class JWTUserDetailsService implements UserDetailsService {

	@Autowired
	UserRespository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return new JWTRequest(userRepository.findByUsername(username));
	}

}