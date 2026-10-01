package com.prova.veiculo.service;
 
import java.util.List;

import org.springframework.stereotype.Service;

import com.prova.veiculo.DTO.VeiculoRequestDTO;
import com.prova.veiculo.DTO.VeiculoResponseDTO;
import com.prova.veiculo.Model.Veiculo;
import com.prova.veiculo.Repository.VeiculoRepository;
import com.prova.veiculo.exception.VeiculoNaoEncontradoException;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
@RequiredArgsConstructor
public class VeiculoService {

    private final VeiculoRepository repository;

    public VeiculoResponseDTO criar(VeiculoRequestDTO dto){
        Veiculo novo = repository.save(toEntity(dto));

        return toResponseDTO(novo);
    }

    public List<Veiculo> listarVeiculos(){
        return repository.findAll();
    }

    public VeiculoResponseDTO buscarPorId(Long id){
        Veiculo veiculo = repository.findById(id).orElseThrow(() -> new VeiculoNaoEncontradoException(id));

        return toResponseDTO(veiculo);
    }

    public VeiculoResponseDTO atualizar(Long id, VeiculoResponseDTO dto){
        Veiculo veiculo = repository.findById(id).orElseThrow(() -> new VeiculoNaoEncontradoException(id));

        veiculo.setId(dto.getId());
        veiculo.setAnoFabricacao(dto.getAnoFabricacao());
        veiculo.setModelo(dto.getModelo());
        veiculo.setPlaca(dto.getPlaca());
        veiculo.setTipo(dto.getTipo());
        veiculo.setNomePropietário(dto.getNomePropietário());

        Veiculo atualizado = repository.save(veiculo);

        return toResponseDTO(atualizado);
    }

    public void deletar(Long id){
        Veiculo veiculo = repository.findById(id).orElseThrow(() -> new VeiculoNaoEncontradoException(id));

        repository.delete(veiculo);
    }

    public VeiculoResponseDTO toResponseDTO(Veiculo veiculo){
        return new VeiculoResponseDTO(veiculo.getId(), veiculo.getPlaca(), veiculo.getModelo(), veiculo.getAnoFabricacao(), veiculo.getTipo(), veiculo. getNomePropietário());
    } 

    public Veiculo toEntity(@Valid VeiculoRequestDTO dto){
        return new Veiculo(null, dto.getPlaca(), dto.getModelo(), dto.getAnoFabricacao(), dto.getTipo(), dto.getNomePropietário());
    }

}
