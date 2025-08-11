package com.example.TarmaLimpia.Basurero.exceptions;

public class BasureroNotFound extends RuntimeException {
    public BasureroNotFound(String message) {
        super(message);
    }
    public BasureroNotFound(){
        super("El basurero con el ID especificado no existe");
    }
}
