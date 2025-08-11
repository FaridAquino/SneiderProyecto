package com.example.TarmaLimpia.Usuario.exceptions;

public class UsuarioNoTieneCuentaBasurero extends RuntimeException {
    public UsuarioNoTieneCuentaBasurero(String message) {
        super(message);
    }

    public UsuarioNoTieneCuentaBasurero(){
        super("El usuario no tiene una cuenta de basurero");
    }
}
