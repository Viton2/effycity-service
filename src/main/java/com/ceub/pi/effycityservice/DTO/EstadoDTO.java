package com.ceub.pi.effycityservice.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstadoDTO {
    private Integer id;
    private String sgEstado;  // Sigla do estado (ex: "SP")
    private String noEstado;  // Nome completo do estado (ex: "São Paulo")
}
