package com.ceub.pi.effycityservice.repository;

import com.ceub.pi.effycityservice.model.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Projeto, Long> {
}
