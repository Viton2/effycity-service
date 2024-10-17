package com.ceub.pi.effycityservice.service;

import com.ceub.pi.effycityservice.DTO.EstadoDTO;
import com.ceub.pi.effycityservice.DTO.MunicipioDTO;
import com.ceub.pi.effycityservice.DTO.UsuarioGestorDTO;
import com.ceub.pi.effycityservice.exception.UsuarioGestorNotFoundException;
import com.ceub.pi.effycityservice.model.UsuarioGestor;
import com.ceub.pi.effycityservice.repository.UsuarioGestorRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
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

    public UsuarioGestorDTO toDTO(UsuarioGestor usuarioGestor) {
        UsuarioGestorDTO dto = new UsuarioGestorDTO();

        // Convertendo os atributos simples
        dto.setId(usuarioGestor.getId());
        dto.setUsuario(usuarioGestor.getUsuario());
        dto.setEmail(usuarioGestor.getEmail());
        dto.setCargo(usuarioGestor.getCargo());
        dto.setOrgao(usuarioGestor.getOrgao());
        dto.setTelefone(usuarioGestor.getTelefone());

        // Convertendo o relacionamento Municipio para MunicipioDTO
        if (usuarioGestor.getMunicipio() != null) {
            MunicipioDTO municipioDTO = new MunicipioDTO();
            municipioDTO.setId(usuarioGestor.getMunicipio().getId());
            municipioDTO.setNoMunicipio(usuarioGestor.getMunicipio().getNoMunicipio());
            dto.setMunicipio(municipioDTO);
        }

        // Convertendo o relacionamento Estado para EstadoDTO
        if (usuarioGestor.getEstado() != null) {
            EstadoDTO estadoDTO = new EstadoDTO();
            estadoDTO.setId(usuarioGestor.getEstado().getId());
            estadoDTO.setNoEstado(usuarioGestor.getEstado().getNoEstado());
            estadoDTO.setSgEstado(usuarioGestor.getEstado().getSgEstado());
            dto.setEstado(estadoDTO);
        }

        return dto;
    }


    private UsuarioGestor validateUsuarioGestorExists(Long id) {
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
    public Optional<UsuarioGestor> getUsuarioGestorById(Long id) {
        return Optional.of(validateUsuarioGestorExists(id));
    }

    // Retrieve all UsuarioGestores
    public List<UsuarioGestorDTO> getAllUsuarioGestores() {
        List<UsuarioGestor> all = usuarioGestorRepository.findAll();
        List<UsuarioGestorDTO> dtos = new ArrayList<>();
        all.forEach(usuarioGestor -> dtos.add(toDTO(usuarioGestor)));
        return dtos;
    }

    // Delete a UsuarioGestor by ID
    public void deleteUsuarioGestorById(Long id) {
        usuarioGestorRepository.deleteById(id);
    }

    // Update an existing UsuarioGestor
    public Optional<UsuarioGestor> updateUsuarioGestor(Long id, UsuarioGestor usuarioGestorDetails) {
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
