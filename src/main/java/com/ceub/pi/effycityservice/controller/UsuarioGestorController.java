package com.ceub.pi.effycityservice.controller;

import com.ceub.pi.effycityservice.DTO.UsuarioGestorDTO;
import com.ceub.pi.effycityservice.model.UsuarioGestor;
import com.ceub.pi.effycityservice.service.UsuarioGestorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuario-gestor")
public class UsuarioGestorController {

    @Autowired
    private UsuarioGestorService usuarioGestorService;

    // Create a new UsuarioGestor
    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<UsuarioGestor> createUsuarioGestor(@RequestBody UsuarioGestor usuarioGestor) {
        UsuarioGestor createdUsuarioGestor = usuarioGestorService.saveUsuarioGestor(usuarioGestor);
        return new ResponseEntity<>(createdUsuarioGestor, HttpStatus.CREATED);
    }

    // Get a UsuarioGestor by ID
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioGestor> getUsuarioGestorById(@PathVariable Integer id) {
        Optional<UsuarioGestor> usuarioGestor = usuarioGestorService.getUsuarioGestorById(id);
        return usuarioGestor.map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Get all UsuarioGestores
    @GetMapping
    public ResponseEntity<List<UsuarioGestorDTO>> getAllUsuarioGestores() {
        List<UsuarioGestorDTO> usuarioGestores = usuarioGestorService.getAllUsuarioGestores();
        return new ResponseEntity<>(usuarioGestores, HttpStatus.OK);
    }

    // Update a UsuarioGestor by ID
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioGestor> updateUsuarioGestor(@PathVariable Integer id, @RequestBody UsuarioGestor usuarioGestorDetails) {
        Optional<UsuarioGestor> updatedUsuarioGestor = usuarioGestorService.updateUsuarioGestor(id, usuarioGestorDetails);
        return updatedUsuarioGestor.map(usuarioGestor -> new ResponseEntity<>(usuarioGestor, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Delete a UsuarioGestor by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuarioGestor(@PathVariable Integer id) throws ClassNotFoundException {
        Optional<UsuarioGestor> usuarioGestor = usuarioGestorService.getUsuarioGestorById(id);
        if (usuarioGestor.isPresent()) {
            usuarioGestorService.deleteUsuarioGestorById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
