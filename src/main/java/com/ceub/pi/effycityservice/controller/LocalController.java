package com.ceub.pi.effycityservice.controller;

import com.ceub.pi.effycityservice.DTO.EstadoDTO;
import com.ceub.pi.effycityservice.DTO.MunicipioDTO;
import com.ceub.pi.effycityservice.model.Estado;
import com.ceub.pi.effycityservice.model.Municipio;
import com.ceub.pi.effycityservice.service.LocalService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/local")
public class LocalController {

    private final LocalService localService;

    public LocalController(LocalService localService) {
        this.localService = localService;
    }

    @GetMapping("/municipios")
    public ResponseEntity<Page<MunicipioDTO>> getAllCountiesFromStatePageable(
            @PageableDefault(sort = "noMunicipio", direction = Sort.Direction.ASC, size = 20) Pageable pageable,
            @RequestParam Long estadoId
    ){
        Page<MunicipioDTO> counties = localService.getAllCountiesFromStatePageable(pageable, estadoId);
        return ResponseEntity.ok(counties);
    }
    @GetMapping("/municipios/list")
    public ResponseEntity<List<Municipio>> getAllCountiesFromStatePageable(
            @RequestParam Long estadoId
    ){
        List<Municipio> counties = localService.getAllMunicipiosFromState(estadoId);
        return ResponseEntity.ok(counties);
    }

    @GetMapping("/municipios/{id}")
    public ResponseEntity<Municipio> getMunicipioById(@PathVariable Long id){
        Municipio municipio = localService.getMunicipioById(id);
        return ResponseEntity.ok(municipio);
    }

    @GetMapping("/estados")
    public ResponseEntity<List<EstadoDTO>> getAllEStados(){
        List<EstadoDTO> getall = localService.getAllEstados();
        return ResponseEntity.ok(getall);
    }
}
