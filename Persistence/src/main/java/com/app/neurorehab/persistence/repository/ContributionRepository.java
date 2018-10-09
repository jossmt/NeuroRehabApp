package com.app.neurorehab.persistence.repository;

import com.app.neurorehab.persistence.model.ContributionPersistenceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Repository
@Component
public interface ContributionRepository extends CrudRepository<ContributionPersistenceModel, Long> {

    @Transactional
    @Query(value = "SELECT * FROM Contribution", nativeQuery = true)
    Set<ContributionPersistenceModel> findAllAsSet();

    @Query(value = "SELECT * FROM Contribution WHERE Contribution.reference =:reference", nativeQuery = true)
    ContributionPersistenceModel findByReference(@Param(value="reference") final String reference);

    @Transactional
    @Query(value = "SELECT * FROM Contribution WHERE Contribution.accepted =:accepted", nativeQuery = true)
    Set<ContributionPersistenceModel> findAllByAcceptance(@Param(value="accepted") final Boolean accepted);
}
