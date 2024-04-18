package com.kit.migrator.datamigrator.service;

import com.kit.migrator.datamigrator.dto.BeneficiaryDto;
import com.kit.migrator.datamigrator.gateway.MisGateway;
import com.kit.migrator.datamigrator.gateway.model.MisRequestModel;
import com.kit.migrator.datamigrator.gateway.model.MisResponseModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j
public class BeneficiaryWriter implements ItemWriter<BeneficiaryDto> {

    @Autowired
    MisGateway gateway;

    @Override
    public void write(List<? extends BeneficiaryDto> beneficiaryList) throws Exception {
        beneficiaryList.forEach(b->{
            log.info(" >>> " + b.getApplicationId());
            MisRequestModel requestModel = new MisRequestModel(b);
            MisResponseModel responseModel = gateway.syncData(requestModel);
            if(responseModel != null){
                if(!responseModel.getError()){
                    log.info("Beneficiary synced with id {} ", b.getApplicationId());
                }
                else{
                    log.error("Beneficiary synced error. Reason {} ", responseModel.getErrorMessage());
                }
            }
        });
    }
}
