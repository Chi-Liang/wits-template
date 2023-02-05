package com.tsmc.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import lombok.Data;

@PropertySource("classpath:config.properties")
@Configuration
@Data
public class ConfigValue {
	
	@Value("${batch.size}")
	private String batchSize;
	
	@Value("${i18n.path}")
	private String[] i18nPath;
	
}
