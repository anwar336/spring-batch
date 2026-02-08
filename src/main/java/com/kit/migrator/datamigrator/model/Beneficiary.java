package com.kit.migrator.datamigrator.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import com.kit.migrator.datamigrator.enums.*;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


@Entity
@Table(name = "P2_BENEFICIARY")
@NoArgsConstructor
@Data
public class Beneficiary {
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "household_number", nullable = false, length = 36)
    private String applicationId;

    @Column(name = "FIRST_NAME", nullable = false, length = 32)
    private String respondentFirstName;

    @Column(name = "MIDDLE_NAME", nullable = false, length = 32)
    private String respondentMiddleName;

    @Column(name = "LAST_NAME", nullable = false, length = 32)
    private String respondentLastName;

    @Column(name = "NICK_NAME", length = 32)
    private String respondentNickName;

    @Column(name = "FULL_NAME", length = 98, insertable = false, updatable = false)
    private String respondentFullName;

    @Column(name = "AGE", nullable = false)
    private Integer respondentAge;

    @Column(name = "GENDER", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private GenderEnum respondentGender;

    @Column(name = "MARITAL_STATUS", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private MaritalStatusEnum respondentMaritalStatus;

    @Column(name = "LEGAL_STATUS", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private LegalStatusEnum respondentLegalStatus;

    @Column(name = "DOCUMENT_TYPE", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private DocumentTypeEnum documentType;

    @Column(name = "DOC_TYPE_OTHER", length = 100)
    private String documentTypeOther;

    @Column(name = "DOCUMENT_ID", length = 50)
    private String respondentId;

    @Column(name = "PHONE_NO", length = 14)
    private String respondentPhoneNo;

    @Column(name = "SELECTION_CRITERIA", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private SelectionCriteriaEnum selectionCriteria;

    @Column(name = "SELECTION_REASONS", nullable = false)
    private String selectionReasons;

    @Column(name = "CAN_READ_WRITE", nullable = false)
    private Boolean isReadWrite;

    @Column(name = "HAS_MOBILE_WALLET")
    private Integer hasMobileWallet;

    @Column(name = "MOBILE_WALLET_ID")
    private Integer mobileWalletId;

    @Column(name = "MOBILE_WALLET_NUMBER")
    private String mobileWalletNumber;

    @Column(name = "REGISTRATION_PHASE", length = 10)
    @Enumerated(EnumType.ORDINAL)
    private RegistrationPhaseEnum registrationPhase;

    @OneToMany(mappedBy = "beneficiary", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<HouseholdInfo> householdInfos;

    @OneToMany(mappedBy = "beneficiary", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<HouseholdInfoLP> householdInfosLP;


    @OneToMany(mappedBy = "beneficiary", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<Alternate> alternates;

    @OneToMany(mappedBy = "beneficiary", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<Nominee> nominees;

    @OneToOne(mappedBy = "beneficiary", cascade = CascadeType.ALL)
    private Address address;

    @OneToOne(mappedBy = "beneficiary", cascade = CascadeType.ALL)
    private BeneficiaryFamily beneficiaryFamily;

    @Column(name = "STATUS", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private StatusEnum status;

    @Column(name = "AFIS_STATUS", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private AfisStatusEnum afisStatus;

    @Column(name = "ES_SYNC_STATUS")
    private Integer esSyncStatus;

    @Column(name = "REMARK")
    private String remark;
    
    @Column(name = "PAYMENT_METHOD", nullable = false)
    @Enumerated(EnumType.STRING)
    private PaymentMethodEnum paymentMethod;

    @Column(name = "current_subproject_id")
    private Integer currentSubprojectId;

    @Column(name = "id_card_generated")
    private Boolean idCardGenerationStatus;

    @Column(name = "id_card_url", length = 255)
    private String idCardPath;

    @Column(name = "id_card_generated_at")
    private Date idCardGeneratedAt;
    
    @Column(name = "CREATED_AT", nullable = false, updatable = false)
    private Date created;

}
