package com.ceub.pi.effycityservice.service;

import com.ceub.pi.effycityservice.DTO.AreaTematicaDTO;
import com.ceub.pi.effycityservice.DTO.ProjetoDTO;
import com.ceub.pi.effycityservice.DTO.UsuarioEmpresaDTO;
import com.ceub.pi.effycityservice.model.Projeto;
import com.ceub.pi.effycityservice.model.UsuarioEmpresa;
import com.ceub.pi.effycityservice.repository.ProjectRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProjectService {

    private final ProjectRepository projetoRepository;
    private final ObjectMapper mapper;

    public ProjectService(ProjectRepository projetoRepository, ObjectMapper mapper) {
        this.projetoRepository = projetoRepository;
        this.mapper = mapper;
    }
    private UsuarioEmpresa convertUsuarioEmpresaDTOtoModel(UsuarioEmpresaDTO usuarioDTO){
        return mapper.convertValue(usuarioDTO, UsuarioEmpresa.class);
    }

    // Create or Update a Project
    public Projeto saveProjeto(Projeto projeto) {
        return projetoRepository.save(projeto);
    }


    // Convert Projeto to ProjetoDTO
    private ProjetoDTO convertToDTO(Projeto projeto) {
        ProjetoDTO dto = new ProjetoDTO();
        dto.setId(projeto.getId());
        dto.setNoProjeto(projeto.getNoProjeto());
        dto.setDsProjeto(projeto.getDsProjeto());
        dto.setCusto(projeto.getCusto());
        dto.setDtCriacao(projeto.getDtCriacao());
        dto.setDuracaoMeses(projeto.getDuracaoMeses());

        UsuarioEmpresaDTO usuarioEmpresaDTO = new UsuarioEmpresaDTO();
        usuarioEmpresaDTO.setId(projeto.getUsuarioEmpresa().getId());
        usuarioEmpresaDTO.setUsuario(projeto.getUsuarioEmpresa().getUsuario());
        usuarioEmpresaDTO.setDsEmail(projeto.getUsuarioEmpresa().getDsEmail());
        usuarioEmpresaDTO.setEmpresa(projeto.getUsuarioEmpresa().getEmpresa());
        usuarioEmpresaDTO.setCnpj(projeto.getUsuarioEmpresa().getCnpj());
        usuarioEmpresaDTO.setTelefone(projeto.getUsuarioEmpresa().getTelefone());
        usuarioEmpresaDTO.setAreaAtuacao(projeto.getUsuarioEmpresa().getAreaAtuacao());

        dto.setUsuarioEmpresa(usuarioEmpresaDTO);

        AreaTematicaDTO areaTematicaDTO = new AreaTematicaDTO();
        areaTematicaDTO.setId(projeto.getAreaTematica().getId());
        areaTematicaDTO.setDsAreaTematica(projeto.getAreaTematica().getDsAreaTematica());

        dto.setAreaTematica(areaTematicaDTO);

        return dto;
    }

    public List<ProjetoDTO> getAllProjetos() {
        List<Projeto> projetos = projetoRepository.findAll();
        return projetos.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Retrieve a Project by ID with DTO conversion
    public Optional<ProjetoDTO> getProjetoById(Integer id) {
        return projetoRepository.findById(id)
                .map(this::convertToDTO);
    }

    // Update logic moved to the service layer
    public Optional<ProjetoDTO> updateProjeto(Integer id, ProjetoDTO projetoDetails) {
        Optional<Projeto> existingProjetoOpt = projetoRepository.findById(id);
        if (existingProjetoOpt.isPresent()) {
            Projeto existingProjeto = existingProjetoOpt.get();
            existingProjeto.setNoProjeto(projetoDetails.getNoProjeto());
            existingProjeto.setDsProjeto(projetoDetails.getDsProjeto());
            existingProjeto.setCusto(projetoDetails.getCusto());
            existingProjeto.setDtCriacao(projetoDetails.getDtCriacao());
            existingProjeto.setDuracaoMeses(projetoDetails.getDuracaoMeses());

            // Assuming you convert UsuarioEmpresaDTO to the entity
            // and AreaTematicaDTO to the entity (left that implementation to you)
            // For now, just setting the IDs as reference
            existingProjeto.setUsuarioEmpresa(convertUsuarioEmpresaDTOtoModel(projetoDetails.getUsuarioEmpresa()));
            existingProjeto.getAreaTematica().setId(projetoDetails.getAreaTematica().getId());

            Projeto updatedProjeto = projetoRepository.save(existingProjeto);
            return Optional.of(convertToDTO(updatedProjeto));
        } else {
            return Optional.empty();
        }
    }

//    // Retrieve a Project by ID
//    public Optional<Projeto> getProjetoById(Integer id) {
//        return projetoRepository.findById(id);
//    }

    // Delete a Project by ID
    public void deleteProjetoById(Integer id) {
        projetoRepository.deleteById(id);
    }
}
