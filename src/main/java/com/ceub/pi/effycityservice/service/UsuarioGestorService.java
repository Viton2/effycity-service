package com.ceub.pi.effycityservice.service;

import com.ceub.pi.effycityservice.DTO.UsuarioGestorDTO;
import com.ceub.pi.effycityservice.exception.UsuarioGestorNotFoundException;
import com.ceub.pi.effycityservice.model.UsuarioGestor;
import com.ceub.pi.effycityservice.repository.UsuarioGestorRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioGestorService {

    private final UsuarioGestorRepository usuarioGestorRepository;
    private ObjectMapper mapper;

    public UsuarioGestorService(UsuarioGestorRepository usuarioGestorRepository, ObjectMapper mapper) {
        this.usuarioGestorRepository = usuarioGestorRepository;
        this.mapper = mapper;
    }

    private UsuarioGestorDTO convertToDTO(UsuarioGestor usuarioGestor) {
        return mapper.convertValue(usuarioGestor, UsuarioGestorDTO.class);
    }

    private UsuarioGestor validateUsuarioGestorExists(Integer id) {
        Optional<UsuarioGestor> usuarioGestor = usuarioGestorRepository.findById(id);
        if (usuarioGestor.isPresent()) {
            return usuarioGestor.get();
        }throw new UsuarioGestorNotFoundException();
    }

    // Create or Update UsuarioGestor
    public UsuarioGestor saveUsuarioGestor(UsuarioGestor usuarioGestor) {
        return usuarioGestorRepository.save(usuarioGestor);
    }

    // Retrieve a UsuarioGestor by ID
    public Optional<UsuarioGestor> getUsuarioGestorById(Integer id) {
        return Optional.of(validateUsuarioGestorExists(id));
    }

    // Retrieve all UsuarioGestores
    public List<UsuarioGestorDTO> getAllUsuarioGestores() {
        List<UsuarioGestor> all = usuarioGestorRepository.findAll();
        List<UsuarioGestorDTO> dtos = new ArrayList<>();
        all.forEach(usuarioGestor -> dtos.add(convertToDTO(usuarioGestor)));
        return dtos;
    }

    // Delete a UsuarioGestor by ID
    public void deleteUsuarioGestorById(Integer id) {
        usuarioGestorRepository.deleteById(id);
    }

    // Update an existing UsuarioGestor
    public Optional<UsuarioGestor> updateUsuarioGestor(Integer id, UsuarioGestor usuarioGestorDetails) {
        return usuarioGestorRepository.findById(id).map(existingUsuarioGestor -> {
            existingUsuarioGestor.setUsuario(usuarioGestorDetails.getUsuario());
            existingUsuarioGestor.setEmail(usuarioGestorDetails.getEmail());
            existingUsuarioGestor.setCargo(usuarioGestorDetails.getCargo());
            existingUsuarioGestor.setOrgao(usuarioGestorDetails.getOrgao());
            existingUsuarioGestor.setTelefone(usuarioGestorDetails.getTelefone());
            existingUsuarioGestor.setMunicipio(usuarioGestorDetails.getMunicipio());
            existingUsuarioGestor.setEstado(usuarioGestorDetails.getEstado());
            return usuarioGestorRepository.save(existingUsuarioGestor);
        });
    }
}
