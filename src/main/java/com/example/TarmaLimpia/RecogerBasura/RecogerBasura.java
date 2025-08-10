package com.example.TarmaLimpia.RecogerBasura;

import com.example.TarmaLimpia.Basurero.Basurero;
import com.example.TarmaLimpia.Persona.Persona;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class RecogerBasura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relación con Persona
    @ManyToOne
    @JoinColumn(name = "persona_id", nullable = false)
    private Persona persona;

    // Relación con Basurero
    @ManyToOne
    @JoinColumn(name = "basurero_id", nullable = false)
    private Basurero basurero;

    // Campos extra
    @NotNull
    private Boolean confirmacionPersona;

    @NotNull
    private Boolean confirmacionRecolector;
}

