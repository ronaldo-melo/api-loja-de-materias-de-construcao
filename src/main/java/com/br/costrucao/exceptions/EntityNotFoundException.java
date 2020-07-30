package com.br.costrucao.exceptions;

public class EntityNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public EntityNotFoundException(String messenger) {
		super(messenger);
	}
	
}
