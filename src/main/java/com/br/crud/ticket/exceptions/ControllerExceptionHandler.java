package com.br.crud.ticket.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<StandarError> parametroVazio(HttpServletRequest request){
        StandarError error = new StandarError();
        error.setTimestamp(Instant.now().toEpochMilli());
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setError("Parâmetro inválido");
        error.setMessage("O parâmetro id é obrigatório");
        error.setPath(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
