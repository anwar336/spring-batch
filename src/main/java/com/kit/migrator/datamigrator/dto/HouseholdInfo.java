/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kit.migrator.datamigrator.dto;

import java.io.Serializable;

import com.kit.migrator.datamigrator.Utility.Utils;
import lombok.Data;

/**
 *
 * @author anwar
 */
@Data
public class HouseholdInfo implements Serializable{
    private String applicationId;
    private Integer maleTotal;
    private Integer maleBoth;
    private Integer maleDisable;
    private Integer maleChronicalIll;
    private Integer femaleTotal;
    private Integer femaleBoth;
    private Integer femaleDisable;
    private Integer femaleChronicalIll;

    public HouseholdInfo() {
    }

    public HouseholdInfo(com.kit.migrator.datamigrator.model.HouseholdInfo householdInfo) {
        if (householdInfo != null) {
            this.applicationId = householdInfo.getApplicationId();
            this.maleTotal = householdInfo.getMaleTotal();
            this.maleBoth = householdInfo.getMaleBoth();
            this.maleDisable = householdInfo.getMaleDisable();
            this.maleChronicalIll = householdInfo.getMaleChronicalIll();
            this.femaleTotal = householdInfo.getFemaleTotal();
            this.femaleBoth = householdInfo.getFemaleBoth();
            this.femaleDisable = householdInfo.getFemaleDisable();
            this.femaleChronicalIll =  householdInfo.getFemaleChronicalIll();
        }
    }

    public HouseholdInfo(Object[] esObject, int start) {
        if (esObject != null) {
            if (Utils.indexValueExists(esObject, start)) {
                this.femaleChronicalIll = Utils.getIntegerFromObject(esObject[start]);
            }
            start++;
            if (Utils.indexValueExists(esObject, start)) {
                this.femaleDisable = Utils.getIntegerFromObject(esObject[start]);
            }
            start++;
            if (Utils.indexValueExists(esObject, start)) {
                this.femaleTotal = Utils.getIntegerFromObject(esObject[start]);
            }
            start++;
            if (Utils.indexValueExists(esObject, start)) {
                this.maleChronicalIll = Utils.getIntegerFromObject(esObject[start]);
            }
            start++;
            if (Utils.indexValueExists(esObject, start)) {
                this.maleDisable = Utils.getIntegerFromObject(esObject[start]);
            }
            start++;
            if (Utils.indexValueExists(esObject, start)) {
                this.maleTotal = Utils.getIntegerFromObject(esObject[start]);
            }
            start++;
            if (Utils.indexValueExists(esObject, start)) {
                this.maleTotal = Utils.getIntegerFromObject(esObject[start]);
            }
            start++;
            if (Utils.indexValueExists(esObject, start)) {
                this.femaleBoth = Utils.getIntegerFromObject(esObject[start]);
            }
            start++;
            if (Utils.indexValueExists(esObject, start)) {
                this.maleBoth = Utils.getIntegerFromObject(esObject[start]);
            }
        }
    }

}
