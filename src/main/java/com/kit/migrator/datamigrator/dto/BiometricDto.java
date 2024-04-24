/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kit.migrator.datamigrator.dto;

import com.kit.migrator.datamigrator.enums.BiometricType;
import com.kit.migrator.datamigrator.enums.BiometricUserType;
import com.kit.migrator.datamigrator.enums.NoFingerprintReason;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author anwar
 */
@Data
public class BiometricDto implements Serializable{
    
    
    private String applicationId;
    
    
    private BiometricType biometricType;
    
    
    private BiometricUserType biometricUserType;

    private boolean noFingerPrint;

    private NoFingerprintReason noFingerprintReason;

    private String noFingerprintReasonText;

    private String biometricUrl;
    
    private byte[] biometricData;
}
