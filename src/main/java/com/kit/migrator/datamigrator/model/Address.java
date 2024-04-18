package com.kit.migrator.datamigrator.model;

import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "ADDRESS")
@Data
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

}
