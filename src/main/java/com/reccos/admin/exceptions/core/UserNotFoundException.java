package com.reccos.admin.exceptions.core;

public class UserNotFoundException extends ModelNotFoundException {

	private static final long serialVersionUID = 1L;
	
	public UserNotFoundException() {
        super("Federação não econtrada");
    }

	public UserNotFoundException(String message) {
		super(message);
	}

}
