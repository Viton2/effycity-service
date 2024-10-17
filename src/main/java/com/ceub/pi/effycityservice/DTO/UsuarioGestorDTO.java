package com.ceub.pi.effycityservice.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioGestorDTO {
    private Long id;
    private String usuario;
    private String email;
    private String cargo;
    private String orgao;
    private String telefone;
    private MunicipioDTO municipio;
    private EstadoDTO estado;
}
