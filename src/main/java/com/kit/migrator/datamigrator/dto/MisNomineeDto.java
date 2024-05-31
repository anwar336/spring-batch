/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kit.migrator.datamigrator.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.ToString;

/**
 *
 * @author anwar
 */
@Data
@ToString
public class MisNomineeDto implements Serializable {
    private String applicationId;
    private String nomineeFirstName;
    private String nomineeMiddleName;
    private String nomineeLastName;
    private String nomineeNickName;
    private Integer relationshipWithHouseholdHead;
    
    private String relationshipOther;
    private Integer nomineeAge;
    private Integer nomineeGender;
    private Integer isReadWrite;
    private Integer nomineeOccupation;
    private String otherOccupation;

    public MisNomineeDto() {
    }

    public MisNomineeDto(NomineeDto nominee) {
        if (nominee != null) {
            this.applicationId = nominee.getApplicationId();
            this.nomineeFirstName = nominee.getNomineeFirstName();
            this.nomineeMiddleName = nominee.getNomineeMiddleName();
            this.nomineeLastName = nominee.getNomineeLastName();
            this.nomineeNickName = nominee.getNomineeNickName();
            if(nominee.getRelationshipWithHouseholdHead() != null){
                this.relationshipWithHouseholdHead = nominee.getRelationshipWithHouseholdHead().ordinal();
            }
            this.relationshipOther = nominee.getRelationshipOther();
            this.nomineeAge = nominee.getNomineeAge();
            if(nominee.getNomineeGender() != null){
                this.nomineeGender = nominee.getNomineeGender().ordinal();
            }
            if(nominee.getIsReadWrite() != null && nominee.getIsReadWrite() == true){
                this.isReadWrite = 1;
            }
            else{
                this.isReadWrite = 0;
            }
            if(nominee.getNomineeOccupation() != null){
                this.nomineeOccupation = nominee.getNomineeOccupation().ordinal();
            }
            this.otherOccupation = nominee.getOtherOccupation();
        }
    }
    
}
