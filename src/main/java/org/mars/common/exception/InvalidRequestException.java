package org.mars.common.exception;

import java.util.ArrayList;
import java.util.List;

import org.mars.common.exception.message.InvalidDataMessage;

public class InvalidRequestException extends MarsException {

	private static final long serialVersionUID = -7405772297404588896L;

	private List<InvalidField> invalidFields;

	public InvalidRequestException() {
		super(ExceptionLevel.Warning);
		this.invalidFields = new ArrayList<InvalidField>();
	}

	public InvalidRequestException(List<InvalidField> invalidFields) {
		this();
		this.invalidFields = invalidFields;
	}

	public List<InvalidField> getInvalidFields() {
		return invalidFields;
	}

	public void setInvalidFields(List<InvalidField> invalidFields) {
		this.invalidFields = invalidFields;
	}

	public void append(InvalidField invalidField) {
		if (invalidField != null) {
			this.invalidFields.add(invalidField);
		}
	}
	
	public void append(List<InvalidField> invalidFields) {
		if (!invalidFields.isEmpty()) {
			this.invalidFields.addAll(invalidFields);
		}
	}
	
	public void append(String feildName, InvalidDataMessage errorMessage) {
		this.append(new InvalidField(feildName, errorMessage));
	}

	public void append(boolean isInvalidPayload, String feildName, InvalidDataMessage errorMessage) {
		this.append(new InvalidField(isInvalidPayload, feildName, errorMessage));
	}

	/**
	 * Throw invalid exception if any
	 */
	public void throwException() {
		if (!this.invalidFields.isEmpty()) {
			throw this;
		}
	}
	
	public boolean isEmpty() {
		return this.invalidFields.isEmpty();
	}

	public static void throwException(List<InvalidField> invalidFields) {
		if (invalidFields != null && !invalidFields.isEmpty()) {
			throw new InvalidRequestException(invalidFields);
		}
	}

	public static void throwException(InvalidField invalidField) {
		if (invalidField != null) {
			List<InvalidField> invalidFields = new ArrayList<InvalidField>();
			invalidFields.add(invalidField);
			throw new InvalidRequestException(invalidFields);
		}
	}

}
