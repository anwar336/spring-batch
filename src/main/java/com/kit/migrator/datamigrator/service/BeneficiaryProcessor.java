package com.kit.migrator.datamigrator.service;

import com.kit.migrator.datamigrator.Utility.Utils;
import com.kit.migrator.datamigrator.dto.BeneficiaryDto;
import com.kit.migrator.datamigrator.dto.NomineeDto;
import com.kit.migrator.datamigrator.enums.SelectionReasonEnum;
import com.kit.migrator.datamigrator.model.Beneficiary;
import com.kit.migrator.datamigrator.model.Nominee;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.batch.item.ItemProcessor;

@Slf4j
public class BeneficiaryProcessor implements ItemProcessor<Beneficiary, BeneficiaryDto> {

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

        if (beneficiary.getNominees() != null && beneficiary.getNominees().size() > 0) {
            beneficiaryDto.setNominees(new ArrayList<>());
            for (Nominee nominee : beneficiary.getNominees()) {
                NomineeDto nomineeDto = mapper.map(nominee, NomineeDto.class);
                beneficiaryDto.getNominees().add(nomineeDto);
            }
        }
        
        if(beneficiary.getBiometric() != null){
            beneficiaryDto.setPhotoUrl(beneficiary.getBiometric().getPhoto());
        }
        
        if(beneficiary.getAlternatePayee1() != null && beneficiary.getAlternatePayee1().getBiometric() != null){
            beneficiaryDto.getAlternatePayee1().setPhotoUrl(beneficiary.getAlternatePayee1().getBiometric().getPhoto());
        }
        
        if(beneficiary.getAlternatePayee2() != null && beneficiary.getAlternatePayee2().getBiometric() != null){
            beneficiaryDto.getAlternatePayee2().setPhotoUrl(beneficiary.getAlternatePayee2().getBiometric().getPhoto());
        }
        

        if (!Utils.isEmpty(beneficiary.getSelectionReasons())) {
            beneficiaryDto.setSelectionReason(new ArrayList<>());
            String[] reasons = beneficiary.getSelectionReasons().split(",");
            for (String reason : reasons) {
                beneficiaryDto.getSelectionReason().add(SelectionReasonEnum.valueOf(reason));
            }
        }
    }
}
