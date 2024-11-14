package com.ceub.pi.effycityservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "tb_usuario_empresa")
public class UsuarioEmpresa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pk_usuario_empresa", nullable = false)
    private Long id;

    @Size(max = 100)
    @NotNull
    @Column(name = "no_usuario", nullable = false, length = 100)
    private String usuario;

    @Size(max = 100)
    @NotNull
    @Column(name = "ds_email", nullable = false, length = 100)
    private String dsEmail;

    @Size(max = 100)
    @NotNull
    @Column(name = "no_empresa", nullable = false, length = 100)
    private String empresa;

    @Size(max = 14)
    @NotNull
    @Column(name = "nu_cnpj", nullable = false, length = 14)
    private String cnpj;

    @Size(max = 12)
    @Column(name = "nu_telefone", length = 12)
    private String telefone;

    @Size(max = 100)
    @Column(name = "ds_area_atuacao", length = 100)
    private String areaAtuacao;


}