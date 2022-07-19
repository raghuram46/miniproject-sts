package com.stg.entity;

public class ResponseError {
	private String errorMsg;
	private String requestedUri;

	public ResponseError() {
		super();
	}

	public ResponseError(String errorMsg, String requestedUri) {
		super();
		this.errorMsg = errorMsg;
		this.requestedUri = requestedUri;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getRequestedUri() {
		return requestedUri;
	}

	public void setRequestedUri(String requestedUri) {
		this.requestedUri = requestedUri;
	}

}
