package com.bikkadit.curdopration.exceptionhandling;

public class ApiResponse {

    private String message;

	private String errorcode;


	public ApiResponse(String message, String errorcode){
	    super();  
		this.message = message;
		this.errorcode = errorcode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCode() {
		return errorcode;
	}

	public void setCode(String errorcode) {
		this.errorcode = errorcode;
	}

	@Override
	public String toString() {
		return "ApiResponce [message=" + message + ", errorcode=" + errorcode + "]";
	}
	
}
