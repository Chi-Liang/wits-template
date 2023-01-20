package com.tsmc.online.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.tsmc.online.web","com.tsmc.common"})
public class OnlineWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineWebApplication.class, args);
	}

}
