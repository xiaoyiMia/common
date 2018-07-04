package org.mars.common.values;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.google.auto.value.AutoValue;

import org.mars.common.MarsPasswordEncoder;
import org.mars.common.exception.InvalidField;
import org.mars.common.exception.message.InvalidDataMessage;

@AutoValue
public abstract class Password {

	private MarsPasswordEncoder passwordEncoder;
	
	@JsonCreator
	public static Password create(String password) {
		return new AutoValue_Password(password);
	}

	@JsonValue
	public abstract String password();

	private int minLength = 6;
	private int maxLength = 20;

	/**
	 * Validate password with default length requirement [6 - 20]
	 * @param fieldName the name of the field shows in error message, if password not valid
	 * @return
	 */
	public InvalidField validate(String fieldName) {
		int length = this.password().length();
		if (length < minLength) {
			return new InvalidField(fieldName, InvalidDataMessage.DATA_TOO_SHORT);
		} else if (length > maxLength) {
			return new InvalidField(fieldName, InvalidDataMessage.DATA_TOO_LONG);
		} else {
			return null;
		}
	}
	
	public InvalidField validate(String fieldName, int passwordMinLengh) {
		int length = this.password().length();
		if (length < passwordMinLengh) {
			return new InvalidField(fieldName, InvalidDataMessage.DATA_TOO_SHORT);
		} else if (length > maxLength) {
			return new InvalidField(fieldName, InvalidDataMessage.DATA_TOO_LONG);
		} else {
			return null;
		}
	}
	
	public InvalidField validate(String fieldName, int passwordMinLengh, int passwordMaxLengh) {
		int length = this.password().length();
		if (length < passwordMinLengh) {
			return new InvalidField(fieldName, InvalidDataMessage.DATA_TOO_SHORT);
		} else if (length > passwordMaxLengh) {
			return new InvalidField(fieldName, InvalidDataMessage.DATA_TOO_LONG);
		} else {
			return null;
		}
	}

	public String hashedPassword() {
		return passwordEncoder.encode(this.password());
	}

	public boolean matchPassword(String hashedPassword) {
		return passwordEncoder.matches(this.password(), hashedPassword);
	}

}
