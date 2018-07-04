package org.mars.common.exception.message;

public enum CommonErrorMessage implements ErrorMessageContainer{
	UNKNOWN_EXCEPTION("01","Unknown exception") {
		public String getExposureDetails() {
			return "Internal exception";
		}
	};

	private String detailCode;
	private String description;
	
	CommonErrorMessage(String detailCode, String description) {
		this.detailCode = detailCode;
		this.description = description;
	}
	
	@Override
	public String getDetailCode() {
		return CategoryCode.Common.categoryCode() + this.detailCode;
	}

	@Override
	public String getExposureDetails() {
		return this.name();
	}

	@Override
	public String getInternalDetails() {
		return this.description;
	}

}
