package com.kit.migrator.datamigrator.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "P2_BENEFICIARY_ADDRESS")
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

    @Column(name = "LATITUDE")
    private Double lat;

    @Column(name = "LONGITUDE")
    private Double lon;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "BENEFICIARY_ID")
    @JsonIgnore
    private Beneficiary beneficiary;

}
