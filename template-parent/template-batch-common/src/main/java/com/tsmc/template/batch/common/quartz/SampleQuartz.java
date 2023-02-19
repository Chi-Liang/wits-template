package com.tsmc.template.batch.common.quartz;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.tsmc.template.batch.common.job.SampleJobBean;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;

@Configuration
public class SampleQuartz {

	@Bean
	public JobDetail sampleQuartzSchedule() {
		return JobBuilder.newJob(SampleJobBean.class).storeDurably().build();
	}

	@Bean
	public Trigger triggerSample() {
		return TriggerBuilder.newTrigger().forJob(sampleQuartzSchedule())
				.withSchedule(CronScheduleBuilder.cronSchedule("* * 1 ? * *")).build();
	}

}
