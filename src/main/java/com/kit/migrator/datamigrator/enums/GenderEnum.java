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
public enum GenderEnum {
    MALE,
    FEMALE;

    public static GenderEnum getGender(Integer value) {
        if (value == null) {
            return null;
        }
        for (GenderEnum genderEnum : GenderEnum.values()) {
            if (genderEnum.ordinal() == value) {
                return genderEnum;
            }
        }

        return null;
    }
}
