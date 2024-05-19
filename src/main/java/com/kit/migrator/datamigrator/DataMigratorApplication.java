package com.kit.migrator.datamigrator;

import com.kit.migrator.datamigrator.Utility.Utils;
import com.kit.migrator.datamigrator.config.BatchConstants;
import io.micrometer.core.instrument.util.StringUtils;
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
    @Qualifier("esJob")
    private Job esJob;
    
    private static String startDateStr = "";
    private static String endDateStr = "";
    
    public static void main(String[] args) {
        SpringApplication.run(DataMigratorApplication.class, args);
        if(args.length > 0){
            if(args.length == 2){
                startDateStr = args[0];
                endDateStr = args[1];
            }
            else if(args.length == 1){
                startDateStr = args[0];
            }
        }
    }

    @Scheduled(fixedDelay = 1000 * 60 * 60 * 24)
    public void runJob() {
        launchJob(esJob);
    }

    public void launchJob(Job job) {
        try {
            Date currentDate = new Date();
            Date fromDate = Utils.addDays(currentDate, -7);
            Date toDate = Utils.addDays(currentDate, 1);
            
            if(!StringUtils.isEmpty(startDateStr)){
                fromDate = Utils.getDateFromString(startDateStr, "yyyy-MM-dd");
            }
            if(!StringUtils.isEmpty(endDateStr)){
                toDate = Utils.getDateFromString(endDateStr, "yyyy-MM-dd");
            }
            
            
            JobParameters jobParameters = new JobParametersBuilder()
                    .addDate(BatchConstants.FROM_DATE, fromDate)
                    .addDate(BatchConstants.TO_DATE, toDate)
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
