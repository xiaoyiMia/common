package org.mars.common;

public interface MarsPasswordEncoder {

	public String encode(CharSequence originalPassword);
	
	public boolean matches(CharSequence originalPassword, String hashedPassword);
}
