package com.ceub.pi.effycityservice.repository;

import com.ceub.pi.effycityservice.model.NecessidadeGestor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NecessidadeGestorRepository extends JpaRepository<NecessidadeGestor, Long> {

}
