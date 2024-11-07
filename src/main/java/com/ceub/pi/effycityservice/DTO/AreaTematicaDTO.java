package com.ceub.pi.effycityservice.DTO;

import com.ceub.pi.effycityservice.model.AreaTematica;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AreaTematicaDTO {
    private Long id;
    private String dsAreaTematica;

    public static AreaTematica convertToModel(AreaTematicaDTO dto){
        AreaTematica areaTematica = new AreaTematica();
        areaTematica.setId(dto.id);
        areaTematica.setDsAreaTematica(dto.getDsAreaTematica());
        return areaTematica;
    }
}
