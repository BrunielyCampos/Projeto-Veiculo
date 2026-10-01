package com.prova.veiculo.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Getter 
@Setter 
@AllArgsConstructor 
@NoArgsConstructor 
public class VeiculoRequestDTO {
    
    
    @NotBlank 
    private String placa;

    @NotBlank 
    private String modelo;

    @NonNull 
    private Integer anoFabricacao;

    @NotBlank 
    private String tipo;

    @NotBlank 
    private String nomePropietário;
    
}
