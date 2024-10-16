package com.ceub.pi.effycityservice.DTO;

import com.ceub.pi.effycityservice.model.Municipio;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MunicipioDTO {
    private Long id;
    private String noMunicipio;
    private EstadoDTO estado; // Incluindo o estado associado ao município

    public MunicipioDTO(Municipio municipio) {
        this.id = municipio.getId();
        this.noMunicipio = municipio.getNoMunicipio();
        this.estado = EstadoDTO.convertToDTO(municipio.getEstado());
    }
}
