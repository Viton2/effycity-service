package com.ceub.pi.effycityservice.form;

import com.ceub.pi.effycityservice.model.AreaTematica;
import com.ceub.pi.effycityservice.model.UsuarioEmpresa;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjetoForm {


    @NotNull
    private UsuarioEmpresa usuarioEmpresa;

    @Size(max = 100)
    @NotNull
    private String noProjeto;

    private String dsProjeto;
    @DecimalMin(value = "1")
    @DecimalMax(value = "9999999999999")
    private BigDecimal custo;

    @NotNull
    private LocalDate dtCriacao;

    private Integer duracaoMeses;

    @NotNull
    private AreaTematica areaTematica;
}
