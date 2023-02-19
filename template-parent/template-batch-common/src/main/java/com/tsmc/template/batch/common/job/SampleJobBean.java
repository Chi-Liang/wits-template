package com.tsmc.template.batch.common.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.tsmc.template.batch.common.service.SampleService;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SampleJobBean extends QuartzJobBean {
	
	private final SampleService sampleService;
	
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		
		sampleService.startJob();
		
	}

}
