package com.ceub.pi.effycityservice.controller;

import com.ceub.pi.effycityservice.model.AreaTematica;
import com.ceub.pi.effycityservice.service.AreaTematicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/*
* {
  "dsAreaTematica": "Gestão Ambiental"
}
* */

@RestController
@RequestMapping("/api/area-tematica")
public class AreaTematicaController {

    @Autowired
    private AreaTematicaService areaTematicaService;

    // Create a new AreaTematica
    @PostMapping
    public ResponseEntity<AreaTematica> createAreaTematica(@RequestBody AreaTematica areaTematica) {
        AreaTematica createdAreaTematica = areaTematicaService.saveAreaTematica(areaTematica);
        return new ResponseEntity<>(createdAreaTematica, HttpStatus.CREATED);
    }

    // Get an AreaTematica by ID
    @GetMapping("/{id}")
    public ResponseEntity<AreaTematica> getAreaTematicaById(@PathVariable Integer id) {
        Optional<AreaTematica> areaTematica = areaTematicaService.getAreaTematicaById(id);
        return areaTematica.map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Get all AreaTematicas
    @GetMapping
    public ResponseEntity<List<AreaTematica>> getAllAreaTematicas() {
        List<AreaTematica> areaTematicas = areaTematicaService.getAllAreaTematicas();
        return new ResponseEntity<>(areaTematicas, HttpStatus.OK);
    }

    // Update an AreaTematica
    @PutMapping("/{id}")
    public ResponseEntity<AreaTematica> updateAreaTematica(@PathVariable Integer id, @RequestBody AreaTematica areaTematicaDetails) {
        Optional<AreaTematica> existingAreaTematica = areaTematicaService.getAreaTematicaById(id);
        if (existingAreaTematica.isPresent()) {
            AreaTematica areaTematica = existingAreaTematica.get();
            areaTematica.setDsAreaTematica(areaTematicaDetails.getDsAreaTematica());
            AreaTematica updatedAreaTematica = areaTematicaService.saveAreaTematica(areaTematica);
            return new ResponseEntity<>(updatedAreaTematica, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete an AreaTematica by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAreaTematica(@PathVariable Integer id) {
        Optional<AreaTematica> areaTematica = areaTematicaService.getAreaTematicaById(id);
        if (areaTematica.isPresent()) {
            areaTematicaService.deleteAreaTematicaById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
