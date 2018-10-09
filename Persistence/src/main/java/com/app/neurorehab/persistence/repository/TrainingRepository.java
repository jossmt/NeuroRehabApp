package com.app.neurorehab.persistence.repository;

import com.app.neurorehab.domain.model.DataTypes.TrainingArea;
import com.app.neurorehab.persistence.model.TrainingPersistenceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
@Component
public interface TrainingRepository extends CrudRepository<TrainingPersistenceModel, Long> {

    @Query(value = "SELECT * FROM Training", nativeQuery = true)
    Set<TrainingPersistenceModel> findAllAsSet();

    @Query(value = "SELECT * FROM Training WHERE Training.training_area = :trainingArea", nativeQuery = true)
    Set<TrainingPersistenceModel> findByTrainingArea(@Param(value = "trainingArea") final String trainingArea);

    @Query(value = "SELECT * FROM Training WHERE Training.reference = :reference", nativeQuery = true)
    TrainingPersistenceModel findByReference(@Param(value = "reference") final String reference);

}
