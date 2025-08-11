package com.example.TarmaLimpia.Basurero.exceptions;

public class CuentaBasureroExistente extends RuntimeException {
    public CuentaBasureroExistente(String message) {
        super(message);
    }

    public CuentaBasureroExistente(){
        super("El usario ya tiene una cuenta de basurero Registrada");
    }
}
