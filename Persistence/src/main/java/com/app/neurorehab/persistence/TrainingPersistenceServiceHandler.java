package com.app.neurorehab.persistence;

import com.app.neurorehab.domain.model.DataTypes.TrainingArea;
import com.app.neurorehab.persistence.repository.TrainingRepository;
import com.app.neurorehab.persistence.model.TrainingPersistenceModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class TrainingPersistenceServiceHandler implements TrainingPersistenceService {

    private static final Logger LOG = LoggerFactory.getLogger(TrainingPersistenceService.class);

    private TrainingRepository trainingRepository;

    @Autowired
    public TrainingPersistenceServiceHandler(final TrainingRepository trainingRepository) {

        this.trainingRepository = trainingRepository;
    }

    @Override
    public TrainingPersistenceModel getTrainingByReference(String reference) {

        LOG.debug("Getting training by reference: {}", reference);

        final TrainingPersistenceModel trainingPersistenceModel = trainingRepository.findByReference(reference);

        LOG.debug("Successfully found training: {}", trainingPersistenceModel);

        return trainingPersistenceModel;
    }

    @Override
    public Set<TrainingPersistenceModel> getTrainingWithin(TrainingArea trainingArea) {

        LOG.debug("Getting training by area: {}", trainingArea);

        final Set<TrainingPersistenceModel> trainingPersistenceModels = trainingRepository.findByTrainingArea
                (trainingArea.getValue());

        LOG.debug("Successfully found training: {}", trainingPersistenceModels);

        return trainingPersistenceModels;
    }
}
