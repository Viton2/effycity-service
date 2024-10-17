package com.ceub.pi.effycityservice.exception;

public class NecessidadeGestorNotFoundException extends RuntimeException {
    public NecessidadeGestorNotFoundException() {
        super("Erro: Necessidade de Gestor não encontrada.");
    }
}
