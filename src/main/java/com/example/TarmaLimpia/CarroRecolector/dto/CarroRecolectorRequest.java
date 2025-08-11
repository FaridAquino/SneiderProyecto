package com.example.TarmaLimpia.CarroRecolector.dto;

import com.example.TarmaLimpia.Basurero.Basurero;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class CarroRecolectorRequest {
    private String placa;

    private String color;

    private String capacidad;
}
