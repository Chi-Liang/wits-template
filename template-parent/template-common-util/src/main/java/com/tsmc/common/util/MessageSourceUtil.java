package com.tsmc.common.util;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import com.tsmc.common.constant.I18nEnum;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MessageSourceUtil {
	
	private final MessageSource messageSource;
	
	public String getMessage(I18nEnum i18nEnum) {
		
		return messageSource.getMessage(i18nEnum.getKey(),null,Locale.ENGLISH);
		
	}
	
	public String getMessage(I18nEnum i18nEnum,String... args) {
		
		return messageSource.getMessage(i18nEnum.getKey(),args,Locale.ENGLISH);
		
	}

}
