package org.mars.common.exception;

import org.mars.common.exception.message.InvalidDataMessage;

/**
 * Record exception information for an invalid attribute when bad request is
 * received
 * 
 * @author xiaoyi
 *
 */
public class InvalidField {

	/**
	 * true if the invalid field is an request body attribute; false if the invalid
	 * field is a query parameter. Default to true
	 */
	private boolean isInvalidPayload;
	private String feildFullName;
	private InvalidDataMessage errorMessage;

	public InvalidField(String feildName, InvalidDataMessage errorMessage) {
		super();
		this.isInvalidPayload = true;
		this.feildFullName = feildName;
		this.errorMessage = errorMessage;
	}

	public InvalidField(boolean isInvalidPayload, String feildName, InvalidDataMessage errorMessage) {
		super();
		this.isInvalidPayload = isInvalidPayload;
		this.feildFullName = feildName;
		this.errorMessage = errorMessage;
	}

	public boolean isInvalidPayload() {
		return isInvalidPayload;
	}

	public void setInvalidPayload(boolean isInvalidPayload) {
		this.isInvalidPayload = isInvalidPayload;
	}

	public String getFeildFullName() {
		return feildFullName;
	}

	public void setFeildFullName(String feildFullName) {
		this.feildFullName = feildFullName;
	}

	public InvalidDataMessage getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(InvalidDataMessage errorMessage) {
		this.errorMessage = errorMessage;
	}

}
