package org.mars.common.exception.message;

public enum InvalidDataMessage implements ErrorMessageContainer {
	DATA_CANNOT_BLANK("01", "Data cannot be blank"),
	INVALID_EMAIL("02", "Invalid email address"),
	DATA_TOO_LONG("03", "Data length too long"),
	DATA_TOO_SHORT("04", "Data length too short");

	private String detailCode;
	private String description;

	InvalidDataMessage(String detailCode, String description) {
		this.detailCode = detailCode;
		this.description = description;
	}

	@Override
	public String getDetailCode() {
		return CategoryCode.Common.categoryCode() + detailCode;
	}

	@Override
	public String getInternalDetails() {
		return description;
	}

	@Override
	public String getExposureDetails() {
		return this.name();
	}

}
