package com.tsmc.batch.web;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.tsmc.batch.web","com.tsmc.common"})
@EnableBatchProcessing
public class BatchWebApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(BatchWebApplication.class, args);
	}

}
