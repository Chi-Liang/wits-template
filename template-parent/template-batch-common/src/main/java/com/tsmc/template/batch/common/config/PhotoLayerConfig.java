package com.tsmc.template.batch.common.config;

import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.tsmc.template.batch.common.processor.PhotoLayerProcessor;
import com.tsmc.template.batch.common.reader.PhotoLayerReader;
import com.tsmc.template.batch.common.writer.PhotoLayerWriter;
import com.tsmc.template.common.entity.OnPhotoLayer;
import com.tsmc.template.common.entity.OnPhotoLayerTemp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class PhotoLayerConfig {
	
	private final JobBuilderFactory jobBuilderFactory;

	private final StepBuilderFactory stepBuilderFactory;
	
	private final PhotoLayerReader photoLayerReader;
	
	private final PhotoLayerProcessor photoLayerProcessor;
	
	private final PhotoLayerWriter photoLayerWriter;
	
	@Bean
	public Job photoLayerJob() {
		return jobBuilderFactory.get("photoLayerJob").incrementer(new RunIdIncrementer()).start(photoLayerStep())
				.build();
	}
	
	private Step photoLayerStep() {
		return stepBuilderFactory.get("photoLayerJob Step").<List<OnPhotoLayer>,List<OnPhotoLayerTemp>>chunk(100)
				.reader(photoLayerReader)
				.processor(photoLayerProcessor)
				.writer(photoLayerWriter)
//				.faultTolerant()
//				.skip(Throwable.class)
//				.skipLimit(100)
//				.skipPolicy(new AlwaysSkipItemSkipPolicy())
//				.retryLimit(1)
//				.retry(Throwable.class)
//				.listener(skipListenerImpl)
				.build();
	}
	
}
