/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kit.migrator.datamigrator.enums;

import java.util.Arrays;

/**
 *
 * @author anwar
 */
public enum SelectionCriteriaEnum {
    LIPW,
    DIS;

    public static SelectionCriteriaEnum getSelectionCriteria(Integer ordinal) {
        if (ordinal == null) {
            return null;
        }
        return Arrays.stream(SelectionCriteriaEnum.values()).filter(val-> val.ordinal() == ordinal).findFirst().get();
    }
}
