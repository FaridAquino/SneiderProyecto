package com.example.TarmaLimpia;

import com.example.TarmaLimpia.Basurero.exceptions.BasureroNotFound;
import com.example.TarmaLimpia.Basurero.exceptions.CuentaBasureroExistente;
import com.example.TarmaLimpia.CarroRecolector.exceptions.NoExistenCarros;
import com.example.TarmaLimpia.Persona.exceptions.CuentaPersonaExistente;
import com.example.TarmaLimpia.Persona.exceptions.PersonaNotFound;
import com.example.TarmaLimpia.Usuario.exceptions.UsuarioNoTieneCuentaBasurero;
import com.example.TarmaLimpia.Usuario.exceptions.UsuarioNoTieneCuentaPersona;
import com.example.TarmaLimpia.Usuario.exceptions.UsuarioNotFound;
import org.modelmapper.spi.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ErrorMessage> handleUsuarioNotFound(UsuarioNotFound ex){
        ErrorMessage errorMessage=new ErrorMessage(ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorMessage> handleCuentaPersonaExistente(CuentaPersonaExistente ex){
        ErrorMessage errorMessage=new ErrorMessage(ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorMessage> handleUsuarioNoTieneCuentaPersona(UsuarioNoTieneCuentaPersona ex){
        ErrorMessage errorMessage=new ErrorMessage(ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorMessage> hanldeUsuarioNoTieneCuentaBasurero(UsuarioNoTieneCuentaBasurero ex){
        ErrorMessage errorMessage=new ErrorMessage(ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorMessage> handleNoExistenCarros(NoExistenCarros ex){
        ErrorMessage errorMessage=new ErrorMessage(ex.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorMessage> handleCuentaBasureroExistente(CuentaBasureroExistente ex){
        ErrorMessage errorMessage=new ErrorMessage(ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorMessage> handleBasureroNotFound(BasureroNotFound ex){
        ErrorMessage errorMessage=new ErrorMessage(ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorMessage> handlePersonaNotFound(PersonaNotFound ex){
        ErrorMessage errorMessage=new ErrorMessage(ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }
}
