package com.kit.migrator.datamigrator.service;

import com.kit.migrator.datamigrator.dto.BeneficiaryDto;
import com.kit.migrator.datamigrator.repository.BeneficiaryDao;
import com.kit.migrator.datamigrator.repository.BeneficiaryESRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class BeneficiaryESWriter implements ItemWriter<BeneficiaryDto> {

    @Autowired
    private BeneficiaryESRepository repo;
    
    
    @Autowired
    private BeneficiaryDao dao;

    @Override
    public void write(List<? extends BeneficiaryDto> beneficiaryList) throws Exception {
        beneficiaryList.forEach(b -> {
            log.info(" >>> " + b.getApplicationId());
            repo.save(b);
            dao.updateBeneficiaryEsSyncStatus(b.getApplicationId(), 1);
            log.info(" ## ES Migration done for {} ", b.getApplicationId());
        });

    }
}
