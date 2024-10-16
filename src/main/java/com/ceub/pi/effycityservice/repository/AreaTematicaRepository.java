package com.ceub.pi.effycityservice.repository;

import com.ceub.pi.effycityservice.model.AreaTematica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaTematicaRepository extends JpaRepository<AreaTematica, Long> {
}
