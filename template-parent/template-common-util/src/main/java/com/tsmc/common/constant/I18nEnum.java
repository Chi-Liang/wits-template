package com.tsmc.common.constant;

public enum I18nEnum {
	
	demo_message_args("demo.message.args"),
	demo_message("demo.message"),
	demo_error_args("demo.error.args");
	
	private String key;

	private I18nEnum(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
}
