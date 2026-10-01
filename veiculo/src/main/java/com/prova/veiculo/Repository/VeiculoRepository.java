package com.prova.veiculo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.prova.veiculo.Model.Veiculo;


public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

}
