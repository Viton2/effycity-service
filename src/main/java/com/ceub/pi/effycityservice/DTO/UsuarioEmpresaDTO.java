package com.ceub.pi.effycityservice.DTO;

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
public class UsuarioEmpresaDTO {

    private Integer id;

    @Size(max = 100)
    @NotNull
    private String usuario;

    @Size(max = 100)
    @NotNull
    private String dsEmail;

    @Size(max = 100)
    @NotNull
    private String empresa;

    @Size(max = 14)
    @NotNull
    private String cnpj;

    @Size(max = 12)
    private String telefone;

    @Size(max = 100)
    private String areaAtuacao;

}