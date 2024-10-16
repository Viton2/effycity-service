package com.ceub.pi.effycityservice.repository;

import com.ceub.pi.effycityservice.model.UsuarioGestor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioGestorRepository extends JpaRepository<UsuarioGestor, Integer> {

}
