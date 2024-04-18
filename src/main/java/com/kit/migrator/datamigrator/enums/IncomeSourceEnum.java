/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kit.migrator.datamigrator.enums;

/**
 *
 * @author anwar
 */
public enum IncomeSourceEnum {
    NONE,
    SELLING_OF_FARM,
    SELLING_OF_NON_FARM,
    CAUSAL_LABOUR,
    FORMAL_EMPLOYMENT,
    REMITTANCES,
    GIFT,
    FROM_GOVT,
    FROM_NGO,
    PENSION,
    OTHER;

    public static IncomeSourceEnum getIncomeSource(Integer ordinal) {
        if (ordinal == null) {
            return null;
        }
        for (IncomeSourceEnum en : IncomeSourceEnum.values()) {
            if (en.ordinal() == ordinal) {
                return en;
            }
        }
        return null;
    }
}
