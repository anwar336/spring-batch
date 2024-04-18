package com.kit.migrator.datamigrator.model;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "HOUSEHOLD_INFO")
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public Integer getMaleTotal() {
        return maleTotal;
    }

    public void setMaleTotal(Integer maleTotal) {
        this.maleTotal = maleTotal;
    }

    public Integer getMaleBoth() {
        return maleBoth;
    }

    public void setMaleBoth(Integer maleBoth) {
        this.maleBoth = maleBoth;
    }

    public Integer getMaleDisable() {
        return maleDisable;
    }

    public void setMaleDisable(Integer maleDisable) {
        this.maleDisable = maleDisable;
    }

    public Integer getMaleChronicalIll() {
        return maleChronicalIll;
    }

    public void setMaleChronicalIll(Integer maleChronicalIll) {
        this.maleChronicalIll = maleChronicalIll;
    }

    public Integer getFemaleTotal() {
        return femaleTotal;
    }

    public void setFemaleTotal(Integer femaleTotal) {
        this.femaleTotal = femaleTotal;
    }

    public Integer getFemaleBoth() {
        return femaleBoth;
    }

    public void setFemaleBoth(Integer femaleBoth) {
        this.femaleBoth = femaleBoth;
    }

    public Integer getFemaleDisable() {
        return femaleDisable;
    }

    public void setFemaleDisable(Integer femaleDisable) {
        this.femaleDisable = femaleDisable;
    }

    public Integer getFemaleChronicalIll() {
        return femaleChronicalIll;
    }

    public void setFemaleChronicalIll(Integer femaleChronicalIll) {
        this.femaleChronicalIll = femaleChronicalIll;
    }
}
