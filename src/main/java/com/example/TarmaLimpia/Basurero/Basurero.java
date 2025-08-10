package com.example.TarmaLimpia.Basurero;

import com.example.TarmaLimpia.CarroRecolector.CarroRecolector;
import com.example.TarmaLimpia.RecogerBasura.RecogerBasura;
import com.example.TarmaLimpia.Usuario.Usuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Basurero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String foto;

    @NotNull
    private Double longitud;

    @NotNull
    private Double latitud;

    private String nombreCompleto;

    @OneToOne(mappedBy = "basurero")
    private Usuario usuario;

    @OneToMany(mappedBy = "basureroConductor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<CarroRecolector> carros;

    @OneToMany(mappedBy = "basurero", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RecogerBasura> recogeBasuraList;


}
