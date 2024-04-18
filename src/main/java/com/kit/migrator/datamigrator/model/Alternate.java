package com.kit.migrator.datamigrator.model;
import javax.persistence.*;

import com.kit.migrator.datamigrator.enums.DocumentTypeEnum;
import com.kit.migrator.datamigrator.enums.GenderEnum;
import com.kit.migrator.datamigrator.enums.RelationshipEnum;
import lombok.Data;

@Entity
@Table(name = "ALTERNATE")
@Data
public class Alternate {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "PAYEE_FIRST_NAME", length = 100, nullable = false)
    private String payeeFirstName;

    @Column(name = "PAYEE_MIDDLE_NAME", nullable = false, length = 100)
    private String payeeMiddleName;

    @Column(name = "PAYEE_LAST_NAME", length = 100, nullable = false)
    private String payeeLastName;

    @Column(name = "PAYEE_NICK_NAME", length = 100)
    private String payeeNickName;

    @Column(name = "PAYEE_GENDER", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private GenderEnum payeeGender;

    @Column(name = "PAYEE_AGE", nullable = false)
    private Integer payeeAge;

    @Column(name = "DOCUMENT_TYPE", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private DocumentTypeEnum documentType;

    @Column(name = "DOCUMENT_TYPE_OTHER", length = 100)
    private String documentTypeOther;

    @Column(name = "RELATIONSHIP_WITH_HOUSEHOLD", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private RelationshipEnum relationshipWithHouseholdHead;

    @Column(name = "RELATIONSHIP_OTHER", length = 100)
    private String relationshipOther;

    @Column(name = "NATIONAL_ID", length = 50)
    private String nationalId;

    @Column(name = "PAYEE_PHONE_NO", length = 10)
    private String payeePhoneNo;
}
