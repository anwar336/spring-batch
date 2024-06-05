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
@Data
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
    
    @Column(name = "MIS_SYNC_STATUS")
    private Integer misSyncStatus;
    
    @Column(name = "ES_SYNC_STATUS")
    private Integer esSyncStatus;

    @Version
    @Column(name = "VERSION", nullable = false)
    private Integer version;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "BIOMETRIC_ID", referencedColumnName = "ID", nullable = false)
    private Biometric biometric;

}
