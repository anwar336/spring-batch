package com.kit.migrator.datamigrator.service;

import com.kit.migrator.datamigrator.dto.BeneficiaryDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

@Slf4j
public class BeneficiaryWriter implements ItemWriter<BeneficiaryDto> {
    @Override
    public void write(List<? extends BeneficiaryDto> beneficiaryList) throws Exception {
        beneficiaryList.forEach(b->{
            log.info(" >>> " + b.getApplicationId());
        });
    }
}
