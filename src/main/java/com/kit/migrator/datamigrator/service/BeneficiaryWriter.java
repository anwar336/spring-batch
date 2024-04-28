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
import com.neurotec.biometrics.NEPosition;
import com.neurotec.biometrics.NFPosition;
import com.neurotec.biometrics.NFinger;
import com.neurotec.biometrics.NIris;
import com.neurotec.biometrics.NSubject;
import com.neurotec.biometrics.standards.CBEFFBDBFormatIdentifiers;
import com.neurotec.biometrics.standards.CBEFFBiometricOrganizations;
import com.neurotec.biometrics.standards.FMRecord;
import com.neurotec.images.NImage;
import com.neurotec.images.NImageFormat;
import com.neurotec.io.NBuffer;
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
    
    //@Autowired
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
            
            FingerData fd = new FingerData();
            switch (bDto.getBiometricType()) {
                case LT:
                    fd.setWsqLt(bDto.getBiometricData());
                    requestModel.setLtTemplate(Base64.getEncoder().encodeToString(generateTemplate(fd)));
                    break;
                case LI:
                    fd.setWsqLi(bDto.getBiometricData());
                    requestModel.setLtTemplate(Base64.getEncoder().encodeToString(generateTemplate(fd)));
                    break;
                case LM:
                    fd.setWsqLm(bDto.getBiometricData());
                    requestModel.setLtTemplate(Base64.getEncoder().encodeToString(generateTemplate(fd)));
                    break;
                case LR:
                    fd.setWsqLr(bDto.getBiometricData());
                    requestModel.setLtTemplate(Base64.getEncoder().encodeToString(generateTemplate(fd)));
                    break;
                case LL:
                    fd.setWsqLs(bDto.getBiometricData());
                    requestModel.setLtTemplate(Base64.getEncoder().encodeToString(generateTemplate(fd)));
                    break;
                case RT:
                    fd.setWsqRt(bDto.getBiometricData());
                    requestModel.setLtTemplate(Base64.getEncoder().encodeToString(generateTemplate(fd)));
                    break;
                case RI:
                    fd.setWsqRi(bDto.getBiometricData());
                    requestModel.setLtTemplate(Base64.getEncoder().encodeToString(generateTemplate(fd)));
                    break;
                case RM:
                    fd.setWsqRm(bDto.getBiometricData());
                    requestModel.setLtTemplate(Base64.getEncoder().encodeToString(generateTemplate(fd)));
                    break;
                case RR:
                    fd.setWsqRr(bDto.getBiometricData());
                    requestModel.setLtTemplate(Base64.getEncoder().encodeToString(generateTemplate(fd)));
                    break;
                case RL:
                    fd.setWsqRs(bDto.getBiometricData());
                    requestModel.setLtTemplate(Base64.getEncoder().encodeToString(generateTemplate(fd)));
                    break;
                default:
                    break;
            }
        }
    }
    
    private byte[] generateTemplate(FingerData fingerData){
        NSubject subject = new NSubject();
        NFinger finger = null;
        if (fingerData != null) {
            if (fingerData.getWsqLt() != null) {
                try {
                    finger = new NFinger();
                    finger.setPosition(NFPosition.LEFT_THUMB);
                    finger.setImage(NImage.fromMemory(NBuffer.fromArray(fingerData.getWsqLt()), NImageFormat.getWSQ()));
                    subject.getFingers().add(finger);
                } catch (Throwable t) {

                }
            }

            if (fingerData.getWsqLi() != null) {
                try {
                    finger = new NFinger();
                    finger.setPosition(NFPosition.LEFT_INDEX_FINGER);
                    finger.setImage(NImage.fromMemory(NBuffer.fromArray(fingerData.getWsqLi()), NImageFormat.getWSQ()));
                    subject.getFingers().add(finger);
                } catch (Throwable t) {

                }
            }

            if (fingerData.getWsqLm() != null) {
                try {
                    finger = new NFinger();
                    finger.setPosition(NFPosition.LEFT_MIDDLE_FINGER);
                    finger.setImage(NImage.fromMemory(NBuffer.fromArray(fingerData.getWsqLm()), NImageFormat.getWSQ()));
                    subject.getFingers().add(finger);
                } catch (Throwable t) {

                }
            }

            if (fingerData.getWsqLr() != null) {
                try {
                    finger = new NFinger();
                    finger.setPosition(NFPosition.LEFT_RING_FINGER);
                    finger.setImage(NImage.fromMemory(NBuffer.fromArray(fingerData.getWsqLr()), NImageFormat.getWSQ()));
                    subject.getFingers().add(finger);
                } catch (Throwable t) {

                }
            }

            if (fingerData.getWsqLs() != null) {
                try {
                    finger = new NFinger();
                    finger.setPosition(NFPosition.LEFT_LITTLE_FINGER);
                    finger.setImage(NImage.fromMemory(NBuffer.fromArray(fingerData.getWsqLs()), NImageFormat.getWSQ()));
                    subject.getFingers().add(finger);
                } catch (Throwable t) {

                }
            }

            if (fingerData.getWsqRt() != null) {
                try {
                    finger = new NFinger();
                    finger.setPosition(NFPosition.RIGHT_THUMB);
                    finger.setImage(NImage.fromMemory(NBuffer.fromArray(fingerData.getWsqRt()), NImageFormat.getWSQ()));
                    subject.getFingers().add(finger);
                } catch (Throwable t) {
                    t.printStackTrace();
                }
            }

            if (fingerData.getWsqRi() != null) {
                try {
                    finger = new NFinger();
                    finger.setPosition(NFPosition.RIGHT_INDEX_FINGER);
                    finger.setImage(NImage.fromMemory(NBuffer.fromArray(fingerData.getWsqRi()), NImageFormat.getWSQ()));
                    subject.getFingers().add(finger);
                } catch (Throwable t) {

                }
            }

            if (fingerData.getWsqRm() != null) {
                try {
                    finger = new NFinger();
                    finger.setPosition(NFPosition.RIGHT_MIDDLE_FINGER);
                    finger.setImage(NImage.fromMemory(NBuffer.fromArray(fingerData.getWsqRm()), NImageFormat.getWSQ()));
                    subject.getFingers().add(finger);
                } catch (Throwable t) {

                }
            }

            if (fingerData.getWsqRr() != null) {
                try {
                    finger = new NFinger();
                    finger.setPosition(NFPosition.RIGHT_RING_FINGER);
                    finger.setImage(NImage.fromMemory(NBuffer.fromArray(fingerData.getWsqRr()), NImageFormat.getWSQ()));
                    subject.getFingers().add(finger);
                } catch (Throwable t) {

                }
            }

            if (fingerData.getWsqRs() != null) {
                try {
                    finger = new NFinger();
                    finger.setPosition(NFPosition.RIGHT_LITTLE_FINGER);
                    finger.setImage(NImage.fromMemory(NBuffer.fromArray(fingerData.getWsqRs()), NImageFormat.getWSQ()));
                    subject.getFingers().add(finger);
                } catch (Throwable t) {

                }
            }
        }
        NBuffer buffer = subject.getTemplateBuffer(CBEFFBiometricOrganizations.ISO_IEC_JTC_1_SC_37_BIOMETRICS,
                CBEFFBDBFormatIdentifiers.ISO_IEC_JTC_1_SC_37_BIOMETRICS_FINGER_MINUTIAE_RECORD_FORMAT,
                FMRecord.VERSION_ISO_CURRENT);
        return buffer.toByteArray();
    }
    
}
