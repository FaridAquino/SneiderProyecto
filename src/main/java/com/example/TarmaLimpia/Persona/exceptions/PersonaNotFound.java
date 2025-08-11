package com.example.TarmaLimpia.Persona.exceptions;

public class PersonaNotFound extends RuntimeException {
    public PersonaNotFound(String message) {
        super(message);
    }
    public PersonaNotFound(){
        super("La persona con ese Id no existe");
    }
}
