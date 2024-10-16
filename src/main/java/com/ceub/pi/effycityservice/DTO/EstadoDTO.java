package com.ceub.pi.effycityservice.DTO;

import com.ceub.pi.effycityservice.model.Estado;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstadoDTO {
    private Long id;
    private String sgEstado;  // Sigla do estado (ex: "SP")
    private String noEstado;  // Nome completo do estado (ex: "São Paulo")

    public static EstadoDTO convertToDTO(Estado estado) {
        EstadoDTO dto = new EstadoDTO();
        dto.setId(estado.getId());
        dto.setNoEstado(estado.getNoEstado());
        dto.setSgEstado(estado.getSgEstado());
        return dto;
    }
}
