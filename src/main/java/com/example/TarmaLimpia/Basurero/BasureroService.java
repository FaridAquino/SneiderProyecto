package com.example.TarmaLimpia.Basurero;

import com.example.TarmaLimpia.Basurero.dto.BasureroRequest;
import com.example.TarmaLimpia.Basurero.dto.BasureroResponse;
import com.example.TarmaLimpia.Basurero.exceptions.BasureroNotFound;
import com.example.TarmaLimpia.Basurero.exceptions.CuentaBasureroExistente;
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
public class BasureroService {
    private final BasureroRepository basureroRepository;
    private final UsuarioRepository usuarioRepository;
    private final ModelMapper modelMapper;

    public BasureroResponse crearBasurero(Long userId, BasureroRequest basureroRequest){
        Usuario usuario=usuarioRepository.findById(userId).orElseThrow(UsuarioNotFound::new);

        if (usuario.getIsBasurero()){
            throw new CuentaBasureroExistente();
        }

        Basurero basurero=modelMapper.map(basureroRequest, Basurero.class);
        Basurero basureroSaved=basureroRepository.save(basurero);

        usuario.setIsBasurero(true);
        usuario.setBasurero(basureroSaved);
        usuarioRepository.save(usuario);

        BasureroResponse basureroResponse=modelMapper.map(basureroRequest,BasureroResponse.class);

        basureroResponse.setUsuarioId(userId);
        basureroResponse.setId(basureroSaved.getId());

        return basureroResponse;
    }

    public BasureroResponse obtenerBasurero(Long basureroId){
        Basurero basurero=basureroRepository.findById(basureroId).orElseThrow(BasureroNotFound::new);

        BasureroResponse basureroResponse=modelMapper.map(basurero,BasureroResponse.class);

        basureroResponse.setUsuarioId(basurero.getUsuario().getId());

        return basureroResponse;
    }

    public List<BasureroResponse> obtenerTodosBasureros(){
        List<Basurero> basureros=basureroRepository.findAll();
        List<BasureroResponse> basureroResponses=new ArrayList<>();

        for (Basurero basurero: basureros){
            BasureroResponse basureroResponse=modelMapper.map(basurero,BasureroResponse.class);
            basureroResponse.setUsuarioId(basurero.getUsuario().getId());
            basureroResponses.add(basureroResponse);
        }

        return basureroResponses;
    }

    public void eliminarBasurero(Long userId){
        Usuario usuario=usuarioRepository.findById(userId).orElseThrow(UsuarioNotFound::new);

        if (!usuario.getIsBasurero()){
            throw new UsuarioNoTieneCuentaBasurero();
        }

        basureroRepository.delete(usuario.getBasurero());

        usuario.setIsBasurero(false);

        usuarioRepository.save(usuario);

    }
}
