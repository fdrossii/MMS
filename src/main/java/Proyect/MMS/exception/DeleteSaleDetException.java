package Proyect.MMS.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class DeleteSaleDetException extends ResponseStatusException {

    public DeleteSaleDetException(String message){
        super (HttpStatus.NO_CONTENT, message);
    }
}
