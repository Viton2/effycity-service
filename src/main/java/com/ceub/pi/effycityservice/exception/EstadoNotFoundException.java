package com.ceub.pi.effycityservice.exception;

public class EstadoNotFoundException extends RuntimeException {
    public EstadoNotFoundException() {
        super("Erro: Estado não encontrado");
    }
}
