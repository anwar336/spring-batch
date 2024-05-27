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
import org.springframework.batch.core.JobExecution;
import org.springframework.beans.factory.annotation.Qualifier;

@SpringBootApplication
@EnableScheduling
@Slf4j
public class DataMigratorApplication {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    @Qualifier("migratorJob")
    private Job migratorJob;

    public static void main(String[] args) {
        SpringApplication.run(DataMigratorApplication.class, args);
    }

    @Scheduled(fixedDelay = 1000 * 60 * 5)
    public void runJob() {
        launchJob(migratorJob);
    }

    public void launchJob(Job job) {
        try {
            JobParameters jobParameters = new JobParametersBuilder()
                    .addString(BatchConstants.TRACE_ID, UUID.randomUUID().toString())
                    .toJobParameters();

            JobExecution jobExecution = jobLauncher.run(job, jobParameters);
            if (!jobExecution.getStatus().isUnsuccessful()) {
                log.info("job finished");
            }
        } catch (Exception e) {
            log.error("Failed to run", e);
        }
    }

}
