package com.reccos.admin.exceptions.core;

public class ScoreNotFoundException extends ModelNotFoundException {

	private static final long serialVersionUID = 1L;
	
	public ScoreNotFoundException() {
        super("Tabela de pontuação não econtrada");
    }

	public ScoreNotFoundException(String message) {
		super(message);
	}

}
