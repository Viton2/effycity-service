package com.ceub.pi.effycityservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "tb_estado")
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('tb_estado_pk_estado_seq'")
    @Column(name = "pk_estado", nullable = false)
    private Integer id;

    @Size(max = 2)
    @NotNull
    @Column(name = "sg_estado", nullable = false, length = 2)
    private String sgEstado;

    @Size(max = 50)
    @NotNull
    @Column(name = "no_estado", nullable = false, length = 50)
    private String noEstado;

    @OneToMany(mappedBy = "estado")
    private Set<Municipio> tbMunicipios = new LinkedHashSet<>();

    @OneToMany(mappedBy = "estado")
    private Set<NecessidadeGestor> tbNecessidadeGestors = new LinkedHashSet<>();

    @OneToMany(mappedBy = "estado")
    private Set<UsuarioGestor> tbUsuarioGestors = new LinkedHashSet<>();

}