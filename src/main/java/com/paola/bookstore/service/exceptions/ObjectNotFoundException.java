package com.paola.bookstore.service.exceptions;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

public class ObjectNotFoundException extends NotFoundException{

	private static final long serialVersionUID = 1L;

	public ObjectNotFoundException() {
		super();
	}

}
