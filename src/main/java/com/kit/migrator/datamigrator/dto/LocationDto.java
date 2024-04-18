/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kit.migrator.datamigrator.dto;

import java.io.Serializable;

import com.kit.migrator.datamigrator.Utility.Utils;
import com.kit.migrator.datamigrator.model.Location;
import lombok.Data;

/**
 *
 * @author anwar
 */
@Data
public class LocationDto implements Serializable{
    private Double lat;
    private Double lon;

    public LocationDto() {

    }

    public LocationDto(Location location) {
        if (location != null) {
            this.lat = location.getLat();
            this.lon = location.getLon();
        }
    }

    public LocationDto(Object[] esObject) {
        if (esObject != null) {
            if (Utils.indexValueExists(esObject,34)) {
                this.lat = (Double) esObject[34];
            }
            if (Utils.indexValueExists(esObject, 35)) {
                this.lon = (Double) esObject[35];
            }
        }
    }
}
