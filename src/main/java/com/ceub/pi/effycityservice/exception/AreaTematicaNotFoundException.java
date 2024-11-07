package com.ceub.pi.effycityservice.exception;

public class AreaTematicaNotFoundException extends RuntimeException {
    public AreaTematicaNotFoundException() {
        super("Erro: Area Temática não encontrada.");
    }
}
