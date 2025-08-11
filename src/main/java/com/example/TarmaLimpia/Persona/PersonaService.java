package com.example.TarmaLimpia.Persona;

import com.example.TarmaLimpia.Persona.dto.PersonaRequest;
import com.example.TarmaLimpia.Persona.dto.PersonaResponse;
import com.example.TarmaLimpia.Persona.exceptions.CuentaPersonaExistente;
import com.example.TarmaLimpia.Persona.exceptions.PersonaNotFound;
import com.example.TarmaLimpia.Usuario.Usuario;
import com.example.TarmaLimpia.Usuario.UsuarioRepository;
import com.example.TarmaLimpia.Usuario.exceptions.UsuarioNoTieneCuentaPersona;
import com.example.TarmaLimpia.Usuario.exceptions.UsuarioNotFound;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonaService {
    private final PersonaRepository personaRepository;
    private final UsuarioRepository usuarioRepository;
    private final ModelMapper modelMapper;

    public PersonaResponse crearPersona(Long userId, PersonaRequest personaRequest){
        Usuario usuario=usuarioRepository.findById(userId).orElseThrow(UsuarioNotFound::new);

        if (usuario.getIsPersona()){
            throw new CuentaPersonaExistente();
        }

        usuario.setIsPersona(true);

        Persona persona=modelMapper.map(personaRequest,Persona.class);

        Persona personasaved=personaRepository.save(persona);
        usuario.setPersona(personasaved);

        usuarioRepository.save(usuario);

        PersonaResponse personaResponse=modelMapper.map(personasaved,PersonaResponse.class);

        personaResponse.setIdUsuario(userId);
        personaResponse.setId(personasaved.getId());

        return personaResponse;

    }

    public PersonaResponse obtenerPersona(Long personaId){
        Persona persona=personaRepository.findById(personaId).orElseThrow(PersonaNotFound::new);

        PersonaResponse personaResponse=modelMapper.map(persona,PersonaResponse.class);

        personaResponse.setId(persona.getId());
        personaResponse.setIdUsuario(persona.getUsuario().getId());

        return personaResponse;
    }

    public List<PersonaResponse> obtenerTodasPersonas(Long userId){

        List<Persona> personas=personaRepository.findAll();

        List<PersonaResponse> personaResponses=new ArrayList<>();

        for (Persona persona:personas){
            PersonaResponse personaResponse= modelMapper.map(persona, PersonaResponse.class);

            personaResponse.setId(persona.getId());
            personaResponse.setIdUsuario(userId);

            personaResponses.add(personaResponse);
        }

        return personaResponses;
    }

    public PersonaResponse actualizarPersona(Long userId, PersonaRequest personaRequest){
        Usuario usuario=usuarioRepository.findById(userId).orElseThrow(UsuarioNotFound::new);

        if (!usuario.getIsPersona()){
            throw new UsuarioNoTieneCuentaPersona();
        }

        Persona persona=usuario.getPersona();

        persona.setFoto(personaRequest.getFoto());
        persona.setLatitud(personaRequest.getLatitud());
        persona.setLongitud(personaRequest.getLatitud());
        persona.setNombreCompleto(personaRequest.getNombreCompleto());

        Persona personasaved=personaRepository.save(persona);

        PersonaResponse personaResponse=modelMapper.map(personasaved, PersonaResponse.class);

        personaResponse.setIdUsuario(userId);
        personaResponse.setId(persona.getId());

        return personaResponse;
    }

    //Probar que al eliminar se elimine en ambas partes
    public void elminarPersona(Long userId){
        Usuario usuario=usuarioRepository.findById(userId).orElseThrow(UsuarioNotFound::new);

        if (!usuario.getIsPersona()){
            throw new UsuarioNoTieneCuentaPersona();
        }

        usuario.setIsPersona(false);
        usuarioRepository.save(usuario);

        Persona persona=usuario.getPersona();

        personaRepository.delete(persona);
    }



}
