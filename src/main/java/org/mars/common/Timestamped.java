package org.mars.common;

import java.time.ZonedDateTime;

public interface Timestamped {

	public ZonedDateTime getCreatedAt();

	public void setCreatedAt(ZonedDateTime createdAt);

	public ZonedDateTime getUpdatedAt();

	public void setUpdatedAt(ZonedDateTime updatedAt);
}
