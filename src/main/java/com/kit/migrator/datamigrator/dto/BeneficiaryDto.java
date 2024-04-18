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
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author anwar
 */
@ToString
@NoArgsConstructor
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
    
    private Long createdBy;
    private Long updatedBy;


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

            this.address = new AddressDto(beneficiary.getAddress());

            this.location = new LocationDto(beneficiary.getLocation());

            this.householdSize = beneficiary.getHouseholdSize();

            this.householdMember2 = new HouseholdInfo(beneficiary.getHouseholdMember2());

            this.householdMember5 = new HouseholdInfo(beneficiary.getHouseholdMember5());

            this.householdMember17 = new HouseholdInfo(beneficiary.getHouseholdMember17());

            this.householdMember35 = new HouseholdInfo(beneficiary.getHouseholdMember5());

            this.householdMember64 =  new HouseholdInfo(beneficiary.getHouseholdMember64());

            this.householdMember65 = new HouseholdInfo(beneficiary.getHouseholdMember5());

            this.isReadWrite = beneficiary.getReadWrite();

            this.memberReadWrite = beneficiary.getMemberReadWrite();

            this.isOtherMemberPerticipating = beneficiary.getOtherMemberPerticipating();

            this.notPerticipationReason = beneficiary.getNotPerticipationReason();

            this.notPerticipationOtherReason = beneficiary.getNotPerticipationOtherReason();

            this.alternatePayee1 = new AlternateDto(beneficiary.getAlternatePayee1());

            this.alternatePayee2 = new AlternateDto(beneficiary.getAlternatePayee2());

            this.createdBy = beneficiary.getCreatedBy();
            if (beneficiary.getNominees() != null && beneficiary.getNominees().size() >0) {
                this.nominees = new ArrayList<>();
                beneficiary.getNominees().forEach(n->nominees.add(new NomineeDto(n)));
            }
        }
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getRespondentFirstName() {
        return respondentFirstName;
    }

    public void setRespondentFirstName(String respondentFirstName) {
        this.respondentFirstName = respondentFirstName;
    }

    public String getRespondentMiddleName() {
        return respondentMiddleName;
    }

    public void setRespondentMiddleName(String respondentMiddleName) {
        this.respondentMiddleName = respondentMiddleName;
    }

    public String getRespondentLastName() {
        return respondentLastName;
    }

    public void setRespondentLastName(String respondentLastName) {
        this.respondentLastName = respondentLastName;
    }

    public String getRespondentNickName() {
        return respondentNickName;
    }

    public void setRespondentNickName(String respondentNickName) {
        this.respondentNickName = respondentNickName;
    }

    public String getSpouseFirstName() {
        return spouseFirstName;
    }

    public void setSpouseFirstName(String spouseFirstName) {
        this.spouseFirstName = spouseFirstName;
    }

    public String getSpouseMiddleName() {
        return spouseMiddleName;
    }

    public void setSpouseMiddleName(String spouseMiddleName) {
        this.spouseMiddleName = spouseMiddleName;
    }

    public String getSpouseLastName() {
        return spouseLastName;
    }

    public void setSpouseLastName(String spouseLastName) {
        this.spouseLastName = spouseLastName;
    }

    public String getSpouseNickName() {
        return spouseNickName;
    }

    public void setSpouseNickName(String spouseNickName) {
        this.spouseNickName = spouseNickName;
    }

    public RelationshipEnum getRelationshipWithHouseholdHead() {
        return relationshipWithHouseholdHead;
    }

    public void setRelationshipWithHouseholdHead(RelationshipEnum relationshipWithHouseholdHead) {
        this.relationshipWithHouseholdHead = relationshipWithHouseholdHead;
    }

    public String getRelationshipOther() {
        return relationshipOther;
    }

    public void setRelationshipOther(String relationshipOther) {
        this.relationshipOther = relationshipOther;
    }

    public Integer getRespondentAge() {
        return respondentAge;
    }

    public void setRespondentAge(Integer respondentAge) {
        this.respondentAge = respondentAge;
    }

    public GenderEnum getRespondentGender() {
        return respondentGender;
    }

    public void setRespondentGender(GenderEnum respondentGender) {
        this.respondentGender = respondentGender;
    }

    public MaritalStatusEnum getRespondentMaritalStatus() {
        return respondentMaritalStatus;
    }

    public void setRespondentMaritalStatus(MaritalStatusEnum respondentMaritalStatus) {
        this.respondentMaritalStatus = respondentMaritalStatus;
    }

    public LegalStatusEnum getRespondentLegalStatus() {
        return respondentLegalStatus;
    }

    public void setRespondentLegalStatus(LegalStatusEnum respondentLegalStatus) {
        this.respondentLegalStatus = respondentLegalStatus;
    }

    public DocumentTypeEnum getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentTypeEnum documentType) {
        this.documentType = documentType;
    }

    public String getDocumentTypeOther() {
        return documentTypeOther;
    }

    public void setDocumentTypeOther(String documentTypeOther) {
        this.documentTypeOther = documentTypeOther;
    }

    public String getRespondentId() {
        return respondentId;
    }

    public void setRespondentId(String respondentId) {
        this.respondentId = respondentId;
    }

    public String getRespondentPhoneNo() {
        return respondentPhoneNo;
    }

    public void setRespondentPhoneNo(String respondentPhoneNo) {
        this.respondentPhoneNo = respondentPhoneNo;
    }

    public IncomeSourceEnum getHouseholdIncomeSource() {
        return householdIncomeSource;
    }

    public void setHouseholdIncomeSource(IncomeSourceEnum householdIncomeSource) {
        this.householdIncomeSource = householdIncomeSource;
    }

    public String getIncomeSourceOther() {
        return incomeSourceOther;
    }

    public void setIncomeSourceOther(String incomeSourceOther) {
        this.incomeSourceOther = incomeSourceOther;
    }

    public Integer getHouseholdMonthlyAvgIncome() {
        return householdMonthlyAvgIncome;
    }

    public void setHouseholdMonthlyAvgIncome(Integer householdMonthlyAvgIncome) {
        this.householdMonthlyAvgIncome = householdMonthlyAvgIncome;
    }

    public CurrencyEnum getCurrency() {
        return currency;
    }

    public void setCurrency(CurrencyEnum currency) {
        this.currency = currency;
    }

    public SelectionCriteriaEnum getSelectionCriteria() {
        return selectionCriteria;
    }

    public void setSelectionCriteria(SelectionCriteriaEnum selectionCriteria) {
        this.selectionCriteria = selectionCriteria;
    }

    public List<SelectionReasonEnum> getSelectionReason() {
        return selectionReason;
    }

    public void setSelectionReason(List<SelectionReasonEnum> selectionReason) {
        this.selectionReason = selectionReason;
    }

    public AddressDto getAddress() {
        return address;
    }

    public void setAddress(AddressDto address) {
        this.address = address;
    }

    public LocationDto getLocation() {
        return location;
    }

    public void setLocation(LocationDto location) {
        this.location = location;
    }

    public Integer getHouseholdSize() {
        return householdSize;
    }

    public void setHouseholdSize(Integer householdSize) {
        this.householdSize = householdSize;
    }

    public HouseholdInfo getHouseholdMember2() {
        return householdMember2;
    }

    public void setHouseholdMember2(HouseholdInfo householdMember2) {
        this.householdMember2 = householdMember2;
    }

    public HouseholdInfo getHouseholdMember5() {
        return householdMember5;
    }

    public void setHouseholdMember5(HouseholdInfo householdMember5) {
        this.householdMember5 = householdMember5;
    }

    public HouseholdInfo getHouseholdMember17() {
        return householdMember17;
    }

    public void setHouseholdMember17(HouseholdInfo householdMember17) {
        this.householdMember17 = householdMember17;
    }

    public HouseholdInfo getHouseholdMember35() {
        return householdMember35;
    }

    public void setHouseholdMember35(HouseholdInfo householdMember35) {
        this.householdMember35 = householdMember35;
    }

    public HouseholdInfo getHouseholdMember64() {
        return householdMember64;
    }

    public void setHouseholdMember64(HouseholdInfo householdMember64) {
        this.householdMember64 = householdMember64;
    }

    public HouseholdInfo getHouseholdMember65() {
        return householdMember65;
    }

    public void setHouseholdMember65(HouseholdInfo householdMember65) {
        this.householdMember65 = householdMember65;
    }

    public Boolean getReadWrite() {
        return isReadWrite;
    }

    public void setReadWrite(Boolean readWrite) {
        isReadWrite = readWrite;
    }

    public Integer getMemberReadWrite() {
        return memberReadWrite;
    }

    public void setMemberReadWrite(Integer memberReadWrite) {
        this.memberReadWrite = memberReadWrite;
    }

    public Boolean getOtherMemberPerticipating() {
        return isOtherMemberPerticipating;
    }

    public void setOtherMemberPerticipating(Boolean otherMemberPerticipating) {
        isOtherMemberPerticipating = otherMemberPerticipating;
    }

    public NonPerticipationReasonEnum getNotPerticipationReason() {
        return notPerticipationReason;
    }

    public void setNotPerticipationReason(NonPerticipationReasonEnum notPerticipationReason) {
        this.notPerticipationReason = notPerticipationReason;
    }

    public String getNotPerticipationOtherReason() {
        return notPerticipationOtherReason;
    }

    public void setNotPerticipationOtherReason(String notPerticipationOtherReason) {
        this.notPerticipationOtherReason = notPerticipationOtherReason;
    }

    public List<NomineeDto> getNominees() {
        return nominees;
    }

    public void setNominees(List<NomineeDto> nominees) {
        this.nominees = nominees;
    }

    public AlternateDto getAlternatePayee1() {
        return alternatePayee1;
    }

    public void setAlternatePayee1(AlternateDto alternatePayee1) {
        this.alternatePayee1 = alternatePayee1;
    }

    public AlternateDto getAlternatePayee2() {
        return alternatePayee2;
    }

    public void setAlternatePayee2(AlternateDto alternatePayee2) {
        this.alternatePayee2 = alternatePayee2;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Long getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }
}
