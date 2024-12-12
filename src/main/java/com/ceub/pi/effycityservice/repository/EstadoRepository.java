package com.ceub.pi.effycityservice.repository;

import com.ceub.pi.effycityservice.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {

    @Query("SELECT e FROM Estado e ORDER BY e.noEstado ASC")
    List<Estado> findAllOrderByNoEstadoAsc();

}
