package com.bridgelabz.fundoo.responses;

public class ResponseHelper {

	Response statusResponse = new Response();
	
	public static Response statusResponse( String message,int code) {
		
		Response statusResponse = new Response();

		statusResponse.setStatusMessage(message);
		statusResponse.setStatusCode(code);
		return statusResponse;
	}
}
