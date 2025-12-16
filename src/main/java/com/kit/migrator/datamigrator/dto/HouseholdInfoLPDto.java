/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kit.migrator.datamigrator.dto;

import com.kit.migrator.datamigrator.model.HouseholdInfoLP;
import lombok.Data;

/**
 *
 * @author anwar
 */
@Data
public class HouseholdInfoLPDto {
    
    private String applicationId;
    private Integer femaleTotal;
    private Integer femaleChronicalIll;
    private Integer femaleDisable;
    private Integer femaleBoth;

    public HouseholdInfoLPDto() {
    }

    public HouseholdInfoLPDto(HouseholdInfoLPDto source, String applicationId) {
        if (source != null) {
            this.applicationId = applicationId;
            this.femaleTotal = source.getFemaleTotal();
            this.femaleChronicalIll = source.getFemaleChronicalIll();
            this.femaleDisable = source.getFemaleDisable();
            this.femaleBoth = source.getFemaleBoth();
        }
    }

    public HouseholdInfoLPDto(HouseholdInfoLP householdInfo, String applicationId) {
        if (householdInfo != null) {
            this.applicationId = applicationId;
            this.femaleTotal = householdInfo.getFemaleTotal();
            this.femaleChronicalIll = householdInfo.getFemaleChronicalIll();
            this.femaleDisable = householdInfo.getFemaleDisable();
            this.femaleBoth = householdInfo.getFemaleBoth();
        }
    }

}
