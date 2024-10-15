package com.ceub.pi.effycityservice.repository;

import com.ceub.pi.effycityservice.model.UsuarioEmpresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioEmpresaRepository extends JpaRepository<UsuarioEmpresa, Integer> {
}
