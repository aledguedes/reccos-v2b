package com.reccos.admin.exceptions.core;

public class StadiumNotFoundException extends ModelNotFoundException {

	private static final long serialVersionUID = 1L;
	
	public StadiumNotFoundException() {
        super("Estádio não econtrado");
    }

	public StadiumNotFoundException(String message) {
		super(message);
	}

}
