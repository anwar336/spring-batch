/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kit.migrator.datamigrator.dto;


import java.io.Serializable;

import com.kit.migrator.datamigrator.Utility.Utils;
import com.kit.migrator.datamigrator.enums.DocumentTypeEnum;
import com.kit.migrator.datamigrator.enums.GenderEnum;
import com.kit.migrator.datamigrator.enums.RelationshipEnum;
import com.kit.migrator.datamigrator.model.Alternate;
import lombok.Data;

/**
 *
 * @author anwar
 */
@Data
public class AlternateDto implements Serializable{
    private String payeeFirstName;
    private String payeeMiddleName;
    private String payeeLastName;
    private String payeeNickName;
    private GenderEnum payeeGender;
    private Integer payeeAge;
    private RelationshipEnum relationshipWithHouseholdHead;
    private String relationshipOther;
    private DocumentTypeEnum documentType;
    private String documentTypeOther;
    private String nationalId;
    private String payeePhoneNo;
    
    private String photoUrl;

    public AlternateDto() {
    }

    public AlternateDto(Alternate alternate) {
        if (alternate != null) {
            this.payeeFirstName = alternate.getPayeeFirstName();

            this.payeeMiddleName = alternate.getPayeeMiddleName();

            this.payeeLastName = alternate.getPayeeLastName();

            this.payeeNickName = alternate.getPayeeNickName();

            this.payeeGender = alternate.getPayeeGender();

            this.payeeAge = alternate.getPayeeAge();

            this.relationshipWithHouseholdHead = alternate.getRelationshipWithHouseholdHead();

            this.relationshipOther = alternate.getRelationshipOther();

            this.documentType = alternate.getDocumentType();

            this.documentTypeOther = alternate.getDocumentTypeOther();

            this.nationalId = alternate.getNationalId();

            this.payeePhoneNo = alternate.getPayeePhoneNo();

        }
    }

    public AlternateDto(Object[] esObject, int start) {
        if (esObject != null) {
            if (Utils.indexValueExists(esObject, start)) {
                this.nationalId = (String) esObject[start];
            }
            start++;
            if (Utils.indexValueExists(esObject, start)) {
                this.payeeAge = Utils.getIntegerFromObject(esObject[start]);
            }
            start++;
            if (Utils.indexValueExists(esObject, start)) {
                Integer gender = Utils.getIntegerFromObject(esObject[start]);
                this.payeeGender = GenderEnum.getGender(gender);
            }
            start++;
            if (Utils.indexValueExists(esObject, start)) {
                this.payeeFirstName = (String) esObject[start];
            }
            start++;
            if (Utils.indexValueExists(esObject, start)) {
                this.payeePhoneNo = (String) esObject[start];
            }
            start++;
            start++;
            if (Utils.indexValueExists(esObject, start)) {
                this.payeeMiddleName = (String) esObject[start];
            }
            start++;
            if (Utils.indexValueExists(esObject, start)) {
                this.payeeNickName = (String) esObject[start];
            }
            start++;
            if (Utils.indexValueExists(esObject, start)) {
                this.payeeLastName = (String) esObject[start];
            }
            start++;
            if (Utils.indexValueExists(esObject, start)) {
                this.documentTypeOther = (String) esObject[start];
            }
            start++;
            if (Utils.indexValueExists(esObject, start)) {
                Integer docType = Utils.getIntegerFromObject(esObject[start]);
                this.documentType = DocumentTypeEnum.getDocType(docType);
            }
            start++;
            if (Utils.indexValueExists(esObject, start)) {
                Integer relType = Utils.getIntegerFromObject(esObject[start]);
                this.relationshipWithHouseholdHead = RelationshipEnum.getRelationShip(relType);
            }
            start++;
            if (Utils.indexValueExists(esObject, start)) {
                this.relationshipOther = (String) esObject[start];
            }
        }
    }

}
