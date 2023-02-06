package com.tsmc.common.util;

import java.util.Locale;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import com.tsmc.common.constant.MsgKey;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MessageSourceUtil {
	
	private final MessageSource messageSource;
	
	public String getMessage(MsgKey msgKey) {
		
		return messageSource.getMessage(msgKey.getKey(),null,Locale.ENGLISH);
		
	}
	
	public String getMessage(MsgKey msgKey,String... args) {
		
		return messageSource.getMessage(msgKey.getKey(),args,Locale.ENGLISH);
		
	}

}
