package org.mars.common.exception;

public class InternalException extends MarsException{

	private static final long serialVersionUID = 8773679148900358782L;

	public InternalException() {
		super(ExceptionLevel.Error);
	}

}
