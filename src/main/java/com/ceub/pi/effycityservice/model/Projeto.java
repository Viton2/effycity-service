package com.ceub.pi.effycityservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Entity
@Table(name = "tb_projeto")
public class Projeto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('tb_projeto_pk_projeto_seq'")
    @Column(name = "pk_projeto", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @ColumnDefault("nextval('tb_projeto_fk_usuario_empresa_seq'")
    @JoinColumn(name = "fk_usuario_empresa", nullable = false)
    private UsuarioEmpresa usuarioEmpresa;

    @Size(max = 100)
    @NotNull
    @Column(name = "no_projeto", nullable = false, length = 100)
    private String noProjeto;

    @Column(name = "ds_projeto", length = Integer.MAX_VALUE)
    private String dsProjeto;

    @Column(name = "nu_custo", precision = 15, scale = 2)
    private BigDecimal custo;

    @NotNull
    @Column(name = "dt_criacao", nullable = false)
    private LocalDate dtCriacao;

    @Column(name = "nu_duracao_meses")
    private Integer duracaoMeses;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @ColumnDefault("nextval('tb_projeto_fk_area_tematica_seq'")
    @JoinColumn(name = "fk_area_tematica", nullable = false)
    private AreaTematica areaTematica;

}