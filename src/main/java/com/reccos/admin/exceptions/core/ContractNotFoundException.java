package com.reccos.admin.exceptions.core;

public class ContractNotFoundException extends ModelNotFoundException {

	private static final long serialVersionUID = 1L;

	public ContractNotFoundException() {
        super("Contrato não econtrado");
    }

    public ContractNotFoundException(String message) {
        super(message);
    }

}