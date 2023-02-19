package com.tsmc.template.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class MessageSourceConfig {
	
	private final ConfigValue configValue;
	
	@Bean(name = "messageSource")
	public ResourceBundleMessageSource getMessageSource() {
		
		ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();
		resourceBundleMessageSource.setDefaultEncoding("UTF-8");
		resourceBundleMessageSource.setBasenames(configValue.getI18nPath());
		return resourceBundleMessageSource;
	}
	
}
