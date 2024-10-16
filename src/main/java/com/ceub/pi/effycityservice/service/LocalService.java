package com.ceub.pi.effycityservice.service;

import com.ceub.pi.effycityservice.DTO.MunicipioDTO;
import com.ceub.pi.effycityservice.exception.MunicipioNotFoundException;
import com.ceub.pi.effycityservice.model.Municipio;
import com.ceub.pi.effycityservice.repository.EstadoRepository;
import com.ceub.pi.effycityservice.repository.MunicipioRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LocalService {

    private EstadoRepository estadoRepository;
    private MunicipioRepository municipioRepository;

    public LocalService(EstadoRepository estadoRepository, MunicipioRepository municipioRepository) {
        this.estadoRepository = estadoRepository;
        this.municipioRepository = municipioRepository;
    }

    private Municipio validateMunicipioExists(Long municipioId) {
        Optional<Municipio> municipio = municipioRepository.findById(municipioId);
        if (municipio.isPresent()) {
            return municipio.get();
        }throw new MunicipioNotFoundException();
    }

    private static Page<MunicipioDTO> convertModelPageToDtoPage(Page<Municipio> municipios){
        return municipios.map(MunicipioDTO::new);
    }

    public Page<MunicipioDTO> getAllCountiesFromStatePageable (Pageable pageable, Long estadoId){
        Page<Municipio> all = municipioRepository.findAllByEstadoId(pageable, estadoId);
        return convertModelPageToDtoPage(all);
    }

    public Municipio getMunicipioById(Long id){
        return validateMunicipioExists(id);
    }
}
