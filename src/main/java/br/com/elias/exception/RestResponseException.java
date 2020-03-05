package br.com.elias.exception;


public class RestResponseException {

    private String errorMessage;
    private String statusCode;
    
	public RestResponseException(String errorMessage, String statusCode) {
		 this.errorMessage=errorMessage;
	     this.statusCode=statusCode;  
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
}
