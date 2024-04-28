package com.kit.migrator.datamigrator.repository;

import com.kit.migrator.datamigrator.model.Beneficiary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface BeneficiaryRepository extends PagingAndSortingRepository<Beneficiary, Long> {
    Page<Beneficiary> findBeneficiaryByCreatedBetweenAndMisSyncStatus(Date fromDate, Date toDate, Integer misSyncStatus, Pageable pageable);
    Page<Beneficiary> findBeneficiaryByCreatedBetween(Date fromDate, Date toDate, Pageable pageable);
    Page<Beneficiary> findBeneficiaryByApplicationId(String applicationId, Pageable pageable);
}
