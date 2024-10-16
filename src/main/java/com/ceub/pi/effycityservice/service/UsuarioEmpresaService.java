package com.ceub.pi.effycityservice.service;

import com.ceub.pi.effycityservice.DTO.UsuarioEmpresaDTO;
import com.ceub.pi.effycityservice.exception.UsuarioEmpresaNotFoundException;
import com.ceub.pi.effycityservice.model.UsuarioEmpresa;
import com.ceub.pi.effycityservice.repository.UsuarioEmpresaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioEmpresaService {

    private UsuarioEmpresaRepository usuarioEmpresaRepository;
    private ObjectMapper mapper;

    public UsuarioEmpresaService(UsuarioEmpresaRepository usuarioEmpresaRepository, ObjectMapper mapper) {
        this.usuarioEmpresaRepository = usuarioEmpresaRepository;
        this.mapper = mapper;
    }

    private UsuarioEmpresaDTO convertUsuarioEmpresaModelToDTO(UsuarioEmpresa usuarioEmpresa) {
        return mapper.convertValue(usuarioEmpresa, UsuarioEmpresaDTO.class);
    }

    private Optional<UsuarioEmpresa> validateUsuarioEmpresaExists(Long id) {
        Optional<UsuarioEmpresa> usuarioEmpresa = usuarioEmpresaRepository.findById(id);
        if (usuarioEmpresa.isPresent()){
            return usuarioEmpresa;
        }throw new UsuarioEmpresaNotFoundException();
    }

    // Create or Update UsuarioEmpresa
    public UsuarioEmpresa saveUsuarioEmpresa(UsuarioEmpresa usuarioEmpresa) {
        return usuarioEmpresaRepository.save(usuarioEmpresa);
    }

    // Retrieve UsuarioEmpresa by ID
    public Optional<UsuarioEmpresa> getUsuarioEmpresaById(Long id) {
        return usuarioEmpresaRepository.findById(id);
    }

    public UsuarioEmpresa updateUsuarioEmpresa(Long id, UsuarioEmpresa usuarioEmpresa){
        UsuarioEmpresa empresaOptional = validateUsuarioEmpresaExists(id).get();
        empresaOptional.setUsuario(usuarioEmpresa.getUsuario());
        empresaOptional.setDsEmail(usuarioEmpresa.getDsEmail());
        empresaOptional.setEmpresa(usuarioEmpresa.getEmpresa());
        empresaOptional.setCnpj(usuarioEmpresa.getCnpj());
        empresaOptional.setTelefone(usuarioEmpresa.getTelefone());
        empresaOptional.setAreaAtuacao(usuarioEmpresa.getAreaAtuacao());
        return usuarioEmpresaRepository.save(empresaOptional);
//        UsuarioEmpresa updatedUsuarioEmpresa = usuarioEmpresaService.saveUsuarioEmpresa(usuarioEmpresa);
    }

    // Retrieve all UsuarioEmpresa
    public List<UsuarioEmpresaDTO> getAllUsuarioEmpresas() {
        List<UsuarioEmpresa> all = usuarioEmpresaRepository.findAll();
        List<UsuarioEmpresaDTO> dtos = new ArrayList<>();
        all.forEach(ue -> {
            UsuarioEmpresaDTO usuarioEmpresaDTO = convertUsuarioEmpresaModelToDTO(ue);
            dtos.add(usuarioEmpresaDTO);
        });
        return dtos;
    }

    // Delete UsuarioEmpresa by ID
    public void deleteUsuarioEmpresaById(Long id) {
        usuarioEmpresaRepository.deleteById(id);
    }
}
