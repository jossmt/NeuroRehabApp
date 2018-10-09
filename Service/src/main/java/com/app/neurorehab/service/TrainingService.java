package com.app.neurorehab.service;

import com.app.neurorehab.controller.model.TrainingControllerModel;
import com.app.neurorehab.domain.model.DataTypes.TrainingArea;
import com.app.neurorehab.persistence.TrainingPersistenceService;
import com.app.neurorehab.persistence.mapper.constants.SetMapper;
import com.app.neurorehab.persistence.mapper.TrainingPersistenceMapper;
import com.app.neurorehab.persistence.model.TrainingPersistenceModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Handler for training related services.
 */
@Service
public class TrainingService {

    private static final Logger LOG = LoggerFactory.getLogger(TrainingService.class);

    private SetMapper setMapper;
    private TrainingPersistenceService trainingPersistenceService;
    private TrainingPersistenceMapper trainingPersistenceMapper;

    @Autowired
    public TrainingService(final TrainingPersistenceService trainingPersistenceService,
                           final TrainingPersistenceMapper trainingPersistenceMapper) {

        this.trainingPersistenceService = trainingPersistenceService;
        this.trainingPersistenceMapper = trainingPersistenceMapper;

        setMapper = new SetMapper();
    }

    public Set<TrainingControllerModel> getTrainingData(final TrainingArea trainingArea) {

        LOG.debug("Finding training by area: {}", trainingArea);

        final Set<TrainingPersistenceModel> trainingPersistenceModels = trainingPersistenceService.getTrainingWithin
                (trainingArea);

        final Set<TrainingControllerModel> trainingControllerModels = setMapper.mapSet(trainingPersistenceMapper,
                                                                                        false,
                                                                                        trainingPersistenceModels);

        LOG.debug("Returning training found");
        return trainingControllerModels;
    }

    public TrainingControllerModel getTrainingData(final String reference) {

        LOG.debug("Finding training by reference: {}", reference);

        final TrainingPersistenceModel trainingPersistenceModel = trainingPersistenceService.getTrainingByReference
                (reference);

        final TrainingControllerModel trainingControllerModel = trainingPersistenceMapper.mapFrom
                (trainingPersistenceModel);

        LOG.debug("Returning training: {}", trainingControllerModel);

        return trainingControllerModel;
    }
}
