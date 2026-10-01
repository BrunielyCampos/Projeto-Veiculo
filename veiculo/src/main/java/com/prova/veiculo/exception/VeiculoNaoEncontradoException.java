package com.prova.veiculo.exception;

public class VeiculoNaoEncontradoException extends RuntimeException{
    public VeiculoNaoEncontradoException(Long id){
        super("Veiculo não Encontardo" + id);
    }

}
