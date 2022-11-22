package Proyect.MMS.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class DeleteSaleException extends ResponseStatusException {

    public DeleteSaleException (String message){
        super (HttpStatus.NOT_FOUND, message);
    }
}
