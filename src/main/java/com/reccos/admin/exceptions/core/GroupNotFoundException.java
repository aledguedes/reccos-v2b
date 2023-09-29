package com.reccos.admin.exceptions.core;

public class GroupNotFoundException extends ModelNotFoundException {

	private static final long serialVersionUID = 1L;

	public GroupNotFoundException() {
        super("Grupo não econtrado");
    }

    public GroupNotFoundException(String message) {
        super(message);
    }

}