package com.example.TarmaLimpia.Persona.exceptions;

public class CuentaPersonaExistente extends RuntimeException {
    public CuentaPersonaExistente(String message) {
        super(message);
    }

    public CuentaPersonaExistente(){
        super("El usuario ya tiene una cuenta de persona registrada");
    }
}
