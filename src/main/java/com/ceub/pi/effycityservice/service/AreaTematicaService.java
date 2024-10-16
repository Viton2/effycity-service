package com.ceub.pi.effycityservice.service;

import com.ceub.pi.effycityservice.model.AreaTematica;
import com.ceub.pi.effycityservice.repository.AreaTematicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AreaTematicaService {

    @Autowired
    private AreaTematicaRepository areaTematicaRepository;

    // Create or Update an AreaTematica
    public AreaTematica saveAreaTematica(AreaTematica areaTematica) {
        return areaTematicaRepository.save(areaTematica);
    }

    // Retrieve an AreaTematica by ID
    public Optional<AreaTematica> getAreaTematicaById(Long id) {
        return areaTematicaRepository.findById(id);
    }

    // Retrieve all AreaTematicas
    public List<AreaTematica> getAllAreaTematicas() {
        return areaTematicaRepository.findAll();
    }

    // Delete an AreaTematica by ID
    public void deleteAreaTematicaById(Long id) {
        areaTematicaRepository.deleteById(id);
    }
}
