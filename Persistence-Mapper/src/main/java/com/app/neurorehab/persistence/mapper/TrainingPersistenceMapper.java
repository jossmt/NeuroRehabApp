package com.app.neurorehab.persistence.mapper;

import com.app.neurorehab.controller.model.TrainingControllerModel;
import com.app.neurorehab.persistence.mapper.constants.Mapper;
import com.app.neurorehab.persistence.model.TrainingPersistenceModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class TrainingPersistenceMapper implements Mapper<TrainingPersistenceModel, TrainingControllerModel> {

    private static final Logger LOG = LoggerFactory.getLogger(TrainingPersistenceMapper.class);

    @Override
    public TrainingPersistenceModel mapTo(TrainingControllerModel trainingControllerModel) {

        LOG.debug("Mapping from training controller model to persistence model");

        TrainingPersistenceModel trainingPersistenceModel = null;
        if(trainingControllerModel != null){

            trainingPersistenceModel = new TrainingPersistenceModel();
            trainingPersistenceModel.setReference(trainingControllerModel.getReference());
            trainingPersistenceModel.setTitle(trainingControllerModel.getTitle());
            trainingPersistenceModel.setDescription(trainingControllerModel.getDescription());
            trainingPersistenceModel.setRating(trainingControllerModel.getRating());
            trainingPersistenceModel.setCreationDate(trainingControllerModel.getCreationDate());
            trainingPersistenceModel.setTrainingArea(trainingControllerModel.getTrainingArea());
            trainingPersistenceModel.setAccepted(false);
        }

        LOG.debug("Successfully mapped from training controller model to persistence model");

        return trainingPersistenceModel;
    }

    @Override
    public TrainingControllerModel mapFrom(TrainingPersistenceModel trainingPersistenceModel) {

        LOG.debug("Mapping from training persistence model to controller model");

        TrainingControllerModel trainingControllerModel = null;
        if(trainingPersistenceModel != null){

            trainingControllerModel = new TrainingControllerModel();
            trainingControllerModel.setTitle(trainingPersistenceModel.getTitle());
            trainingControllerModel.setDescription(trainingPersistenceModel.getDescription());
            trainingControllerModel.setRating(trainingPersistenceModel.getRating());
            trainingControllerModel.setCreationDate(trainingPersistenceModel.getCreationDate());
            trainingControllerModel.setReference(trainingPersistenceModel.getReference());
            trainingControllerModel.setTrainingArea(trainingPersistenceModel.getTrainingArea());

        }

        LOG.debug("Successfully mapped from training persistence model to controller model");

        return trainingControllerModel;
    }
}
