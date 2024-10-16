package com.ceub.pi.effycityservice.repository;

import com.ceub.pi.effycityservice.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {

}
