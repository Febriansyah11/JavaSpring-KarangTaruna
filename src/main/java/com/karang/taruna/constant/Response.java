package com.karang.taruna.constant;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class Response {
	
	@ResponseStatus(HttpStatus.ACCEPTED)
	public static String RandomResponse(String string) {
		return string;
	}
}
