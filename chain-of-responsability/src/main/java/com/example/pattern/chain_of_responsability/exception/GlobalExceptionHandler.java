package com.example.pattern.chain_of_responsability.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProcessamentoPedidoException.class)
    public ResponseEntity<String> handleErroPedido(ProcessamentoPedidoException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

}
