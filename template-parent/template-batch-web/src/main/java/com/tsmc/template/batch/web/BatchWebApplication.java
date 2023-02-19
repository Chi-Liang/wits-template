package com.tsmc.template.batch.web;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.tsmc.template.batch.web","com.tsmc.template.batch.common","com.tsmc.template.common"})
@EnableJpaRepositories("com.tsmc.template.common.repository")
@EntityScan("com.tsmc.template.common.entity")
@EnableBatchProcessing
public class BatchWebApplication extends SpringBootServletInitializer {
	
	public static void main(String[] args) {
		SpringApplication.run(BatchWebApplication.class, args);
	}

}
