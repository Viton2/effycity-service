package com.ceub.pi.effycityservice.repository;

import com.ceub.pi.effycityservice.model.Municipio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MunicipioRepository extends JpaRepository<Municipio, Long> {

    Page<Municipio> findAllByEstadoId(Pageable pageable, @Param("estadoId") Long estadoId);

    List<Municipio> findAllByEstadoId(@Param("estadoId") Long estadoId);
}
