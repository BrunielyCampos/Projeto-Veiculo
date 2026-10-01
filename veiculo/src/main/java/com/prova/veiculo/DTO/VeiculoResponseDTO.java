package com.prova.veiculo.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter 
@AllArgsConstructor 
@NoArgsConstructor 
public class VeiculoResponseDTO {

    private Long id;

    private String placa;

    private String modelo;

    private Integer anoFabricacao;
   
    private String tipo;

    private String nomePropietário;

}
