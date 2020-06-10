package com.karang.taruna.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.karang.taruna.models.Users;

public class ExceptionResponse {

	@ResponseStatus(HttpStatus.CONFLICT)
	public static class ExceptionDateAlreadyUsed extends RuntimeException {
		private static final long serialVersionUID = 1L;

		public ExceptionDateAlreadyUsed() {
			super("Date already used!");
		}

	}

	@ResponseStatus(HttpStatus.CONFLICT)
	public static class PhoneNumberAlreadyUsed extends RuntimeException {
		private static final long serialVersionUID = 1L;

		public PhoneNumberAlreadyUsed() {
			super("Phone Number already used!");
		}
	}
	@ResponseStatus(HttpStatus.CONFLICT)
	public static class EmailAddresAlreadyUsed extends RuntimeException {
		private static final long serialVersionUID = 1L;

		public EmailAddresAlreadyUsed() {
			super("Email already used!");
		}
	}
	

	@ResponseStatus(HttpStatus.CONFLICT)
	public static class DateOutOfASchedule extends RuntimeException {
		private static final long serialVersionUID = 1L;

		public DateOutOfASchedule() {
			super("Date out of schedule!");
		}
	}

	@ResponseStatus(HttpStatus.ACCEPTED)
	public static class RandomResponse extends RuntimeException {
		private static final long serialVersionUID = 1L;

		public RandomResponse(String message) {
			super(message);
		}
	}

}