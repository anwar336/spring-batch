package com.kit.migrator.datamigrator.service;

import com.kit.migrator.datamigrator.dto.BeneficiaryDto;
import com.kit.migrator.datamigrator.gateway.MisGateway;
import com.kit.migrator.datamigrator.gateway.model.MisRequestModel;
import com.kit.migrator.datamigrator.gateway.model.MisResponseModel;
import com.kit.migrator.datamigrator.repository.BeneficiaryDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j
public class BeneficiaryWriter implements ItemWriter<BeneficiaryDto> {

    @Autowired
    MisGateway gateway;
    
    @Autowired
    BeneficiaryDao dao;
    

    @Override
    public void write(List<? extends BeneficiaryDto> beneficiaryList) throws Exception {
        beneficiaryList.forEach(b->{
            log.info(" >>> " + b.getApplicationId());
            
            MisRequestModel requestModel = new MisRequestModel(b);
            MisResponseModel responseModel = null;
            if(requestModel != null){
                log.info("[{}]", requestModel.toString());
                responseModel = gateway.syncData(requestModel);
            }
            if(responseModel != null){
                if(!responseModel.getError()){
                    if(responseModel.getReturnId() > 100){
                        log.info("Beneficiary synced with id {} ", b.getApplicationId());
                        dao.updateBeneficiarySyncStatus(b.getApplicationId(), 1);
                    }
                    else{
                        log.error("Beneficiary validation error. Reason {} ", responseModel.getReturnId());
                        if(responseModel.getReturnId().intValue() == -1){
                            dao.updateBeneficiarySyncStatus(b.getApplicationId(), 1);
                        }
                    }
                }
                else{
                    log.error("Beneficiary synced error. Reason {} ", responseModel.getErrorMessage());
                }
            }
            else{
                log.error(" !!!!!!  !!!!!! Beneficiary synced error. Response is empty");
            }
            
        });

    }
}
