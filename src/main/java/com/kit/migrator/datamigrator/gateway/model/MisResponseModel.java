package com.kit.migrator.datamigrator.gateway.model;

import lombok.Data;
@Data
public class MisResponseModel {
    private Boolean error;
    private Integer errorCode;
    private String errorMessage;
    private Integer returnId;
    private String householdNumber;

}
