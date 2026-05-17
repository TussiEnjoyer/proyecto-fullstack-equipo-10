package com.example.demo.exception;

public class VehiculoNoEncontradoException extends RuntimeException {
    private static final long serialVersionUID = 1L; // buena práctica en excepciones personalizadas

    public VehiculoNoEncontradoException(String mensaje) {
        super(mensaje);
    }
}
