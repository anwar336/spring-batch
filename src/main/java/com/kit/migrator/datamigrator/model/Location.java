package com.kit.migrator.datamigrator.model;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "LOCATION")
@Data
public class Location {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "LAT")
    private Double lat;

    @Column(name = "LON")
    private Double lon;
}
