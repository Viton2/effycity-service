package com.ceub.pi.effycityservice.controller;

import com.ceub.pi.effycityservice.DTO.UsuarioGestorDTO;
import com.ceub.pi.effycityservice.model.UsuarioGestor;
import com.ceub.pi.effycityservice.service.UsuarioGestorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/*
 {
  "usuario": "Joao Oliveira",
  "email": "joao.oliveira@orgao.gov.br",
  "cargo": "Analista de Projetos",
  "orgao": "Secretaria de Educação",
  "telefone": "1198753423",
  "municipio": {
    "id": 13
  },
  "estado": {
    "id": 11
  }
}*/

@RestController
@RequestMapping("/api/usuario-gestor")
public class UsuarioGestorController {

    private final UsuarioGestorService usuarioGestorService;

    public UsuarioGestorController(UsuarioGestorService usuarioGestorService) {
        this.usuarioGestorService = usuarioGestorService;
    }

    // Create a new UsuarioGestor
    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<UsuarioGestor> createUsuarioGestor(@RequestBody UsuarioGestor usuarioGestor) {
        UsuarioGestor createdUsuarioGestor = usuarioGestorService.saveUsuarioGestor(usuarioGestor);
        return new ResponseEntity<>(createdUsuarioGestor, HttpStatus.CREATED);
    }

    // Get a UsuarioGestor by ID
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioGestor> getUsuarioGestorById(@PathVariable Long id) {
        Optional<UsuarioGestor> usuarioGestor = usuarioGestorService.getUsuarioGestorById(id);
        return new ResponseEntity<>(usuarioGestor.get(), HttpStatus.OK);
    }

    // Get all UsuarioGestores
    @GetMapping
    public ResponseEntity<List<UsuarioGestorDTO>> getAllUsuarioGestores() {
        List<UsuarioGestorDTO> usuarioGestores = usuarioGestorService.getAllUsuarioGestores();
        return new ResponseEntity<>(usuarioGestores, HttpStatus.OK);
    }

    // Update a UsuarioGestor by ID
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioGestor> updateUsuarioGestor(@PathVariable Long id, @RequestBody UsuarioGestor usuarioGestorDetails) {
        Optional<UsuarioGestor> updatedUsuarioGestor = usuarioGestorService.updateUsuarioGestor(id, usuarioGestorDetails);
        return updatedUsuarioGestor.map(usuarioGestor -> new ResponseEntity<>(usuarioGestor, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Delete a UsuarioGestor by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuarioGestor(@PathVariable Long id) {
        Optional<UsuarioGestor> usuarioGestor = usuarioGestorService.getUsuarioGestorById(id);
        if (usuarioGestor.isPresent()) {
            usuarioGestorService.deleteUsuarioGestorById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
