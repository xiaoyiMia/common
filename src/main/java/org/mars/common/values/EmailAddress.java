package org.mars.common.values;

import org.mars.common.exception.InvalidField;
import org.mars.common.exception.message.InvalidDataMessage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class EmailAddress {

	@JsonCreator
	public static EmailAddress create(String email) {
		return new AutoValue_EmailAddress(email);
	}

	@JsonValue
	public abstract String email();

	/**
	 * Validate email address format
	 * 
	 * @return
	 */
	public InvalidField validate(String fieldName) {
		String checkingRegex = "^[a-z0-9!#$%&'*+/=?^_`{|}~-]+"
		    + "(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+"
		    + "[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$";
		if (!this.email().matches(checkingRegex)) {
			return new InvalidField(fieldName, InvalidDataMessage.INVALID_EMAIL);
		} else {
			return null;
		}
	}

}
