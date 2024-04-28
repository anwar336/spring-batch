package com.kit.migrator.datamigrator.service;

import com.istl.afis.bean.FingerData;
import com.istl.afis.bean.Person;
import com.istl.afis.manager.AfisEnroll;
import com.kit.migrator.datamigrator.dto.BeneficiaryDto;
import com.kit.migrator.datamigrator.dto.BiometricDto;
import com.kit.migrator.datamigrator.gateway.MisGateway;
import com.kit.migrator.datamigrator.gateway.model.MisRequestModel;
import com.kit.migrator.datamigrator.gateway.model.MisResponseModel;
import com.kit.migrator.datamigrator.repository.BeneficiaryDao;
import java.util.Base64;
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
    
    @Autowired
    private AfisEnroll afisEnroll;

    @Override
    public void write(List<? extends BeneficiaryDto> beneficiaryList) throws Exception {
        beneficiaryList.forEach(b->{
            log.info(" >>> " + b.getApplicationId());
            
            MisRequestModel requestModel = new MisRequestModel(b);
            try{
                setBiometricData(b.getBiometrics(), requestModel);
            }catch(Exception ex){
                requestModel = null;
                log.error("[Biometric Error]", ex);
            }
            MisResponseModel responseModel = null;
            if(requestModel != null){
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
                    }
                }
                else{
                    log.error("Beneficiary synced error. Reason {} ", responseModel.getErrorMessage());
                }
            }
            
        });

    }
    
    private void setBiometricData(List<BiometricDto> bioDtos, MisRequestModel requestModel) throws Exception {
        
        for (BiometricDto bDto : bioDtos) {
            if(bDto.getBiometricData() == null || bDto.getBiometricData().length == 0){
                continue;
            }
            
            Person p = new Person();
            FingerData fd = new FingerData();
            switch (bDto.getBiometricType()) {
                case LT:
                    fd.setWsqLt(bDto.getBiometricData());
                    p.setFingerData(fd);
                    requestModel.setLtTemplate(Base64.getEncoder().encodeToString(afisEnroll.generateTemplate(p)));
                    break;
                case LI:
                    fd.setWsqLi(bDto.getBiometricData());
                    p.setFingerData(fd);
                    requestModel.setLtTemplate(Base64.getEncoder().encodeToString(afisEnroll.generateTemplate(p)));
                    break;
                case LM:
                    fd.setWsqLm(bDto.getBiometricData());
                    p.setFingerData(fd);
                    requestModel.setLtTemplate(Base64.getEncoder().encodeToString(afisEnroll.generateTemplate(p)));
                    break;
                case LR:
                    fd.setWsqLr(bDto.getBiometricData());
                    p.setFingerData(fd);
                    requestModel.setLtTemplate(Base64.getEncoder().encodeToString(afisEnroll.generateTemplate(p)));
                    break;
                case LL:
                    fd.setWsqLs(bDto.getBiometricData());
                    p.setFingerData(fd);
                    requestModel.setLtTemplate(Base64.getEncoder().encodeToString(afisEnroll.generateTemplate(p)));
                    break;
                case RT:
                    fd.setWsqRt(bDto.getBiometricData());
                    p.setFingerData(fd);
                    requestModel.setLtTemplate(Base64.getEncoder().encodeToString(afisEnroll.generateTemplate(p)));
                    break;
                case RI:
                    fd.setWsqRi(bDto.getBiometricData());
                    p.setFingerData(fd);
                    requestModel.setLtTemplate(Base64.getEncoder().encodeToString(afisEnroll.generateTemplate(p)));
                    break;
                case RM:
                    fd.setWsqRm(bDto.getBiometricData());
                    p.setFingerData(fd);
                    requestModel.setLtTemplate(Base64.getEncoder().encodeToString(afisEnroll.generateTemplate(p)));
                    break;
                case RR:
                    fd.setWsqRr(bDto.getBiometricData());
                    p.setFingerData(fd);
                    requestModel.setLtTemplate(Base64.getEncoder().encodeToString(afisEnroll.generateTemplate(p)));
                    break;
                case RL:
                    fd.setWsqRs(bDto.getBiometricData());
                    p.setFingerData(fd);
                    requestModel.setLtTemplate(Base64.getEncoder().encodeToString(afisEnroll.generateTemplate(p)));
                    break;
                default:
                    break;
            }
        }
    }
    
}
