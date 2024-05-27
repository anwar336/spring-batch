package com.kit.migrator.datamigrator.config;

import com.kit.migrator.datamigrator.dto.BeneficiaryDto;
import com.kit.migrator.datamigrator.enums.AfisStatusEnum;
import com.kit.migrator.datamigrator.model.Beneficiary;
import com.kit.migrator.datamigrator.repository.BeneficiaryRepository;
import com.kit.migrator.datamigrator.service.BeneficiaryProcessor;
import com.kit.migrator.datamigrator.service.BeneficiaryWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
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

@Configuration
@EnableBatchProcessing
public class BatchConfig {
    
    @Value(value = "${batch.migrator.reader.size:20}")
    private Integer fetchSize;

    @Autowired
    BeneficiaryRepository beneficiaryRepository;

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    @StepScope
    public ItemReader<Beneficiary> beneficiaryReader(@Value("#{jobParameters}") Map<String, Object> jobParameters) throws Exception {

        Date fromDate = (Date)jobParameters.get(BatchConstants.FROM_DATE);
        Date toDate = (Date)jobParameters.get(BatchConstants.TO_DATE);
        List<Object> parameters = new ArrayList<>();
        parameters.add(0);
        parameters.add(AfisStatusEnum.ENROLLED);
        RepositoryItemReader<Beneficiary> reader = new RepositoryItemReader<>();
        reader.setRepository(beneficiaryRepository);
        reader.setMethodName("findBeneficiaryByMisSyncStatusAndAfisStatus");
        reader.setArguments(parameters);
        reader.setPageSize(fetchSize);

        HashMap<String, Sort.Direction> sorts = new HashMap<>();
        sorts.put("id", Sort.Direction.ASC);
        reader.setSort(sorts);

        return reader;
    }

    @Bean
    public ItemProcessor<Beneficiary, BeneficiaryDto> beneficiaryProcessor() {
        return new BeneficiaryProcessor();
    }

    @Bean
    public ItemWriter<BeneficiaryDto> beneficiaryWriter()
            throws Exception {
        return new BeneficiaryWriter();
    }


    @Bean
    protected Step migrationStep1(ItemReader<Beneficiary> beneficiaryReader,
                                  ItemProcessor<Beneficiary, BeneficiaryDto> beneficiaryProcessor,
                                  ItemWriter<BeneficiaryDto> beneficiaryWriter) {
        return stepBuilderFactory.get("migrationStep1").<Beneficiary, BeneficiaryDto> chunk(20).reader(beneficiaryReader).processor(beneficiaryProcessor).writer(beneficiaryWriter).build();
    }

    @Bean(name = "migratorJob")
    public Job job(JobRepository jobRepository, @Qualifier("migrationStep1") Step step1) {
        return jobBuilderFactory.get("migratorJob").start(step1).build();
    }

}
