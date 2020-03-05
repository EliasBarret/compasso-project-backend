package br.com.elias.exception;

public class RestException extends RuntimeException{

	public RestException(String exception){
        super(exception);
    }
}
