package com.ceub.pi.effycityservice.exception;

public class ProjectNotFoundException extends RuntimeException {
    public ProjectNotFoundException() {
        super("Erro: Projeto não encontrado.");
    }
}
