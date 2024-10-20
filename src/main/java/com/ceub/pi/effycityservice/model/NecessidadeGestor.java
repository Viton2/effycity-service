package com.ceub.pi.effycityservice.model;

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
@Table(name = "tb_necessidade_gestor")
public class NecessidadeGestor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('tb_necessidade_gestor_pk_necessidade_seq'")
    @Column(name = "pk_necessidade", nullable = false)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @ColumnDefault("nextval('tb_necessidade_gestor_fk_usuario_gestor_seq'")
    @JoinColumn(name = "fk_usuario_gestor", nullable = false)
    private UsuarioGestor usuarioGestor;


    @Size(max = 100)
    @NotNull
    @Column(name = "no_necessidade", nullable = false, length = 100)
    private String noNecessidade;

    @Column(name = "ds_necessidade", length = Integer.MAX_VALUE)
    private String dsNecessidade;

    @Column(name = "nu_custo", precision = 15, scale = 2)
    private BigDecimal nuCusto;

    @NotNull
    @Column(name = "dt_criacao", nullable = false)
    private LocalDate dtCriacao;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @ColumnDefault("nextval('tb_necessidade_gestor_fk_municipio_seq'")
    @JoinColumn(name = "fk_municipio", nullable = false)
    private Municipio municipio;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @ColumnDefault("nextval('tb_necessidade_gestor_fk_estado_seq'")
    @JoinColumn(name = "fk_estado", nullable = false)
    private Estado estado;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @ColumnDefault("nextval('tb_necessidade_gestor_fk_area_tematica_seq'")
    @JoinColumn(name = "fk_area_tematica", nullable = false)
    private AreaTematica areaTematica;

}