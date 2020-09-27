package br.com.edu.makemagic.api.configuration;

import br.com.edu.makemagic.api.exceptions.ObjectNotFoundException;
import br.com.edu.makemagic.api.exceptions.PropertyMismatchException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.io.Serializable;

@RestControllerAdvice
public class ExceptionHandling extends ResponseEntityExceptionHandler {

    public static final String ERROR_UPDATE_MESSAGE = "An error has occurred. It's not possible to update the Persona.";
    public static final String ERROR_CREATE_MESSAGE = "An error has occurred. It's not possible to save the Persona.";
    public static final String ERROR_HOUSE_NOT_EQUALS = "An error has occurred. The house field of Persona is not equals or equivalent to any result from external API.";
    public static final String ERROR_GENERAL = "An error has occurred.";
    public static final String ERROR_NOT_FOUND = "Object Not Found!";

    @ExceptionHandler({IllegalArgumentException.class, ConstraintViolationException.class})
    public ResponseEntity<?> badRequestError() {
        return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler({EmptyResultDataAccessException.class, ObjectNotFoundException.class})
    public ResponseEntity<?> notFoundError() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler({PropertyMismatchException.class})
    public ResponseEntity<?> propertyMismatchError() {
        return ResponseEntity.badRequest().body(new APIError(ERROR_HOUSE_NOT_EQUALS));
    }

    /**
     * Simple Class to represent a custom error on the Response.
     * This can return a custom json as response
     */
    private static final class APIError implements Serializable {
        private String error;

        public APIError(String error) {
            this.error = error;
        }

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }
    }

}
