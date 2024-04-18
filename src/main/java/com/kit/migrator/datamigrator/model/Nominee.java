package com.kit.migrator.datamigrator.model;
import javax.persistence.*;

import com.kit.migrator.datamigrator.enums.GenderEnum;
import com.kit.migrator.datamigrator.enums.OccupationEnum;
import com.kit.migrator.datamigrator.enums.RelationshipEnum;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name = "NOMINEE")
@Data
public class Nominee implements Serializable {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "applicationId", nullable = false, length = 100)
    private String applicationId;

    @Column(name = "NOMINEE_FIRST_NAME", nullable = false, length = 100)
    private String nomineeFirstName;

    @Column(name = "NOMINEE_MIDDLE_NAME", nullable = false, length = 100)
    private String nomineeMiddleName;

    @Column(name = "NOMINEE_LAST_NAME", nullable = false, length = 100)
    private String nomineeLastName;

    @Column(name = "NOMINEE_NICK_NAME")
    private String nomineeNickName;

    @Column(name = "RELATIONSHIP_WITH_HOUSEHOLD", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private RelationshipEnum relationshipWithHouseholdHead;

    @Column(name = "RELATIONSHIP_OTHER", length = 100)
    private String relationshipOther;

    @Column(name = "NOMINEE_AGE", nullable = false)
    private Integer nomineeAge;

    @Column(name = "NOMINEE_GENDER", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private GenderEnum nomineeGender;

    @Column(name = "IS_READ_WRITE", nullable = false)
    private Boolean isReadWrite;

    @Column(name = "NOMINEE_OCCUPATION", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private OccupationEnum nomineeOccupation;

    @Column(name = "OTHER_OCCUPATION")
    private String otherOccupation;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "BENEFICIARY_ID")
    private Beneficiary beneficiary;
}
