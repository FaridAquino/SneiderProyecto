package com.example.TarmaLimpia.Persona;

import com.example.TarmaLimpia.RecogerBasura.RecogerBasura;
import com.example.TarmaLimpia.Usuario.Usuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nombreCompleto;

    @NotNull
    private Long latitud;

    @NotNull
    private Long longitud;

    @NotNull
    private String foto;

    @OneToOne(mappedBy = "persona")
    private Usuario usuario;

    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RecogerBasura> recogeBasuraList;

}
