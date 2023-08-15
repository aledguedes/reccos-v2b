package com.reccos.admin.exceptions.core;

public class RefreeNotFoundException extends ModelNotFoundException {

	private static final long serialVersionUID = 1L;

    public RefreeNotFoundException() {
        super("Árbitro não econtrado");
    }

    public RefreeNotFoundException(String message) {
        super(message);
    }
    
}
