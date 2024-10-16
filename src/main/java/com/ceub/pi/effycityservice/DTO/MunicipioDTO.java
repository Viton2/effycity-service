package com.ceub.pi.effycityservice.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MunicipioDTO {
    private Integer id;
    private String noMunicipio;
    private EstadoDTO estado; // Incluindo o estado associado ao município
}
