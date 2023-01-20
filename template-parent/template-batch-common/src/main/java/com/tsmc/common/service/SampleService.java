package com.tsmc.common.service;

import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.tsmc.common.vo.BaseVo;

import lombok.RequiredArgsConstructor;
import java.util.Date;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@Service
@RequiredArgsConstructor
public class SampleService {

	private final JobLauncher jobLauncher;

	private final Job sampleJob;

	public BaseVo startJob() {
		try {
			jobLauncher.run(sampleJob, new JobParametersBuilder()
					.addLong("currentTimeMillis", System.currentTimeMillis()).toJobParameters());
			return new BaseVo(true, "");
		} catch (Exception e) {
			return new BaseVo(false, e.getMessage());
		}
	}

}
