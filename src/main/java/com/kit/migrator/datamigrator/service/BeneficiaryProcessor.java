package com.kit.migrator.datamigrator.service;

import com.kit.migrator.datamigrator.dto.BeneficiaryDto;
import com.kit.migrator.datamigrator.dto.BiometricDto;
import com.kit.migrator.datamigrator.dto.NomineeDto;
import com.kit.migrator.datamigrator.enums.BiometricType;
import com.kit.migrator.datamigrator.enums.BiometricUserType;
import com.kit.migrator.datamigrator.enums.SelectionReasonEnum;
import com.kit.migrator.datamigrator.model.Beneficiary;
import com.kit.migrator.datamigrator.model.Biometric;
import com.kit.migrator.datamigrator.model.Nominee;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.jnbis.api.Jnbis;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class BeneficiaryProcessor implements ItemProcessor<Beneficiary, BeneficiaryDto> {
    
    @Autowired
    private FileStorageService fileService;

    @Override
    public BeneficiaryDto process(Beneficiary beneficiary) throws Exception {
        BeneficiaryDto dto = new BeneficiaryDto();
        customFieldSet(dto, beneficiary);
        return dto;
    }

    private void customFieldSet(BeneficiaryDto beneficiaryDto, Beneficiary beneficiary) {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setAmbiguityIgnored(true)
                .setFieldMatchingEnabled(true)
                .setMatchingStrategy(MatchingStrategies.STRICT);
        mapper.map(beneficiary, beneficiaryDto);

        if (beneficiary.getBiometric() != null) {
            List<BiometricDto> biometrics = setBiometricData(beneficiary.getBiometric(), BiometricUserType.BENEFICIARY);
            beneficiaryDto.setBiometrics(biometrics);
        }
        if (beneficiary.getNominees() != null && beneficiary.getNominees().size() > 0) {
            beneficiaryDto.setNominees(new ArrayList<>());
            for (Nominee nominee : beneficiary.getNominees()) {
                NomineeDto nomineeDto = mapper.map(nominee, NomineeDto.class);
                beneficiaryDto.getNominees().add(nomineeDto);
            }
        }
        

        if (!StringUtils.isEmpty(beneficiary.getSelectionReasons())) {
            beneficiaryDto.setSelectionReason(new ArrayList<>());
            String[] reasons = beneficiary.getSelectionReasons().split(",");
            for (String reason : reasons) {
                beneficiaryDto.getSelectionReason().add(SelectionReasonEnum.valueOf(reason));
            }
        }
    }

    public List<BiometricDto> setBiometricData(Biometric bio, BiometricUserType biometricUserType) {
        List<BiometricDto> biometrics = new ArrayList<>();
        String applicationId = bio.getApplicationId();
        BiometricDto bDto;

        if (!StringUtils.isEmpty(bio.getPhoto())) {
            bDto = new BiometricDto();
            bDto.setApplicationId(applicationId);
            bDto.setBiometricUserType(biometricUserType);
            bDto.setBiometricType(BiometricType.PHOTO);
            bDto.setBiometricUrl(bio.getPhoto());
            if (!StringUtils.isEmpty(bio.getPhoto())) {
                try {
                    byte[] photoData = fileService.getObjectAsByte(bio.getPhoto());
                    bDto.setBiometricData(photoData);
                } catch (Exception ex) {
                    log.error("", ex);
                }
            }
            biometrics.add(bDto);
        }

        bDto = new BiometricDto();
        bDto.setApplicationId(applicationId);
        bDto.setBiometricUserType(biometricUserType);
        bDto.setBiometricType(BiometricType.LT);
        if (!StringUtils.isEmpty(bio.getWsqLt())) {
            bDto.setBiometricUrl(bio.getWsqLt());
            try {
                if (!StringUtils.isEmpty(bio.getWsqLt())) {
                    byte[] wsqData = fileService.getObjectAsByte(bio.getWsqLt());
                    bDto.setBiometricData(wsqData);
                }
            } catch (Exception ex) {
                log.error("", ex);
            }
        } else {
            bDto.setNoFingerPrint(true);
            bDto.setNoFingerprintReason(bio.getNoFingerprintReason());
            bDto.setNoFingerprintReasonText(bio.getNoFingerprintReasonText());
        }
        biometrics.add(bDto);

        bDto = new BiometricDto();
        bDto.setApplicationId(applicationId);
        bDto.setBiometricUserType(biometricUserType);
        bDto.setBiometricType(BiometricType.LI);
        if (!StringUtils.isEmpty(bio.getWsqLi())) {
            bDto.setBiometricUrl(bio.getWsqLi());
            try {
                if (!StringUtils.isEmpty(bio.getWsqLi())) {
                    byte[] wsqData = fileService.getObjectAsByte(bio.getWsqLi());
                    bDto.setBiometricData(wsqData);
                }
            } catch (Exception ex) {
                log.error("", ex);
            }

        } else {
            bDto.setNoFingerPrint(true);
            bDto.setNoFingerprintReason(bio.getNoFingerprintReason());
            bDto.setNoFingerprintReasonText(bio.getNoFingerprintReasonText());
        }
        biometrics.add(bDto);

        bDto = new BiometricDto();
        bDto.setApplicationId(applicationId);
        bDto.setBiometricUserType(biometricUserType);
        bDto.setBiometricType(BiometricType.LM);
        if (!StringUtils.isEmpty(bio.getWsqLm())) {
            bDto.setBiometricUrl(bio.getWsqLm());
            try {
                if (!StringUtils.isEmpty(bio.getWsqLm())) {
                    byte[] wsqData = fileService.getObjectAsByte(bio.getWsqLm());
                    bDto.setBiometricData(wsqData);
                }
            } catch (Exception ex) {
                log.error("", ex);
            }
        } else {
            bDto.setNoFingerPrint(true);
            bDto.setNoFingerprintReason(bio.getNoFingerprintReason());
            bDto.setNoFingerprintReasonText(bio.getNoFingerprintReasonText());
        }
        biometrics.add(bDto);

        bDto = new BiometricDto();
        bDto.setApplicationId(applicationId);
        bDto.setBiometricUserType(biometricUserType);
        bDto.setBiometricType(BiometricType.LR);
        if (!StringUtils.isEmpty(bio.getWsqLr())) {
            bDto.setBiometricUrl(bio.getWsqLr());
            try {
                if (!StringUtils.isEmpty(bio.getWsqLr())) {
                    byte[] wsqData = fileService.getObjectAsByte(bio.getWsqLr());
                    bDto.setBiometricData(wsqData);
                }
            } catch (Exception ex) {
                log.error("", ex);
            }
        } else {
            bDto.setNoFingerPrint(true);
            bDto.setNoFingerprintReason(bio.getNoFingerprintReason());
            bDto.setNoFingerprintReasonText(bio.getNoFingerprintReasonText());
        }
        biometrics.add(bDto);

        bDto = new BiometricDto();
        bDto.setApplicationId(applicationId);
        bDto.setBiometricUserType(biometricUserType);
        bDto.setBiometricType(BiometricType.LL);
        if (!StringUtils.isEmpty(bio.getWsqLs())) {
            bDto.setBiometricUrl(bio.getWsqLs());
            try {
                if (!StringUtils.isEmpty(bio.getWsqLs())) {
                    byte[] wsqData = fileService.getObjectAsByte(bio.getWsqLs());
                    bDto.setBiometricData(wsqData);
                }
            } catch (Exception ex) {
                log.error("", ex);
            }
        } else {
            bDto.setNoFingerPrint(true);
            bDto.setNoFingerprintReason(bio.getNoFingerprintReason());
            bDto.setNoFingerprintReasonText(bio.getNoFingerprintReasonText());
        }
        biometrics.add(bDto);

        bDto = new BiometricDto();
        bDto.setApplicationId(applicationId);
        bDto.setBiometricUserType(biometricUserType);
        bDto.setBiometricType(BiometricType.RT);
        if (!StringUtils.isEmpty(bio.getWsqRt())) {
            bDto.setBiometricUrl(bio.getWsqRt());
            try {
                if (!StringUtils.isEmpty(bio.getWsqRt())) {
                    byte[] wsqData = fileService.getObjectAsByte(bio.getWsqRt());
                    bDto.setBiometricData(wsqData);
                }
            } catch (Exception ex) {
                log.error("", ex);
            }
        } else {
            bDto.setNoFingerPrint(true);
            bDto.setNoFingerprintReason(bio.getNoFingerprintReason());
            bDto.setNoFingerprintReasonText(bio.getNoFingerprintReasonText());
        }
        biometrics.add(bDto);

        bDto = new BiometricDto();
        bDto.setApplicationId(applicationId);
        bDto.setBiometricUserType(biometricUserType);
        bDto.setBiometricType(BiometricType.RI);
        if (!StringUtils.isEmpty(bio.getWsqRi())) {
            bDto.setBiometricUrl(bio.getWsqRi());
            try {
                if (!StringUtils.isEmpty(bio.getWsqRi())) {
                    byte[] wsqData = fileService.getObjectAsByte(bio.getWsqRi());
                    bDto.setBiometricData(wsqData);
                }
            } catch (Exception ex) {
                log.error("", ex);
            }

        } else {
            bDto.setNoFingerPrint(true);
            bDto.setNoFingerprintReason(bio.getNoFingerprintReason());
            bDto.setNoFingerprintReasonText(bio.getNoFingerprintReasonText());
        }
        biometrics.add(bDto);

        bDto = new BiometricDto();
        bDto.setApplicationId(applicationId);
        bDto.setBiometricUserType(biometricUserType);
        bDto.setBiometricType(BiometricType.RM);
        if (!StringUtils.isEmpty(bio.getWsqRm())) {
            bDto.setBiometricUrl(bio.getWsqRm());
            try {
                if (!StringUtils.isEmpty(bio.getWsqRm())) {
                    byte[] wsqData = fileService.getObjectAsByte(bio.getWsqRm());
                    bDto.setBiometricData(wsqData);
                }
            } catch (Exception ex) {
                log.error("", ex);
            }
        } else {
            bDto.setNoFingerPrint(true);
            bDto.setNoFingerprintReason(bio.getNoFingerprintReason());
            bDto.setNoFingerprintReasonText(bio.getNoFingerprintReasonText());
        }
        biometrics.add(bDto);

        bDto = new BiometricDto();
        bDto.setApplicationId(applicationId);
        bDto.setBiometricUserType(biometricUserType);
        bDto.setBiometricType(BiometricType.RR);
        if (!StringUtils.isEmpty(bio.getWsqRr())) {
            bDto.setBiometricUrl(bio.getWsqRr());
            try {
                if (!StringUtils.isEmpty(bio.getWsqRr())) {
                    byte[] wsqData = fileService.getObjectAsByte(bio.getWsqRr());
                    bDto.setBiometricData(wsqData);
                }
            } catch (Exception ex) {
                log.error("", ex);
            }
        } else {
            bDto.setNoFingerPrint(true);
            bDto.setNoFingerprintReason(bio.getNoFingerprintReason());
            bDto.setNoFingerprintReasonText(bio.getNoFingerprintReasonText());
        }
        biometrics.add(bDto);

        bDto = new BiometricDto();
        bDto.setApplicationId(applicationId);
        bDto.setBiometricUserType(biometricUserType);
        bDto.setBiometricType(BiometricType.RL);
        if (!StringUtils.isEmpty(bio.getWsqRs())) {
            bDto.setBiometricUrl(bio.getWsqRs());
            try {
                if (!StringUtils.isEmpty(bio.getWsqRs())) {
                    byte[] wsqData = fileService.getObjectAsByte(bio.getWsqRs());
                    bDto.setBiometricData(wsqData);
                }
            } catch (Exception ex) {
                log.error("", ex);
            }
        } else {
            bDto.setNoFingerPrint(true);
            bDto.setNoFingerprintReason(bio.getNoFingerprintReason());
            bDto.setNoFingerprintReasonText(bio.getNoFingerprintReasonText());
        }
        biometrics.add(bDto);

        return biometrics;
    }
}
