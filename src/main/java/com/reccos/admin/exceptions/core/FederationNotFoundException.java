package com.reccos.admin.exceptions.core;

public class FederationNotFoundException extends ModelNotFoundException {

	private static final long serialVersionUID = 1L;

	public FederationNotFoundException() {
        super("Federação não econtrada");
    }

    public FederationNotFoundException(String message) {
        super(message);
    }

}