package com.example.TarmaLimpia.CarroRecolector;

import com.example.TarmaLimpia.CarroRecolector.dto.CarroRecolectorRequest;
import com.example.TarmaLimpia.CarroRecolector.dto.CarroRecolectorResponse;
import com.example.TarmaLimpia.CarroRecolector.exceptions.CarroNotFound;
import com.example.TarmaLimpia.Usuario.Usuario;
import com.example.TarmaLimpia.Usuario.UsuarioRepository;
import com.example.TarmaLimpia.Usuario.exceptions.UsuarioNoTieneCuentaBasurero;
import com.example.TarmaLimpia.Usuario.exceptions.UsuarioNotFound;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CarroRecolectorService {
    private final UsuarioRepository usuarioRepository;
    private final CarroRecolectorRepository carroRecolectorRepository;
    private final ModelMapper modelMapper;

    public CarroRecolectorResponse crearCarroRecolector(Long userId, CarroRecolectorRequest carroRecolectorRequest){
        Usuario usuario=usuarioRepository.findById(userId).orElseThrow(UsuarioNotFound::new);

        if (!usuario.getIsBasurero()){
            throw new UsuarioNoTieneCuentaBasurero();
        }

        CarroRecolector carroRecolector=modelMapper.map(carroRecolectorRequest, CarroRecolector.class);
        carroRecolector.setBasureroConductor(usuario.getBasurero());

        CarroRecolector carroRecolectorSaved=carroRecolectorRepository.save(carroRecolector);

        CarroRecolectorResponse carroRecolectorResponse=modelMapper.map(carroRecolectorSaved, CarroRecolectorResponse.class);

        carroRecolectorResponse.setId(carroRecolectorSaved.getId());
        carroRecolectorResponse.setBasureroId(usuario.getBasurero().getId());

        return carroRecolectorResponse;
    }

    public CarroRecolectorResponse obtenerCarroRecolector(Long carroId){
        CarroRecolector carroRecolector=carroRecolectorRepository.findById(carroId).orElseThrow(CarroNotFound::new);

        CarroRecolectorResponse carroRecolectorResponse=modelMapper.map(carroRecolector,CarroRecolectorResponse.class);
        carroRecolectorResponse.setId(carroRecolector.getId());
        carroRecolectorResponse.setBasureroId(carroRecolector.getBasureroConductor().getId());

        return carroRecolectorResponse;
    }

    public List<CarroRecolectorResponse> obtenerMisCarrosRecolectores(Long userId){
        Usuario usuario=usuarioRepository.findById(userId).orElseThrow(UsuarioNotFound::new);

        if (!usuario.getIsBasurero()){
            throw new UsuarioNoTieneCuentaBasurero();
        }

        List<CarroRecolector> carroRecolectors=usuario.getBasurero().getCarros();

        List<CarroRecolectorResponse> carroRecolectorResponses=new ArrayList<>();

        for (CarroRecolector carroRecolector:carroRecolectors){
            CarroRecolectorResponse carroRecolectorResponse=modelMapper.map(carroRecolector,CarroRecolectorResponse.class);
            carroRecolectorResponse.setId(carroRecolector.getId());
            carroRecolectorResponse.setBasureroId(carroRecolector.getBasureroConductor().getId());

            carroRecolectorResponses.add(carroRecolectorResponse);
        }

        return carroRecolectorResponses;

    }

    public CarroRecolectorResponse actualizarCarroRecolector(Long carroId, CarroRecolectorRequest carroRecolectorRequest){
        CarroRecolector carroRecolector=carroRecolectorRepository.findById(carroId).orElseThrow(CarroNotFound::new);

        carroRecolector.setColor(carroRecolector.getColor());
        carroRecolector.setCapacidad(carroRecolector.getCapacidad());
        carroRecolector.setPlaca(carroRecolector.getPlaca());

        carroRecolectorRepository.save(carroRecolector);

        CarroRecolectorResponse carroRecolectorResponse=modelMapper.map(carroRecolector,CarroRecolectorResponse.class);

        carroRecolectorResponse.setId(carroId);
        carroRecolectorResponse.setBasureroId(carroRecolector.getBasureroConductor().getId());

        return carroRecolectorResponse;
    }

    public void eliminarCarroReecolector (Long carroId) {

        CarroRecolector carroRecolector=carroRecolectorRepository.findById(carroId).orElseThrow(CarroNotFound::new);

        carroRecolectorRepository.delete(carroRecolector);

    }
}
