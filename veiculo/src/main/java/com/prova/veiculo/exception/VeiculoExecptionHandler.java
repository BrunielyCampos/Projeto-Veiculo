package com.prova.veiculo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice 
public class VeiculoExecptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(VeiculoNaoEncontradoException.class)
    public String hadle(VeiculoNaoEncontradoException ex){
        return ex.getMessage();
    }

    

}
