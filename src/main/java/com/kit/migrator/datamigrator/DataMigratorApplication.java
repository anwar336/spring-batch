package com.kit.migrator.datamigrator;

import com.kit.migrator.datamigrator.Utility.Utils;
import com.kit.migrator.datamigrator.config.BatchConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
@EnableScheduling
@Slf4j
public class DataMigratorApplication {

	@Autowired
	private JobLauncher jobLauncher;

	@Autowired
	private Job job;

	public static void main(String[] args) {
		SpringApplication.run(DataMigratorApplication.class, args);
	}

	@Scheduled(fixedDelay = 1000 * 60 * 5)
	public void runJob() {
		launchJob();
	}

	public void launchJob() {
		try {
			Date currentDate = new Date();
			Date fromDate = Utils.addDays(currentDate, -30);
			Date toDate = Utils.addDays(currentDate, 1);
			JobParameters jobParameters = new JobParametersBuilder()
					.addDate(BatchConstants.FROM_DATE, fromDate)
					.addDate(BatchConstants.TO_DATE, toDate)
					.addString(BatchConstants.TRACE_ID, UUID.randomUUID().toString())
					.toJobParameters();

			jobLauncher.run(job, jobParameters);
		} catch (Exception e) {
			log.error("Failed to run", e);
		}
	}

}
