package com.tsmc.common.util;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MessageSourceUtil {
	
	private final MessageSource messageSource;
	
	public String getMessage(String key) {
		
		return messageSource.getMessage(key,null,Locale.ENGLISH);
		
	}
	
	public String getMessage(String key,String... args) {
		
		return messageSource.getMessage(key,args,Locale.ENGLISH);
		
	}

}
