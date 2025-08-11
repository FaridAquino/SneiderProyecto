package com.example.TarmaLimpia.Persona.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PersonaRequest {
    @NotNull
    private String nombreCompleto;

    @NotNull
    private Long latitud;

    @NotNull
    private Long longitud;

    @NotNull
    private String foto;
}
