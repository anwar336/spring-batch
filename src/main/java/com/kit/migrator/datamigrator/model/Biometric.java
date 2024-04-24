/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kit.migrator.datamigrator.model;

import com.kit.migrator.datamigrator.enums.BiometricUserType;
import com.kit.migrator.datamigrator.enums.NoFingerprintReason;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author anwar
 */
@Entity
@Table(name = "BIOMETRIIC")
@Data
public class Biometric {
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "applicationId", nullable = false, length = 100)
    private String applicationId;
    
    @Column(name = "BIOMETRIC_USER_TYPE", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private BiometricUserType biometricUserType;

    @Column(name = "NO_FINGER_PRINT")
    private boolean noFingerPrint;

    @Column(name = "NO_FINGER_PRINT_REASON")
    @Enumerated(EnumType.ORDINAL)
    private NoFingerprintReason noFingerprintReason;

    @Column(name = "NO_FINGER_PRINT_REASON_TEXT", length = 255)
    private String noFingerprintReasonText;
    
    @Column(name = "WSQ_LT")
    private String wsqLt;
    
    @Column(name = "WSQ_LI")
    private String wsqLi;
    
    @Column(name = "WSQ_LM")
    private String wsqLm;
    
    @Column(name = "WSQ_LR")
    private String wsqLr;
    
    @Column(name = "WSQ_LS")
    private String wsqLs;
    
    @Column(name = "WSQ_RT")
    private String wsqRt;
    
    @Column(name = "WSQ_RI")
    private String wsqRi;
    
    @Column(name = "WSQ_RM")
    private String wsqRm;
    
    @Column(name = "WSQ_RR")
    private String wsqRr;
    
    @Column(name = "WSQ_RS")
    private String wsqRs;
    
    @Column(name = "PHOTO")
    private String photo;
}
