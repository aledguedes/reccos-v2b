package com.reccos.admin.exceptions.core;

public class PlayerNotFoundException extends ModelNotFoundException {

	private static final long serialVersionUID = 1L;

    public PlayerNotFoundException() {
        super("Jogador/Atleta não econtrado");
    }

    public PlayerNotFoundException(String message) {
        super(message);
    }
    
}
