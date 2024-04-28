/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kit.migrator.datamigrator.config;

import com.istl.afis.manager.AfisEnroll;
import com.istl.afis.manager.AfisIdentification;
import com.istl.afis.manager.AfisManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author anwar
 */
//@Configuration
public class AfisConfig {
    
    @Value(value = "${afis.db.connection}")
    private String dbConn;
    
    @Bean(initMethod = "init")
    public AfisManager getAfisManager() throws Exception{
        return AfisManager.getInstance(dbConn, false);
    }
    
    @Bean
    public AfisEnroll afisEnroll() throws Exception{
        return AfisEnroll.getInstance(getAfisManager());
    }
    
    @Bean
    public AfisIdentification afisIdentification() throws Exception{
        return AfisIdentification.getInstance(getAfisManager());
    }
    
}
