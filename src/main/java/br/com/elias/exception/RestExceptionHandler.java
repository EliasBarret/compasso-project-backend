package br.com.elias.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class RestExceptionHandler extends ResponseEntityExceptionHandler{
	
    @Override
    protected ResponseEntity handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
                                                          HttpStatus status, WebRequest request) {
        RestResponseException exceptionResponse = new RestResponseException(
                ex.getBindingResult().getAllErrors().get(0).getDefaultMessage(), HttpStatus.BAD_REQUEST.toString());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RestException.class)
    public final ResponseEntity<RestResponseException> handleBusinessException(RestException ex) {
        RestResponseException RestResponseException = new RestResponseException(ex.getMessage(),
                HttpStatus.BAD_REQUEST.toString());
        return new ResponseEntity<>(RestResponseException, HttpStatus.BAD_REQUEST);
    }
}
