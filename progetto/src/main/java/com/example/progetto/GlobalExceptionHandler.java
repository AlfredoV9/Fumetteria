package com.example.progetto;

import com.example.progetto.exception.BusinessLogicException;
import com.example.progetto.exception.NessunaNuovaUscitaException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        String message = ex.getMessage();
        if ("Utente non trovato".equals(message)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        } else if ("Password non corretta".equals(message)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(message);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Errore: " + message);
    }

    @ExceptionHandler(NessunaNuovaUscitaException.class)
    public ResponseEntity<String> handleNessunaNuovaUscita(NessunaNuovaUscitaException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(BusinessLogicException.class)
    public ResponseEntity<String> handleBusinessLogicException(BusinessLogicException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
    }
}

