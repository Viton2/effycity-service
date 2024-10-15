package com.ceub.pi.effycityservice.DTO;

import com.ceub.pi.effycityservice.model.AreaTematica;
import com.ceub.pi.effycityservice.model.UsuarioEmpresa;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class ProjetoDTO {
    private Integer id;

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