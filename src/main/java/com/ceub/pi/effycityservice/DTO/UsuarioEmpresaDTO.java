package com.ceub.pi.effycityservice.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioEmpresaDTO {

    private Long id;

    @Size(max = 100)
    @NotNull
    private String usuario;

    @Size(max = 100)
    @NotNull
    private String dsEmail;

    @Size(max = 100)
    @NotNull
    private String empresa;

    @Size(max = 14)
    @NotNull
    private String cnpj;

    @Size(max = 12)
    private String telefone;

    @Size(max = 100)
    private String areaAtuacao;

}