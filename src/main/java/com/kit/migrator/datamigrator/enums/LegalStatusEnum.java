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
public enum LegalStatusEnum {
    HOST,
    RETURNEE,
    REFUGEE,
    IDP;

    public static LegalStatusEnum getLegalStatus(Integer ordinal) {
        if (ordinal == null) {
            return null;
        }

        for (LegalStatusEnum en : LegalStatusEnum.values()) {
            if (en.ordinal() == ordinal) {
                return en;
            }
        }
        return null;
    }
}
