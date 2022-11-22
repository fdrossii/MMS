package Proyect.MMS.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class SaleDetListException extends ResponseStatusException {

    public SaleDetListException (String message){
        super (HttpStatus.NOT_FOUND, message);
    }
}
