package com.kit.migrator.datamigrator.service;

import com.kit.migrator.datamigrator.dto.BeneficiaryDto;
import com.kit.migrator.datamigrator.model.Beneficiary;
import org.springframework.batch.item.ItemProcessor;

public class BeneficiaryProcessor implements ItemProcessor<Beneficiary, BeneficiaryDto> {
    @Override
    public BeneficiaryDto process(Beneficiary beneficiary) throws Exception {
        return new BeneficiaryDto(beneficiary);
    }
}
