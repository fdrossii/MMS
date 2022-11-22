package Proyect.MMS.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ProductNotExistException extends ResponseStatusException{

    public ProductNotExistException (String message){

        super (HttpStatus.NOT_FOUND, message);
    }
}
