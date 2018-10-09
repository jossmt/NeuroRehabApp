package com.app.neurorehab.persistence;

import com.app.neurorehab.domain.model.DataTypes.TrainingArea;
import com.app.neurorehab.persistence.model.TrainingPersistenceModel;

import java.util.List;
import java.util.Set;

public interface TrainingPersistenceService {

    TrainingPersistenceModel getTrainingByReference(String reference);

    Set<TrainingPersistenceModel> getTrainingWithin(TrainingArea trainingArea);
}
