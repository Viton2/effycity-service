package com.ceub.pi.effycityservice.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjetoDTO {
    private Long id;

    @NotNull
    private UsuarioEmpresaDTO usuarioEmpresa;

    @Size(max = 100)
    @NotNull
    private String noProjeto;

    private String dsProjeto;

    private BigDecimal custo;

    @NotNull
    private LocalDate dtCriacao;

    private Integer duracaoMeses;

    @NotNull
    private AreaTematicaDTO areaTematica;

}