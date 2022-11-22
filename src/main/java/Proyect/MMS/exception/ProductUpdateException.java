package Proyect.MMS.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ProductUpdateException extends ResponseStatusException {

    public ProductUpdateException (String message){
        super(HttpStatus.NOT_MODIFIED, message);
    }
}
