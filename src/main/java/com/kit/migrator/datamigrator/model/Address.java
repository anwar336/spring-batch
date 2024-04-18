package com.kit.migrator.datamigrator.model;

import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "ADDRESS")
public class Address {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "STATE_ID", nullable = false)
    private Integer stateId;

    @Column(name = "COUNTY_ID", nullable = false)
    private Integer countyId;

    @Column(name = "PAYAM_ID", nullable = false)
    private Integer payam;

    @Column(name = "BOMA_ID", nullable = false)
    private Long boma;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public Integer getCountyId() {
        return countyId;
    }

    public void setCountyId(Integer countyId) {
        this.countyId = countyId;
    }

    public Integer getPayam() {
        return payam;
    }

    public void setPayam(Integer payam) {
        this.payam = payam;
    }

    public Long getBoma() {
        return boma;
    }

    public void setBoma(Long boma) {
        this.boma = boma;
    }
}
