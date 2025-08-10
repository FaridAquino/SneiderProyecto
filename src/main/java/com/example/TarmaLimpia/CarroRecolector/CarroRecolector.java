package com.example.TarmaLimpia.CarroRecolector;

import com.example.TarmaLimpia.Basurero.Basurero;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class CarroRecolector {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String placa;

    private String color;

    private String capacidad;

    @ManyToOne
    @JoinColumn(name="basurero_id")
    private Basurero basureroConductor;
}
