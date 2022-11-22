package Proyect.MMS.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class SaleNotExistException extends ResponseStatusException {

    public SaleNotExistException(String message){
        super (HttpStatus.NOT_FOUND, message);
    }
}
