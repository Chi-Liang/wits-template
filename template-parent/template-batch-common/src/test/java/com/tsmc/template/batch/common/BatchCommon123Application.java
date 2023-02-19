package com.tsmc.template.batch.common;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.tsmc.template"})
@EnableJpaRepositories("com.tsmc.template.common.repository")
@EntityScan("com.tsmc.template.common.entity")
@EnableBatchProcessing
public class BatchCommon123Application {

}
