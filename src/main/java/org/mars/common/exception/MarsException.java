package org.mars.common.exception;

public abstract class MarsException extends RuntimeException {

	private static final long serialVersionUID = -6461781799632133716L;

	private ExceptionLevel level;

	public MarsException(ExceptionLevel level) {
		super();
		this.level = level;
	}

	public ExceptionLevel getLevel() {
		return level;
	}

	public void setLevel(ExceptionLevel level) {
		this.level = level;
	}

	public static void throwException(InvalidRequestException exception) {
		if (exception != null && exception.getInvalidFields() != null && !exception.getInvalidFields().isEmpty()) {
			throw exception;
		}
	}

}
