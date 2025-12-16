/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kit.migrator.datamigrator.model;

import javax.persistence.*;
import lombok.Data;

/**
 *
 * @author anwar
 */
@Entity
@Table(name = "P2_BENEFICIARY_HOUSEHOLD_LP")
@Data
public class HouseholdInfoLP {
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "AGE_RANGE", nullable = false)
    private Integer ageRange;


    @Column(name = "FEMALE_NORMAL")
    private Integer femaleTotal;

    @Column(name = "FEMALE_BOTH")
    private Integer femaleBoth;

    @Column(name = "FEMALE_DISABLED")
    private Integer femaleDisable;

    @Column(name = "FEMALE_CHRONICALLY_ILL")
    private Integer femaleChronicalIll;

    @Column(name = "MINIMUM_AGE", nullable = false)
    private Integer minimumAge;

    @Column(name = "MAXIMUM_AGE", nullable = false)
    private Integer maximumAge;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "BENEFICIARY_ID")
    private Beneficiary beneficiary;
}
