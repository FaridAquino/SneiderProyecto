package com.example.TarmaLimpia.CarroRecolector.exceptions;

public class NoExistenCarros extends RuntimeException {
    public NoExistenCarros(String message) {
        super(message);
    }

    public NoExistenCarros(){
        super("No existe ningún carro registrado");
    }
}
