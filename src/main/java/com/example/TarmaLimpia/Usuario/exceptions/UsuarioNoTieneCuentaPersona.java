package com.example.TarmaLimpia.Usuario.exceptions;

public class UsuarioNoTieneCuentaPersona extends RuntimeException {
    public UsuarioNoTieneCuentaPersona(String message) {
        super(message);
    }
    public UsuarioNoTieneCuentaPersona(){
        super("El usuario no tiene cuenta de persona");
    }
}
