package com.ceub.pi.effycityservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "tb_area_tematica")
public class AreaTematica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('tb_area_tematica_pk_area_tematica_seq'")
    @Column(name = "pk_area_tematica", nullable = false)
    private Long id;

    @Size(max = 100)
    @Column(name = "ds_area_tematica", length = 100)
    private String dsAreaTematica;

    @OneToMany(mappedBy = "areaTematica")
    private Set<NecessidadeGestor> tbNecessidadeGestors = new LinkedHashSet<>();

    @OneToMany(mappedBy = "areaTematica")
    private Set<Projeto> tbProjetos = new LinkedHashSet<>();

}