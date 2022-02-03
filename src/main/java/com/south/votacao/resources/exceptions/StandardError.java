package com.south.votacao.resources.exceptions;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class StandardError {

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh/MM/ss")
	private LocalDateTime timestamp;
	private String status;
	private String message;

	List<String> errors = new ArrayList<>();

	public StandardError() {
		super();
	}

	public StandardError(LocalDateTime timestamp, String status, String message, List<String> errors) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.message = message;
		this.errors = errors;
	}

	public StandardError(LocalDateTime timestamp, String status, String message) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.message = message;
		this.errors = errors;
	}


	public StandardError(long currentTimeMillis, int value, String message2) {
		this.message = message2;
		this.status= String.valueOf(value);
		this.timestamp =LocalDateTime.now();
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

}