package com.ceub.pi.effycityservice.controller;

import com.ceub.pi.effycityservice.DTO.UsuarioEmpresaDTO;
import com.ceub.pi.effycityservice.model.UsuarioEmpresa;
import com.ceub.pi.effycityservice.service.UsuarioEmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
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
* {
  "usuario": "João Silva",
  "dsEmail": "joao.silva@empresa.com",
  "empresa": "Empresa de Tecnologia",
  "cnpj": "12345678000199",
  "telefone": "11987654321",
  "areaAtuacao": "Desenvolvimento de Software"
}
 */

@RestController
@RequestMapping("/api/usuario-empresa")
public class UsuarioEmpresaController {

    @Autowired
    private UsuarioEmpresaService usuarioEmpresaService;

    // Create a new UsuarioEmpresa
    @PostMapping
    public ResponseEntity<UsuarioEmpresa> createUsuarioEmpresa(@RequestBody UsuarioEmpresa usuarioEmpresa) {
        UsuarioEmpresa createdUsuarioEmpresa = usuarioEmpresaService.saveUsuarioEmpresa(usuarioEmpresa);
        return new ResponseEntity<>(createdUsuarioEmpresa, HttpStatus.CREATED);
    }

    // Get a UsuarioEmpresa by ID
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioEmpresa> getUsuarioEmpresaById(@PathVariable Integer id) {
        Optional<UsuarioEmpresa> usuarioEmpresa = usuarioEmpresaService.getUsuarioEmpresaById(id);
        return usuarioEmpresa.map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Get all UsuarioEmpresas
    @GetMapping
    public ResponseEntity<List<UsuarioEmpresaDTO>> getAllUsuarioEmpresas() {
        List<UsuarioEmpresaDTO> usuarioEmpresas = usuarioEmpresaService.getAllUsuarioEmpresas();
        return new ResponseEntity<>(usuarioEmpresas, HttpStatus.OK);
    }

    // Update a UsuarioEmpresa
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioEmpresa> updateUsuarioEmpresa(@PathVariable Integer id, @RequestBody UsuarioEmpresa usuarioEmpresaDetails) throws ClassNotFoundException {
        UsuarioEmpresa updatedUsuarioEmpresa = usuarioEmpresaService.updateUsuarioEmpresa(id, usuarioEmpresaDetails);
        if (updatedUsuarioEmpresa != null) {
            return new ResponseEntity<>(updatedUsuarioEmpresa, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a UsuarioEmpresa by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuarioEmpresa(@PathVariable Integer id) {
        Optional<UsuarioEmpresa> usuarioEmpresa = usuarioEmpresaService.getUsuarioEmpresaById(id);
        if (usuarioEmpresa.isPresent()) {
            usuarioEmpresaService.deleteUsuarioEmpresaById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
