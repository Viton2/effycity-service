package com.ceub.pi.effycityservice.exception;

public class UsuarioEmpresaNotFoundException extends RuntimeException{

    public UsuarioEmpresaNotFoundException() {
        super("Erro: Empresa não encontrada.");
    }
}
