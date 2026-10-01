package com.prova.veiculo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Entity 
@Table(name = "veiculos")
@Getter 
@Setter 
@AllArgsConstructor 
@NoArgsConstructor 
public class Veiculo {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   
    private String placa;
 
    private String modelo;
    private Integer anoFabricacao;
    private String tipo;
    private String nomePropietário;

}
