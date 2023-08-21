package com.reccos.admin.exceptions.core;

public class TeamNotFoundException extends ModelNotFoundException {

	private static final long serialVersionUID = 1L;

    public TeamNotFoundException() {
        super("Time não econtrado");
    }

    public TeamNotFoundException(String message) {
        super(message);
    }
    
}
