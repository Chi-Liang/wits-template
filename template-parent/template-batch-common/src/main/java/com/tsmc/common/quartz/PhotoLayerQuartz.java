package com.tsmc.common.quartz;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.tsmc.common.job.PhotoLayerJobBean;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;

@Configuration
public class PhotoLayerQuartz {

	@Bean
	public JobDetail photoLayerQuartzSchedule() {
		return JobBuilder.newJob(PhotoLayerJobBean.class).storeDurably().build();
	}

	@Bean
	public Trigger trigger() {
		return TriggerBuilder.newTrigger().forJob(photoLayerQuartzSchedule())
				.withSchedule(CronScheduleBuilder.cronSchedule("* * 1 ? * *")).build();
	}

}
