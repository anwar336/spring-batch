/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kit.migrator.datamigrator.repository;

import com.kit.migrator.datamigrator.dto.BeneficiaryDto;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author anwar
 */
@Repository
public interface BeneficiaryESRepository extends ElasticsearchRepository<BeneficiaryDto, String> {
    // Custom query methods can be added here
}
