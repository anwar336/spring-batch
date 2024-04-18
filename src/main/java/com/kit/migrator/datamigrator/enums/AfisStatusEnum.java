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
public enum AfisStatusEnum {
    PENDING,
    ENROLLED,
    MATCHED,
    COMPLETED,
    REJECTED,
    DUPLICATE_ID,
    BAD_OBJECT,
    ERROR;

    public static AfisStatusEnum getAfisStatus(Integer ordinal) {
        if (ordinal == null) {
            return null;
        }
        for (AfisStatusEnum en : AfisStatusEnum.values()) {
            if (en.ordinal() == ordinal) {
                return en;
            }
        }
        return null;
    }
}
