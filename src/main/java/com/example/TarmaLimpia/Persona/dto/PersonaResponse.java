package com.example.TarmaLimpia.Persona.dto;

import com.example.TarmaLimpia.Usuario.Usuario;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PersonaResponse {
    private Long id;

    private String nombreCompleto;

    private Long latitud;

    private Long longitud;

    private String foto;

    private Long idUsuario;

}
