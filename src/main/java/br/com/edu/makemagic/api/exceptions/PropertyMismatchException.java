package br.com.edu.makemagic.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class PropertyMismatchException extends RuntimeException {

    private String propertyMismatched;

    public PropertyMismatchException(String message, String propertyMismatched) {
        super(message);
        this.propertyMismatched = propertyMismatched;
    }

    public PropertyMismatchException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public String getMessage() {
        return String.format("%s -> property mismatched or incorrect: %s ", super.getMessage(), this.propertyMismatched);
    }
}
