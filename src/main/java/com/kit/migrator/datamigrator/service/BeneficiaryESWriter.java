package com.kit.migrator.datamigrator.service;

import co.elastic.clients.elasticsearch.core.IndexResponse;
import com.kit.migrator.datamigrator.config.ESConfig;
import com.kit.migrator.datamigrator.dto.BeneficiaryDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

@Slf4j
public class BeneficiaryESWriter implements ItemWriter<BeneficiaryDto> {

    @Override
    public void write(List<? extends BeneficiaryDto> beneficiaryList) throws Exception {
        beneficiaryList.forEach(b -> {
            log.info(" >>> " + b.getApplicationId());
            try {
                IndexResponse response = ESConfig.instance().index(i
                        -> i.index("INDEX_BENEFICIARY")
                                .id(b.getApplicationId())
                                .document(b)
                );
            } catch (Exception ex) {
                log.error("ES Error", ex);
            }
        });

    }
}
