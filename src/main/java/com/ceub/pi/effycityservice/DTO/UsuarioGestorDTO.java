package com.ceub.pi.effycityservice.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioGestorDTO {
    private Integer id;
    private String usuario;
    private String email;
    private String cargo;
    private String orgao;
    private String telefone;
    private MunicipioDTO municipio;
    private EstadoDTO estado;
}
