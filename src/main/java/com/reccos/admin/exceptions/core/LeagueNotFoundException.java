package com.reccos.admin.exceptions.core;

public class LeagueNotFoundException extends ModelNotFoundException {

	private static final long serialVersionUID = 1L;

	public LeagueNotFoundException() {
		super("Liga não econtrada");
	}
	
	public LeagueNotFoundException(String message) {
		super(message);
	}

}
