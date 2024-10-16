package com.ceub.pi.effycityservice.exception;

public class MunicipioNotFoundException extends RuntimeException {
    public MunicipioNotFoundException() {
        super("Erro: Município não encontrado");
    }
}
