package com.tsmc.common.config;

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

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import com.tsmc.common.entity.OnPhotoLayer;
import com.tsmc.common.entity.OnPhotoLayerTemp;
import com.tsmc.common.processor.PhotoLayerProcessor;
import com.tsmc.common.processor.SampleProcessor;
import com.tsmc.common.reader.PhotoLayerReader;
import com.tsmc.common.reader.SampleReader;
import com.tsmc.common.repository.OnPhotoLayerRepository;
import com.tsmc.common.repository.OnPhotoLayerTempRepository;
import com.tsmc.common.writer.PhotoLayerWriter;
import com.tsmc.common.writer.SampleWriter;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class SampleConfig {
	
	private final JobBuilderFactory jobBuilderFactory;

	private final StepBuilderFactory stepBuilderFactory;
	
	private final SampleReader sampleReader;
	
	private final SampleProcessor sampleProcessor;
	
	private final SampleWriter sampleWriter;
	
	@Bean
	public Job sampleJob() {
		return jobBuilderFactory.get("sampleJob").incrementer(new RunIdIncrementer()).start(photoLayerStep())
				.build();
	}
	
	private Step photoLayerStep() {
		return stepBuilderFactory.get("sampleJob Step").<Integer,Integer>chunk(100)
				.reader(sampleReader)
				.processor(sampleProcessor)
				.writer(sampleWriter)
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
