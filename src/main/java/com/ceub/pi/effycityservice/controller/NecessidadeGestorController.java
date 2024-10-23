package com.ceub.pi.effycityservice.controller;

import com.ceub.pi.effycityservice.DTO.NecessidadeGestorDTO;
import com.ceub.pi.effycityservice.model.NecessidadeGestor;
import com.ceub.pi.effycityservice.service.NecessidadeGestorService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/necessidade-gestor")
public class NecessidadeGestorController {

    private final NecessidadeGestorService service;

    public NecessidadeGestorController(NecessidadeGestorService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<NecessidadeGestorDTO> createNecessidadeGestor(@Valid @RequestBody NecessidadeGestor necessidade) {
        NecessidadeGestorDTO necessidadeGestor = service.createNecessidadeGestor(necessidade);
        return ResponseEntity.ok(necessidadeGestor);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NecessidadeGestorDTO> getNecessidadeGestorById(@PathVariable Long id) {
        NecessidadeGestorDTO necessidadeGestorDTO = service.getNecessidadeGestorById(id);
        return ResponseEntity.ok(necessidadeGestorDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NecessidadeGestorDTO> updateNecessidadeGestor(@PathVariable Long id, @RequestBody NecessidadeGestor necessidade) {
        NecessidadeGestorDTO necessidadeGestorDTO = service.updateNecessidadeGestor(id, necessidade);
        return ResponseEntity.ok(necessidadeGestorDTO);
    }

    @GetMapping
    public ResponseEntity<Page<NecessidadeGestorDTO>> getAllNecessidadeGestorPage(
            @PageableDefault(size = 20, sort = "dtCriacao", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<NecessidadeGestorDTO> gestorPage = service.getAllNecessidadeGestorPage(pageable);
        return ResponseEntity.ok(gestorPage);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteNecessidadeGestorById(@PathVariable Long id) {
        service.deleteNecessidadeGestor(id);
        return ResponseEntity.noContent().build();
    }
}
