package com.kit.migrator.datamigrator.config;

import com.kit.migrator.datamigrator.dto.BeneficiaryDto;
import com.kit.migrator.datamigrator.model.Beneficiary;
import com.kit.migrator.datamigrator.repository.BeneficiaryRepository;
import com.kit.migrator.datamigrator.service.BeneficiaryESProcessor;
import com.kit.migrator.datamigrator.service.BeneficiaryESWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Sort;

import java.util.*;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;

@Configuration
@EnableBatchProcessing
public class BatchConfigES {

    @Autowired
    BeneficiaryRepository beneficiaryRepository;

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    @StepScope
    public ItemReader<Beneficiary> beneficiaryESReader(@Value("#{jobParameters}") Map<String, Object> jobParameters) throws Exception {

        Date fromDate = (Date)jobParameters.get(BatchConstants.FROM_DATE);
        Date toDate = (Date)jobParameters.get(BatchConstants.TO_DATE);
        List<Date> parameters = new ArrayList<>();
        parameters.add(fromDate);
        parameters.add(toDate);
        RepositoryItemReader<Beneficiary> reader = new RepositoryItemReader<>();
        reader.setRepository(beneficiaryRepository);
        reader.setMethodName("findBeneficiaryByCreatedBetween");
        reader.setArguments(parameters);
        reader.setPageSize(20);

        HashMap<String, Sort.Direction> sorts = new HashMap<>();
        sorts.put("id", Sort.Direction.ASC);
        reader.setSort(sorts);

        return reader;
    }

    @Bean
    public ItemProcessor<Beneficiary, BeneficiaryDto> beneficiaryESProcessor() {
        return new BeneficiaryESProcessor();
    }

    @Bean
    public ItemWriter<BeneficiaryDto> beneficiaryESWriter()
            throws Exception {
        return new BeneficiaryESWriter();
    }


    @Bean
    protected Step esStep1(ItemReader<Beneficiary> beneficiaryESReader,
                                  ItemProcessor<Beneficiary, BeneficiaryDto> beneficiaryESProcessor,
                                  ItemWriter<BeneficiaryDto> beneficiaryESWriter) {
        return stepBuilderFactory.get("esStep1").<Beneficiary, BeneficiaryDto> chunk(20).reader(beneficiaryESReader).processor(beneficiaryESProcessor).writer(beneficiaryESWriter).build();
    }

    @Bean(name = "esJob")
    public Job job(JobRepository jobRepository, @Qualifier("esStep1") Step step1) {
        return jobBuilderFactory.get("esJob").start(step1).build();
    }

}
