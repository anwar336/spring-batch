package com.kit.migrator.datamigrator.service;

import com.kit.migrator.datamigrator.dto.BeneficiaryDto;
import com.kit.migrator.datamigrator.model.Beneficiary;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;

@Slf4j
public class BeneficiaryESProcessor implements ItemProcessor<Beneficiary, BeneficiaryDto> {

    @Override
    public BeneficiaryDto process(Beneficiary beneficiary) throws Exception {
        BeneficiaryDto dto = new BeneficiaryDto(beneficiary);
        return dto;
    }
}
