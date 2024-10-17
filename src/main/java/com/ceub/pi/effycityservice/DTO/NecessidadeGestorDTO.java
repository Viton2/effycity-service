package com.ceub.pi.effycityservice.DTO;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class NecessidadeGestorDTO {

    private Long id;
    private String noNecessidade;
    private String dsNecessidade;
    private BigDecimal nuCusto;
    private LocalDate dtCriacao;

    private UsuarioGestorDTO usuarioGestor;
    private MunicipioDTO municipio;
    private EstadoDTO estado;
    private AreaTematicaDTO areaTematica;
}
