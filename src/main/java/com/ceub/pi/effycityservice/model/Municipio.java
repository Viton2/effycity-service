package com.ceub.pi.effycityservice.model;

import com.ceub.pi.effycityservice.DTO.EstadoDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "tb_municipio")
public class Municipio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('tb_municipio_pk_municipio_seq'")
    @Column(name = "pk_municipio", nullable = false)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @ColumnDefault("nextval('tb_municipio_fk_estado_seq'")
    @JoinColumn(name = "fk_estado", nullable = false)
//    @JsonBackReference()
    private Estado estado;

    @Size(max = 50)
    @NotNull
    @Column(name = "no_municipio", nullable = false, length = 50)
    private String noMunicipio;

    @OneToMany(mappedBy = "municipio")
    private Set<NecessidadeGestor> tbNecessidadeGestors = new LinkedHashSet<>();

    @OneToMany(mappedBy = "municipio")
//    @JsonBackReference("usuario-municipio")
    @JsonIgnore
    private Set<UsuarioGestor> tbUsuarioGestors = new LinkedHashSet<>();

}