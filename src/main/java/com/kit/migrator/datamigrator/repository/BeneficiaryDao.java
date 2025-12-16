/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kit.migrator.datamigrator.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

/**
 *
 * @author anwar
 */
@Repository
public class BeneficiaryDao {
    
    @PersistenceContext
    EntityManager em;
    
    @Transactional
    public void updateBeneficiaryEsSyncStatus(String applicationId, Integer status){
        String sql = "update p2_beneficiary set es_sync_status = :status where household_number = :applicationId";
        Query q = em.createNativeQuery(sql);
        q.setParameter("status", status).setParameter("applicationId", applicationId);
        q.executeUpdate();
    }
    
}
