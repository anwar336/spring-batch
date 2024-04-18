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
public enum RelationshipEnum {
    HOUSEHOLD_HEAD,
    SPOUSE,
    SON_DAUGHTER,
    SON_DAUGHTER_IN_LAW,
    GRANDCHILD,
    PARENT,
    PARENT_IN_LAW,
    SIBLING,
    SIBLING_IN_LAW,
    OTHER,
    DOMESTIC_WORKER,
    NO_RELATION,
    UNKNOWN;

    public static RelationshipEnum getRelationShip(Integer ordinal) {
        if (ordinal == null) {
            return null;
        }
        for (RelationshipEnum rel : RelationshipEnum.values()) {
            if (rel.ordinal() == ordinal) {
                return rel;
            }
        }
        return null;
    }
}
