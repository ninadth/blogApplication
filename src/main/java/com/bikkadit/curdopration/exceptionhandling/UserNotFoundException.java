package com.bikkadit.curdopration.exceptionhandling;

public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	String resourcename;
	
	String fieldname;
	
	Long fieldvalue;

	public String getResourcename() {
		return resourcename;
	}

	public void setResourcename(String resourcename) {
		this.resourcename = resourcename;
	}

	public String getFieldname() {
		return fieldname;
	}

	public void setFieldname(String fieldname) {
		this.fieldname = fieldname;
	}

	public Long getFieldvalue() {
		return fieldvalue;
	}

	public void setFieldvalue(Long fieldvalue) {
		this.fieldvalue = fieldvalue;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public UserNotFoundException(String resourcename, String fieldname, Long fieldvalue) {
		super(String.format("%s user not found with %s :%s", resourcename,fieldname,fieldvalue));
		this.resourcename = resourcename;
		this.fieldname = fieldname;
		this.fieldvalue = fieldvalue;
	}

}
