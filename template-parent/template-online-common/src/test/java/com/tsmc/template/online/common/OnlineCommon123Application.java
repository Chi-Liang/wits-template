package com.tsmc.template.online.common;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.tsmc.template.online.common","com.tsmc.template.common","com.tsmc.template.service"})
@EnableJpaRepositories("com.tsmc.template.common.repository")
@EntityScan("com.tsmc.template.common.entity")
public class OnlineCommon123Application {

}
