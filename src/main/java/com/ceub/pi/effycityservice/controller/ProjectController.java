package com.ceub.pi.effycityservice.controller;

import com.ceub.pi.effycityservice.DTO.ProjetoDTO;
import com.ceub.pi.effycityservice.model.Projeto;
import com.ceub.pi.effycityservice.service.ProjectService;
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


@RestController
@RequestMapping("/api/projetos")
public class ProjectController {

    private final ProjectService projetoService;

    public ProjectController(ProjectService projetoService) {
        this.projetoService = projetoService;
    }

    // Create a new Project
    @PostMapping
    public ResponseEntity<Projeto> createProjeto(@RequestBody Projeto projeto) {
        Projeto createdProjeto = projetoService.saveProjeto(projeto);
        return new ResponseEntity<>(createdProjeto, HttpStatus.CREATED);
    }

    // Get a Project by ID
    @GetMapping("/{id}")
    public ResponseEntity<ProjetoDTO> getProjetoById(@PathVariable Long id) {
        Optional<ProjetoDTO> projeto = projetoService.getProjetoById(id);
        return projeto.map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Get all Projects
    @GetMapping
    public ResponseEntity<List<ProjetoDTO>> getAllProjetos() {
        List<ProjetoDTO> projetos = projetoService.getAllProjetos();
        return new ResponseEntity<>(projetos, HttpStatus.OK);
    }

    // Update a Project
    // Update a Project
    @PutMapping("/{id}")
    public ResponseEntity<ProjetoDTO> updateProjeto(@PathVariable Long id, @RequestBody ProjetoDTO projetoDetails) {
        Optional<ProjetoDTO> updatedProjeto = projetoService.updateProjeto(id, projetoDetails);
        return updatedProjeto
                .map(projeto -> new ResponseEntity<>(projeto, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Delete a Project by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProjeto(@PathVariable Long id) {
        projetoService.deleteProjetoById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
