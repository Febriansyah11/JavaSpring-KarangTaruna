package com.karang.taruna.models;

public class JWTResponse {

	private String jwt;
	private String id;

	public JWTResponse() {
	}

	public JWTResponse(String jwt, String id) {
		this.jwt = jwt;
		this.id = id;
	}

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
