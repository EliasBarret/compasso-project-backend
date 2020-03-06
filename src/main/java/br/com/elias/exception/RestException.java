package br.com.elias.exception;

public class RestException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RestException(String exception){
        super(exception);
    }
}
