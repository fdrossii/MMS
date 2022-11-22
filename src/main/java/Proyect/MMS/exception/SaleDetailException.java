package Proyect.MMS.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class SaleDetailException extends ResponseStatusException {

    public SaleDetailException(String message){
        super (HttpStatus.NOT_FOUND, message);
    }
}
