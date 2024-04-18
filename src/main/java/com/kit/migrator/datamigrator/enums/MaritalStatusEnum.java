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
public enum MaritalStatusEnum {
    SINGLE,
    MARRIED,
    WIDOW,
    SEPARATED,
    DIVORCE;

    public static MaritalStatusEnum getMaritalStatus(Integer ordinal) {
        if (ordinal == null) {
            return null;
        }
        for (MaritalStatusEnum en : MaritalStatusEnum.values()) {
            if (en.ordinal() == ordinal) {
                return en;
            }
        }
        return null;
    }
}
