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
import com.kit.migrator.datamigrator.model.Beneficiary;
import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author anwar
 */
@ToString
@NoArgsConstructor
@Data
public class BeneficiaryDto implements Serializable {
    
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
    private HouseholdInfo householdMember2;
    private HouseholdInfo householdMember5;
    private HouseholdInfo householdMember17;
    private HouseholdInfo householdMember35;
    private HouseholdInfo householdMember64;
    private HouseholdInfo householdMember65;
    private Boolean isReadWrite;
    private Integer memberReadWrite;
    private Boolean isOtherMemberPerticipating;
    private NonPerticipationReasonEnum notPerticipationReason;
    private String notPerticipationOtherReason;

    private List<NomineeDto> nominees;
    private AlternateDto alternatePayee1;
    private AlternateDto alternatePayee2;
    private List<BiometricDto> biometrics;

    private Long createdBy;
    private Long updatedBy;

    private Date created;
    private Date updated;

    public BeneficiaryDto(Beneficiary beneficiary) {
        if (beneficiary != null) {
            this.applicationId = beneficiary.getApplicationId();
            this.respondentFirstName = beneficiary.getRespondentFirstName();
            this.respondentMiddleName = beneficiary.getRespondentMiddleName();
            this.respondentLastName = beneficiary.getRespondentLastName();
            this.respondentNickName = beneficiary.getRespondentNickName();
            this.spouseFirstName = beneficiary.getSpouseFirstName();
            this.spouseMiddleName = beneficiary.getSpouseMiddleName();
            this.spouseLastName = beneficiary.getSpouseLastName();
            this.spouseNickName = beneficiary.getSpouseNickName();
            this.relationshipWithHouseholdHead = beneficiary.getRelationshipWithHouseholdHead();
            this.relationshipOther = beneficiary.getRelationshipOther();

            this.respondentAge = beneficiary.getRespondentAge();

            this.respondentGender = beneficiary.getRespondentGender();

            this.respondentMaritalStatus = beneficiary.getRespondentMaritalStatus();

            this.respondentLegalStatus = beneficiary.getRespondentLegalStatus();

            this.documentType = beneficiary.getDocumentType();

            this.documentTypeOther = beneficiary.getDocumentTypeOther();

            this.respondentId = beneficiary.getRespondentId();

            this.respondentPhoneNo = beneficiary.getRespondentPhoneNo();

            this.householdIncomeSource = beneficiary.getHouseholdIncomeSource();

            this.incomeSourceOther = beneficiary.getIncomeSourceOther();

            this.householdMonthlyAvgIncome = beneficiary.getHouseholdMonthlyAvgIncome();

            this.currency = beneficiary.getCurrency();

            this.selectionCriteria = beneficiary.getSelectionCriteria();
            if (beneficiary.getSelectionReasons() != null) {
                this.selectionReason = new ArrayList<>();
                this.selectionReason.add(SelectionReasonEnum.getByName(beneficiary.getSelectionReasons()));
            }

            if (beneficiary.getSelectionReasons() != null && beneficiary.getSelectionReasons().length() > 0) {
                this.setSelectionReason(new ArrayList<>());
                String[] reasons = beneficiary.getSelectionReasons().split(",");
                for (String reason : reasons) {
                    this.getSelectionReason().add(SelectionReasonEnum.valueOf(reason));
                }
            }

            this.address = new AddressDto(beneficiary.getAddress());

            this.location = new LocationDto(beneficiary.getLocation());

            this.householdSize = beneficiary.getHouseholdSize();

            this.householdMember2 = new HouseholdInfo(beneficiary.getHouseholdMember2());

            this.householdMember5 = new HouseholdInfo(beneficiary.getHouseholdMember5());

            this.householdMember17 = new HouseholdInfo(beneficiary.getHouseholdMember17());

            this.householdMember35 = new HouseholdInfo(beneficiary.getHouseholdMember35());

            this.householdMember64 = new HouseholdInfo(beneficiary.getHouseholdMember64());

            this.householdMember65 = new HouseholdInfo(beneficiary.getHouseholdMember65());

            this.isReadWrite = beneficiary.getIsReadWrite();

            this.memberReadWrite = beneficiary.getMemberReadWrite();

            this.isOtherMemberPerticipating = beneficiary.getIsOtherMemberPerticipating();

            this.notPerticipationReason = beneficiary.getNotPerticipationReason();

            this.notPerticipationOtherReason = beneficiary.getNotPerticipationOtherReason();

            this.alternatePayee1 = new AlternateDto(beneficiary.getAlternatePayee1());

            this.alternatePayee2 = new AlternateDto(beneficiary.getAlternatePayee2());

            this.createdBy = beneficiary.getCreatedBy();
            if (beneficiary.getNominees() != null && beneficiary.getNominees().size() > 0) {
                this.nominees = new ArrayList<>();
                beneficiary.getNominees().forEach(n -> nominees.add(new NomineeDto(n)));
            }

            this.created = beneficiary.getCreated();
            this.updated = beneficiary.getUpdated();
        }
    }
}
