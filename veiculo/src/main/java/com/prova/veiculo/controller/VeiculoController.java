package com.prova.veiculo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prova.veiculo.DTO.VeiculoRequestDTO;
import com.prova.veiculo.DTO.VeiculoResponseDTO;
import com.prova.veiculo.Model.Veiculo;
import com.prova.veiculo.service.VeiculoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController 
@RequestMapping("/veiculos")
@RequiredArgsConstructor 
public class VeiculoController {
    private final VeiculoService service;

    @GetMapping
    public List<Veiculo> listar(){
        return service.listarVeiculos();
    }

    @GetMapping("/{id}")
    public VeiculoResponseDTO buscarPorId(@PathVariable  Long id){
        return service.buscarPorId(id);
    }

    @PostMapping
    public ResponseEntity<VeiculoResponseDTO> criarVeiculo(@Valid @RequestBody VeiculoRequestDTO dto){
        VeiculoResponseDTO veiculo = service.criar(dto);
        URI uri = URI.create("/veiculos/" + veiculo.getId());

        return ResponseEntity.created(uri).body(veiculo);
    }

    @PutMapping 
    public ResponseEntity<VeiculoResponseDTO> atualizarVeiculo(@PathVariable Long id, @Valid @RequestBody VeiculoResponseDTO dto){
        VeiculoResponseDTO veiculo = service.atualizar(id, dto);

        return ResponseEntity.ok(veiculo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable Long id){
        service.deletar(id);

        return ResponseEntity.noContent().build();
    }
    

    
}
