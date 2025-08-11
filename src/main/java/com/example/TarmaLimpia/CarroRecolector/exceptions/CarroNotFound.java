package com.example.TarmaLimpia.CarroRecolector.exceptions;

public class CarroNotFound extends RuntimeException {
    public CarroNotFound(String message) {
        super(message);
    }
    public CarroNotFound(){
        super("No existe un carro Recolector con el id especificado");
    }
}
