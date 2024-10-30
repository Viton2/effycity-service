package com.ceub.pi.effycityservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
import jakarta.persistence.UniqueConstraint;
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
@Table(name = "tb_usuario_gestor")
public class UsuarioGestor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('tb_usuario_gestor_pk_usuario_gestor_seq'")
    @Column(name = "pk_usuario_gestor", nullable = false)
    private Long id;

    @Size(max = 100)
    @NotNull
    @Column(name = "no_usuario", nullable = false, length = 100)
    private String usuario;

    @Size(max = 100)
    @NotNull
    @Column(name = "ds_email", nullable = false, length = 100)
    private String email;

    @Size(max = 50)
    @Column(name = "no_cargo", length = 50)
    private String cargo;

    @Size(max = 100)
    @Column(name = "no_orgao", length = 100)
    private String orgao;

    @Size(max = 12)
    @Column(name = "nu_telefone", length = 12)
    private String telefone;

    @NotNull
    @ManyToOne(optional = false)
    @ColumnDefault("nextval('tb_usuario_gestor_fk_municipio_seq'")
    @JoinColumn(name = "fk_municipio", nullable = false)
    private Municipio municipio;

    @NotNull
    @ManyToOne(optional = false)
    @ColumnDefault("nextval('tb_usuario_gestor_fk_estado_seq'")
    @JoinColumn(name = "fk_estado", nullable = false)
    private Estado estado;


}