package Proyect.MMS.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class SaleListException extends ResponseStatusException {

    public SaleListException (String message){
        super (HttpStatus.NOT_FOUND, message);
    }
}
