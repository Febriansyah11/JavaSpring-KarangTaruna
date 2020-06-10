package com.karang.taruna.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.karang.taruna.config.JWTUtil;
import com.karang.taruna.models.JWTRequest;
import com.karang.taruna.models.JWTResponse;
import com.karang.taruna.models.Users;
import com.karang.taruna.service.JWTUserDetailsService;

@RestController
@CrossOrigin
public class JWTAuthenticationController {

	@Autowired
	private JWTUtil jwtUtil;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	JWTUserDetailsService userDetailsService;

	@PostMapping("/login")
	public ResponseEntity<?> generateToken(@RequestBody Users users) throws Exception {

		try {
			authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(users.getUsername(), users.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}

		final JWTRequest userDetails = (JWTRequest) userDetailsService.loadUserByUsername(users.getUsername());

		final String jwt = jwtUtil.generateToken(userDetails);

		JWTResponse response = new JWTResponse(jwt, userDetails.getId());
		return ResponseEntity.ok(response);
	}

}
