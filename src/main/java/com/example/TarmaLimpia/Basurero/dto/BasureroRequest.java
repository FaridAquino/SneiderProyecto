package com.example.TarmaLimpia.Basurero.dto;

import lombok.Data;

@Data
public class BasureroRequest {

    private String foto;

    private Double longitud;

    private Double latitud;

    private String nombreCompleto;

    private Long usuarioId;

}
