/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kit.migrator.datamigrator.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.kit.migrator.datamigrator.enums.*;
import com.kit.migrator.datamigrator.model.Alternate;
import com.kit.migrator.datamigrator.model.Beneficiary;
import com.kit.migrator.datamigrator.model.HouseholdInfo;
import com.kit.migrator.datamigrator.model.HouseholdInfoLP;
import com.kit.migrator.datamigrator.model.Nominee;
import io.micrometer.core.instrument.util.StringUtils;
import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 *
 * @author anwar
 */
@ToString
@NoArgsConstructor
@Data
@Document(indexName = "index_p2_beneficiary")
public class BeneficiaryDto implements Serializable {

    @Id
    private String applicationId;
    private String respondentFirstName;
    private String respondentMiddleName;
    private String respondentLastName;
    private String respondentNickName;
    private String spouseFirstName;
    private String spouseMiddleName;
    private String spouseLastName;
    private String spouseNickName;
    private RelationshipEnum relationshipWithHouseholdHead;
    private String relationshipOther;
    private Integer respondentAge;
    private GenderEnum respondentGender;
    private MaritalStatusEnum respondentMaritalStatus;
    private LegalStatusEnum respondentLegalStatus;
    private DocumentTypeEnum documentType;
    private String documentTypeOther;
    private String respondentId;
    private String respondentPhoneNo;
    private IncomeSourceEnum householdIncomeSource;
    private String incomeSourceOther;
    private Integer householdMonthlyAvgIncome;
    private CurrencyEnum currency;
    private SelectionCriteriaEnum selectionCriteria;
    private List<SelectionReasonEnum> selectionReason;
    private AddressDto address;
    private LocationDto location;
    private Integer householdSize;
    private HouseholdInfoDto householdMember2;
    private HouseholdInfoDto householdMember5;
    private HouseholdInfoDto householdMember17;
    private HouseholdInfoDto householdMember35;
    private HouseholdInfoDto householdMember64;
    private HouseholdInfoDto householdMember65;
    private HouseholdInfoLPDto householdMember35LP;
    private HouseholdInfoLPDto householdMember64LP;
    
    private Boolean isReadWrite;
    private Integer memberReadWrite;
    private Boolean isOtherMemberPerticipating;
    private NonPerticipationReasonEnum notPerticipationReason;
    private String notPerticipationOtherReason;

    private List<NomineeDto> nominees;
    private AlternateDto alternatePayee1;
    private AlternateDto alternatePayee2;
    private List<BiometricDto> biometrics;

    private RegistrationPhaseEnum registrationPhase;

    private Boolean hasMobileWallet;
    private MobileMoneyProviderEnum mobileMoneyProvider;
    private String mobileWalletNumber;
    
    private Long createdBy;
    private Long updatedBy;

    private Date created;
    private Date updated;

    public BeneficiaryDto(Beneficiary beneficiary) {
        if (beneficiary == null) return;

        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration()
                .setAmbiguityIgnored(true)
                .setFieldMatchingEnabled(true)
                .setMatchingStrategy(MatchingStrategies.STRICT);

        mapper.map(beneficiary, this);

        if (beneficiary.getNominees() != null && !beneficiary.getNominees().isEmpty()) {
            List<NomineeDto> nomineeDtos = new ArrayList<>();
            for (Nominee n : beneficiary.getNominees()) {
                try {
                    NomineeDto dto = mapper.map(n, NomineeDto.class);
                    nomineeDtos.add(dto);
                } catch (Exception ignore) {
                }
            }
            this.setNominees(nomineeDtos);
        }

        if (beneficiary.getAlternates() != null && !beneficiary.getAlternates().isEmpty()) {
            for (Alternate alt : beneficiary.getAlternates()) {
                if (alt == null || alt.getAltIndex() == null) continue;

                try {
                    AlternateDto altDto = mapper.map(alt, AlternateDto.class);

                    if (alt.getAltIndex() == 1) {
                        this.setAlternatePayee1(altDto);
                    } else if (alt.getAltIndex() == 2) {
                        this.setAlternatePayee2(altDto);
                    }
                } catch (Exception ignore) {
                }
            }
        }

        if (beneficiary.getHouseholdInfos() != null && !beneficiary.getHouseholdInfos().isEmpty()) {
            for (HouseholdInfo hi : beneficiary.getHouseholdInfos()) {
                if (hi == null) continue;
                Integer min = hi.getMinimumAge();
                Integer max = hi.getMaximumAge();

                try {
                    HouseholdInfoDto hiDto = mapper.map(hi, HouseholdInfoDto.class);

                    if (min != null && max != null) {
                        if (min == 0 && max == 2) this.setHouseholdMember2(hiDto);
                        else if (min == 3 && max == 5) this.setHouseholdMember5(hiDto);
                        else if (min == 6 && max == 17) this.setHouseholdMember17(hiDto);
                        else if (min == 18 && max == 35) this.setHouseholdMember35(hiDto);
                        else if (min == 36 && max == 64) this.setHouseholdMember64(hiDto);
                        else if (min == 65 && max == 999) this.setHouseholdMember65(hiDto);
                    }
                } catch (Exception ignore) {
                }
            }
        }


        // 🧩 Lactating & Pregnant Household Info Mapping
        if (beneficiary.getHouseholdInfosLP() != null
                && !beneficiary.getHouseholdInfosLP().isEmpty()) {
            for (HouseholdInfoLP hi : beneficiary.getHouseholdInfosLP()) {
                if (hi == null) continue;

                try {
                    HouseholdInfoLPDto lpDto = mapper.map(hi, HouseholdInfoLPDto.class);
                    Integer min = hi.getMinimumAge();
                    Integer max = hi.getMaximumAge();
                    if (min != null && max != null) {
                        if (min == 18 && max == 35) {
                            this.setHouseholdMember35LP(lpDto);
                        } else if (min == 36 && max == 64) {
                            this.setHouseholdMember64LP(lpDto);
                        }
                    }

                } catch (Exception ignore) {
                }
            }
        }

        if (beneficiary.getSelectionReasons() != null && !beneficiary.getSelectionReasons().trim().isEmpty()) {
            List<SelectionReasonEnum> reasons = new ArrayList<>();
            String[] parts = beneficiary.getSelectionReasons().split(",");
            for (String p : parts) {
                String token = (p == null) ? "" : p.trim();
                if (token.isEmpty()) continue;
                try {
                    reasons.add(SelectionReasonEnum.valueOf(token));
                } catch (IllegalArgumentException ignore) {
                }
            }
            if (!reasons.isEmpty()) {
                this.setSelectionReason(reasons);
            }
        }

        if (beneficiary.getMobileWalletId() != null) {
            this.setMobileMoneyProvider(MobileMoneyProviderEnum.values()[beneficiary.getMobileWalletId()]);
        }
    }
}
