package com.ceub.pi.effycityservice.service;

import com.ceub.pi.effycityservice.DTO.AreaTematicaDTO;
import com.ceub.pi.effycityservice.DTO.EstadoDTO;
import com.ceub.pi.effycityservice.DTO.MunicipioDTO;
import com.ceub.pi.effycityservice.DTO.NecessidadeGestorDTO;
import com.ceub.pi.effycityservice.DTO.UsuarioGestorDTO;
import com.ceub.pi.effycityservice.exception.NecessidadeGestorNotFoundException;
import com.ceub.pi.effycityservice.model.NecessidadeGestor;
import com.ceub.pi.effycityservice.repository.NecessidadeGestorRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NecessidadeGestorService {

    private final NecessidadeGestorRepository repository;
    private final ObjectMapper mapper;

    public NecessidadeGestorService(NecessidadeGestorRepository repository, ObjectMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    private Page<NecessidadeGestorDTO> convertNecessidadeGestorPageToDto(Page<NecessidadeGestor> necessidadeGestors){
        return necessidadeGestors.map(this::toDTO);
    }

    private NecessidadeGestor validateNecessidadeGestorExists(Long id){
        Optional<NecessidadeGestor> necessidadeGestor = repository.findById(id);
        if(necessidadeGestor.isPresent()){
            return necessidadeGestor.get();
        }throw new NecessidadeGestorNotFoundException();
    }

    private NecessidadeGestorDTO toDTO(NecessidadeGestor necessidadeGestor) {
        NecessidadeGestorDTO dto = new NecessidadeGestorDTO();
        dto.setId(necessidadeGestor.getId());
        dto.setNoNecessidade(necessidadeGestor.getNoNecessidade());
        dto.setDsNecessidade(necessidadeGestor.getDsNecessidade());
        dto.setNuCusto(necessidadeGestor.getNuCusto());
        dto.setDtCriacao(necessidadeGestor.getDtCriacao());

        // Convertendo apenas as informações essenciais dos relacionamentos
        if (necessidadeGestor.getUsuarioGestor() != null) {
            UsuarioGestorDTO usuarioGestorDTO = new UsuarioGestorDTO();
            usuarioGestorDTO.setId(necessidadeGestor.getUsuarioGestor().getId());
            usuarioGestorDTO.setUsuario(necessidadeGestor.getUsuarioGestor().getUsuario());
            usuarioGestorDTO.setEmail(necessidadeGestor.getUsuarioGestor().getEmail());
            usuarioGestorDTO.setOrgao(necessidadeGestor.getUsuarioGestor().getOrgao());
            usuarioGestorDTO.setCargo(necessidadeGestor.getUsuarioGestor().getCargo());
            usuarioGestorDTO.setTelefone(necessidadeGestor.getUsuarioGestor().getTelefone());
            dto.setUsuarioGestor(usuarioGestorDTO);
        }

        if (necessidadeGestor.getMunicipio() != null) {
            MunicipioDTO municipioDTO = new MunicipioDTO();
            municipioDTO.setId(necessidadeGestor.getMunicipio().getId());
            municipioDTO.setNoMunicipio(necessidadeGestor.getMunicipio().getNoMunicipio());
            dto.setMunicipio(municipioDTO);
        }

        if (necessidadeGestor.getEstado() != null) {
            EstadoDTO estadoDTO = new EstadoDTO();
            estadoDTO.setId(necessidadeGestor.getEstado().getId());
            estadoDTO.setNoEstado(necessidadeGestor.getEstado().getNoEstado());
            estadoDTO.setSgEstado(necessidadeGestor.getEstado().getSgEstado());
            dto.setEstado(estadoDTO);
        }

        if (necessidadeGestor.getAreaTematica() != null) {
            AreaTematicaDTO areaTematicaDTO = new AreaTematicaDTO();
            areaTematicaDTO.setId(necessidadeGestor.getAreaTematica().getId());
            areaTematicaDTO.setDsAreaTematica(necessidadeGestor.getAreaTematica().getDsAreaTematica());
            dto.setAreaTematica(areaTematicaDTO);
        }

        return dto;
    }

    public NecessidadeGestorDTO createNecessidadeGestor(NecessidadeGestor necessidade) {
        NecessidadeGestor necessidadeGestor = repository.save(necessidade);
        return toDTO(necessidadeGestor);

    }

    public NecessidadeGestorDTO getNecessidadeGestorById(Long id) {
        return toDTO(validateNecessidadeGestorExists(id));
    }

    public Page<NecessidadeGestorDTO> getAllNecessidadeGestorPage(Pageable pageable) {
        Page<NecessidadeGestor> all = repository.findAll(pageable);
        return convertNecessidadeGestorPageToDto(all);
    }

    public void deleteNecessidadeGestor(Long id) {
        validateNecessidadeGestorExists(id);
        repository.deleteById(id);
    }

    public NecessidadeGestorDTO updateNecessidadeGestor(Long id, NecessidadeGestor necessidadeForm) {
        NecessidadeGestor necessidadeGestor = validateNecessidadeGestorExists(id);
        necessidadeGestor.setNoNecessidade(necessidadeForm.getNoNecessidade());
        necessidadeGestor.setDsNecessidade(necessidadeForm.getDsNecessidade());
        necessidadeGestor.setUsuarioGestor(necessidadeForm.getUsuarioGestor());
        necessidadeGestor.setEstado(necessidadeForm.getEstado());
        necessidadeGestor.setAreaTematica(necessidadeForm.getAreaTematica());
        necessidadeGestor.setMunicipio(necessidadeForm.getMunicipio());
        necessidadeGestor.setNuCusto(necessidadeForm.getNuCusto());
        return toDTO(repository.save(necessidadeGestor));
    }
}
