package com.kit.migrator.datamigrator.model;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "HOUSEHOLD_INFO")
@Data
public class HouseholdInfo {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "applicationId", nullable = false, length = 100)
    private String applicationId;

    @Column(name = "MALE_NORMAL")
    private Integer maleTotal;

    @Column(name = "MALE_BOTH")
    private Integer maleBoth;

    @Column(name = "MALE_DISABLE")
    private Integer maleDisable;

    @Column(name = "MALE_CHORINAL_ILL")
    private Integer maleChronicalIll;

    @Column(name = "FEMALE_NORMAL")
    private Integer femaleTotal;

    @Column(name = "FEMALE_BOTH")
    private Integer femaleBoth;

    @Column(name = "FEMALE_DISABLE")
    private Integer femaleDisable;

    @Column(name = "FEMALE_CHORINAL_ILL")
    private Integer femaleChronicalIll;
}
