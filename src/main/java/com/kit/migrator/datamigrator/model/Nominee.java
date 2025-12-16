package com.kit.migrator.datamigrator.model;
import javax.persistence.*;

import com.kit.migrator.datamigrator.enums.GenderEnum;
import com.kit.migrator.datamigrator.enums.NomineePopupResponse;
import com.kit.migrator.datamigrator.enums.OccupationEnum;
import com.kit.migrator.datamigrator.enums.RelationshipEnum;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name = "P2_BENEFICIARY_NOMINEE")
@Data
public class Nominee implements Serializable {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nominee_index")
    private Integer nomineeIndex;

    @Column(name = "FIRST_NAME", nullable = false, length = 32)
    private String nomineeFirstName;

    @Column(name = "MIDDLE_NAME", nullable = false, length = 32)
    private String nomineeMiddleName;

    @Column(name = "LAST_NAME", nullable = false, length = 32)
    private String nomineeLastName;

    @Column(name = "NICK_NAME")
    private String nomineeNickName;

    @Column(name = "RELATIONSHIP_WITH_HOUSEHOLD", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private RelationshipEnum relationshipWithHouseholdHead;

    @Column(name = "RELATIONSHIP_OTHER", length = 100)
    private String relationshipOther;

    @Column(name = "AGE", nullable = false)
    private Integer nomineeAge;

    @Column(name = "POPUP_RESPONSE", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private NomineePopupResponse nomineePopupResponse;

    @Column(name = "GENDER", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private GenderEnum nomineeGender;

    @Column(name = "CAN_READ_WRITE", nullable = false)
    private Boolean isReadWrite;

    @Column(name = "OCCUPATION", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private OccupationEnum nomineeOccupation;

    @Column(name = "OTHER_OCCUPATION")
    private String otherOccupation;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "BENEFICIARY_ID")
    private Beneficiary beneficiary;
}
