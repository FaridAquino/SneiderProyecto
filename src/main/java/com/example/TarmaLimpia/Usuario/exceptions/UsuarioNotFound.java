package com.example.TarmaLimpia.Usuario.exceptions;

public class UsuarioNotFound extends RuntimeException {
    public UsuarioNotFound(String message) {
        super(message);
    }

    public UsuarioNotFound(){
        super("El usuario con el ID especificado no existe");
    }
}
