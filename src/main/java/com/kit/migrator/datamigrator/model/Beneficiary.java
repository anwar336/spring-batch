package com.kit.migrator.datamigrator.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import com.kit.migrator.datamigrator.enums.*;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "BENEFICIARY")
@NoArgsConstructor
public class Beneficiary {
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "application_id", nullable = false, length = 100)
    private String applicationId;

    @Column(name = "RESPONDENT_FIRST_NAME", nullable = false, length = 100)
    private String respondentFirstName;

    @Column(name = "RESPONDENT_MIDDLE_NAME", nullable = false, length = 100)
    private String respondentMiddleName;

    @Column(name = "RESPONDENT_LAST_NAME", nullable = false, length = 100)
    private String respondentLastName;

    @Column(name = "RESPONDENT_NICK_NAME", length = 100)
    private String respondentNickName;

    @Column(name = "SPOUSE_FIRST_NAME", length = 100)
    private String spouseFirstName;

    @Column(name = "SPOUSE_MIDDLE_NAME", length = 100)
    private String spouseMiddleName;

    @Column(name = "SPOUSE_LAST_NAME", length = 100)
    private String spouseLastName;

    @Column(name = "SPOUSE_NICK_NAME", length = 100)
    private String spouseNickName;

    @Column(name = "RELATIONSHIP_WITH_HOUSEHOLD", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private RelationshipEnum relationshipWithHouseholdHead;

    @Column(name = "RELATIONSHIP_OTHER", length = 100)
    private String relationshipOther;

    @Column(name = "RESPONDENT_AGE", nullable = false)
    private Integer respondentAge;

    @Column(name = "RESPONDENT_GENDER", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private GenderEnum respondentGender;

    @Column(name = "RESPONDENT_MARITAL_STATUS", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private MaritalStatusEnum respondentMaritalStatus;

    @Column(name = "RESPONDENT_LEGAL_STATUS", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private LegalStatusEnum respondentLegalStatus;

    @Column(name = "DOCUMENT_TYPE", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private DocumentTypeEnum documentType;

    @Column(name = "DOCUMENT_TYPE_OTHER", length = 100)
    private String documentTypeOther;

    @Column(name = "RESPONDENT_ID", length = 50)
    private String respondentId;

    @Column(name = "RESPONDENT_PHONE_NO", length = 10)
    private String respondentPhoneNo;

    @Column(name = "HOUSEHOLD_INCOME_SOURCE", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private IncomeSourceEnum householdIncomeSource;

    @Column(name = "INCOME_SOURCE_OTHER", length = 100)
    private String incomeSourceOther;

    @Column(name = "HOUSEHOLD_MONTHLY_AVG_INCOME", nullable = false)
    private Integer householdMonthlyAvgIncome;

    @Column(name = "CURRENCY", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private CurrencyEnum currency;

    @Column(name = "SELECTION_CRITERIA", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private SelectionCriteriaEnum selectionCriteria;

    @Column(name = "SELECTION_REASONS", nullable = false)
    private String selectionReasons;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ADDRESS_ID", referencedColumnName = "ID", nullable = false)
    private Address address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "LOCATION_ID", referencedColumnName = "ID")
    private Location location;

    @Column(name = "HOUSEHOLD_SIZE", nullable = false)
    private Integer householdSize;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "HOUSEHOLD_MEMBER_2", referencedColumnName = "ID", nullable = false)
    private HouseholdInfo householdMember2;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "HOUSEHOLD_MEMBER_5", referencedColumnName = "ID", nullable = false)
    private HouseholdInfo householdMember5;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "HOUSEHOLD_MEMBER_17", referencedColumnName = "ID", nullable = false)
    private HouseholdInfo householdMember17;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "HOUSEHOLD_MEMBER_35", referencedColumnName = "ID", nullable = false)
    private HouseholdInfo householdMember35;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "HOUSEHOLD_MEMBER_64", referencedColumnName = "ID", nullable = false)
    private HouseholdInfo householdMember64;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "HOUSEHOLD_MEMBER_65", referencedColumnName = "ID", nullable = false)
    private HouseholdInfo householdMember65;

    @Column(name = "IS_READ_WRITE", nullable = false)
    private Boolean isReadWrite;

    @Column(name = "MEMBER_READ_WRITE", nullable = false)
    private Integer memberReadWrite;

    @Column(name = "IS_OTHER_MEMBER_PERTICIPATING", nullable = false)
    private Boolean isOtherMemberPerticipating;

    @Column(name = "NON_PERTICIPATION_REASON")
    @Enumerated(EnumType.ORDINAL)
    private NonPerticipationReasonEnum notPerticipationReason;

    @Column(name = "NON_PERTICIPATION_OTHER_REASON")
    private String notPerticipationOtherReason;

    @OneToMany(mappedBy = "beneficiary", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Nominee> nominees;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ALTERNATE_PAYEE_1", referencedColumnName = "ID")
    private Alternate alternatePayee1;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ALTERNATE_PAYEE_2", referencedColumnName = "ID")
    private Alternate alternatePayee2;

    @Column(name = "STATUS", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private StatusEnum status;

    @Column(name = "AFIS_STATUS", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private AfisStatusEnum afisStatus;

    @Column(name = "CREATED", nullable = false)
    private Date created;

    @Column(name = "UPDATED", nullable = false)
    private Date updated;

    @Column(name = "CREATED_BY", nullable = false)
    private Long createdBy;

    @Column(name = "UPDATED_BY")
    private Long updatedBy;

    @Version
    @Column(name = "VERSION", nullable = false)
    private Integer version;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getSelectionReasons() {
        return selectionReasons;
    }

    public void setSelectionReasons(String selectionReasons) {
        this.selectionReasons = selectionReasons;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
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

    public List<Nominee> getNominees() {
        return nominees;
    }

    public void setNominees(List<Nominee> nominees) {
        this.nominees = nominees;
    }

    public Alternate getAlternatePayee1() {
        return alternatePayee1;
    }

    public void setAlternatePayee1(Alternate alternatePayee1) {
        this.alternatePayee1 = alternatePayee1;
    }

    public Alternate getAlternatePayee2() {
        return alternatePayee2;
    }

    public void setAlternatePayee2(Alternate alternatePayee2) {
        this.alternatePayee2 = alternatePayee2;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public AfisStatusEnum getAfisStatus() {
        return afisStatus;
    }

    public void setAfisStatus(AfisStatusEnum afisStatus) {
        this.afisStatus = afisStatus;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
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

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
