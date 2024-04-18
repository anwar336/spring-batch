/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kit.migrator.datamigrator.dto;

import java.io.Serializable;

import com.kit.migrator.datamigrator.enums.GenderEnum;
import com.kit.migrator.datamigrator.enums.OccupationEnum;
import com.kit.migrator.datamigrator.enums.RelationshipEnum;
import com.kit.migrator.datamigrator.model.Nominee;
import lombok.Data;
import lombok.ToString;

/**
 *
 * @author anwar
 */
@Data
@ToString
public class NomineeDto implements Serializable {
    private String applicationId;
    private String nomineeFirstName;
    private String nomineeMiddleName;
    private String nomineeLastName;
    private String nomineeNickName;
    private RelationshipEnum relationshipWithHouseholdHead;
    
    private String relationshipOther;
    private Integer nomineeAge;
    private GenderEnum nomineeGender;
    private Boolean isReadWrite;
    private OccupationEnum nomineeOccupation;
    private String otherOccupation;

    public NomineeDto() {
    }

    public NomineeDto(Nominee nominee) {
        if (nominee != null) {
            this.applicationId = nominee.getApplicationId();
            this.nomineeFirstName = nominee.getNomineeFirstName();
            this.nomineeMiddleName = nominee.getNomineeMiddleName();
            this.nomineeLastName = nominee.getNomineeLastName();
            this.nomineeNickName = nominee.getNomineeNickName();
            this.relationshipWithHouseholdHead = nominee.getRelationshipWithHouseholdHead();
            this.relationshipOther = nominee.getRelationshipOther();
            this.nomineeAge = nominee.getNomineeAge();
            this.nomineeGender = nominee.getNomineeGender();
            this.isReadWrite = nominee.getIsReadWrite();
            this.nomineeOccupation = nominee.getNomineeOccupation();
            this.otherOccupation = nominee.getOtherOccupation();
        }
    }
    
}
