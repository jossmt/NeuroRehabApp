package com.app.neurorehab.persistence.mapper;

import com.app.neurorehab.controller.model.TrainingResultsControllerModel;
import com.app.neurorehab.persistence.mapper.constants.Mapper;
import com.app.neurorehab.persistence.model.TrainingResultsPersistenceModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TrainingResultsPersistenceMapper implements Mapper<TrainingResultsPersistenceModel,
        TrainingResultsControllerModel> {

    private static final Logger LOG = LoggerFactory.getLogger(TrainingResultsPersistenceMapper.class);

    @Override
    public TrainingResultsPersistenceModel mapTo(TrainingResultsControllerModel trainingResultsControllerModel) {

        LOG.debug("Mapping from training results controller model to persistence model");

        TrainingResultsPersistenceModel trainingResultsPersistenceModel = null;
        if (trainingResultsControllerModel != null) {

            trainingResultsPersistenceModel = new TrainingResultsPersistenceModel();
            trainingResultsPersistenceModel.setResults(trainingResultsControllerModel.getResults());

        }

        LOG.debug("Successfully mapped from training results controller model to persistence model");

        return trainingResultsPersistenceModel;
    }

    @Override
    public TrainingResultsControllerModel mapFrom(TrainingResultsPersistenceModel trainingResultsPersistenceModel) {

        LOG.debug("Mapping from training results persistence model to controller model");

        TrainingResultsControllerModel trainingResultsControllerModel = null;
        if (trainingResultsPersistenceModel != null) {

            trainingResultsControllerModel = new TrainingResultsControllerModel();
            trainingResultsControllerModel.setResults(trainingResultsPersistenceModel.getResults());
        }

        LOG.debug("Sucessfully mapped from training results persistence model to controller model");

        return trainingResultsControllerModel;
    }
}
