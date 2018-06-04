package org.arimac.jax.messenger.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessage {

	private String ErrorMessage;
	private int errorCode;
	private String documantation;

	
	public ErrorMessage(String errorMessage, int errorCode, String documantation) {
		super();
		ErrorMessage = errorMessage;
		this.errorCode = errorCode;
		this.documantation = documantation;
	}
	
	
	public ErrorMessage() {
		super();
	}


	public String getErrorMessage() {
		return ErrorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		ErrorMessage = errorMessage;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getDocumantation() {
		return documantation;
	}
	public void setDocumantation(String documantation) {
		this.documantation = documantation;
	}
	
	
	
	
}
