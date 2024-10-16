package com.ceub.pi.effycityservice.config.handler;

import lombok.Getter;

@Getter
public enum ProblemType {

    NOT_READABLE("/requisicao-nao-legivel","Requisição não legível"),
    NOT_ACCEPTABLE("/requisicao-nao-aceita","Requisição não aceita"),
    ENTITY_NOT_FOUND("/entidade-nao-encontrada", "Entidade não encontradado"),
    ENTITY_ALREADY_EXIST("/entidade-ja-existente", "Entidade já existente"),
    ENTITY_IN_USE("/entidade-em-uso", "Entidade em uso"),
    BAD_REQUEST("/requisicao-incorreta", "Requisição incorreta");

    private final String title;
    private final String uri;

    ProblemType(String path, String title) {
        this.uri = "http://localhost:8081" + path;
        this.title = title;
    }
}
