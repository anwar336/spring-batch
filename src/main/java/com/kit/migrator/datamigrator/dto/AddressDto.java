/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kit.migrator.datamigrator.dto;

import java.io.Serializable;

import com.kit.migrator.datamigrator.Utility.Utils;
import com.kit.migrator.datamigrator.model.Address;
import lombok.Data;

/**
 *
 * @author anwar
 */
public class AddressDto implements Serializable{
    private Integer stateId;
    private Integer countyId;
    private Integer payam;
    private String boma;

    public AddressDto() {

    }

    public AddressDto(Address address) {
        this.stateId = address.getStateId();
        this.countyId = address.getCountyId();
        this.payam = address.getPayam();
        this.boma = Utils.isNull(address.getBoma()) ? null : address.getBoma()+"";
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

    public String getBoma() {
        return boma;
    }

    public void setBoma(String boma) {
        this.boma = boma;
    }
}
