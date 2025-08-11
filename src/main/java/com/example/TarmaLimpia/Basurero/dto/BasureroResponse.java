package com.example.TarmaLimpia.Basurero.dto;

import com.example.TarmaLimpia.CarroRecolector.CarroRecolector;
import com.example.TarmaLimpia.RecogerBasura.RecogerBasura;
import com.example.TarmaLimpia.Usuario.Usuario;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class BasureroResponse {
    private Long id;

    private String foto;

    private Double longitud;

    private Double latitud;

    private String nombreCompleto;

    private Long usuarioId;

}
