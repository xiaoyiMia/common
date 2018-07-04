package org.mars.common.values;

import org.mars.common.enums.SocialMedia;

import com.fasterxml.jackson.annotation.JsonValue;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class UserExternalId {

	public static UserExternalId create(String externalId, SocialMedia socialMedia) {
		return new AutoValue_UserExternalId(externalId, socialMedia);
	}

	public abstract String externalId();

	@JsonValue
	public abstract SocialMedia socialMedia();

}
