package com.app.neurorehab.persistence.mapper;

import com.app.neurorehab.controller.model.ContributionControllerModel;
import com.app.neurorehab.persistence.mapper.constants.Mapper;
import com.app.neurorehab.persistence.model.ContributionPersistenceModel;
import com.app.neurorehab.persistence.model.TrainingPersistenceModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ContributionPersistenceMapper implements Mapper<ContributionPersistenceModel,
        ContributionControllerModel> {

    private static final Logger LOG = LoggerFactory.getLogger(ContributionPersistenceMapper.class);

    private TrainingPersistenceMapper trainingPersistenceMapper;

    @Autowired
    public ContributionPersistenceMapper(final TrainingPersistenceMapper trainingPersistenceMapper) {
        this.trainingPersistenceMapper = trainingPersistenceMapper;
    }

    @Override
    public ContributionPersistenceModel mapTo(ContributionControllerModel contributionControllerModel) {

        LOG.debug("Mapping from contribution controller model to persistence model");

        ContributionPersistenceModel contributionPersistenceModel = null;
        if (contributionControllerModel != null) {

            contributionPersistenceModel = new ContributionPersistenceModel();
            contributionPersistenceModel.setReference(contributionControllerModel.getReference());
            contributionPersistenceModel.setTitle(contributionControllerModel.getTitle());
            contributionPersistenceModel.setContribution(contributionControllerModel.getContribution());
            contributionPersistenceModel.setContributionType(contributionControllerModel.getContributionType());
            contributionPersistenceModel.setTrainingArea(contributionControllerModel.getTrainingArea());
            contributionPersistenceModel.setAccepted(false);

            if (contributionControllerModel.getPrecedingContributionReferences() != null) {
                final StringBuilder stringBuilder = new StringBuilder();
                for (final String precedingRef : contributionControllerModel.getPrecedingContributionReferences()) {
                    stringBuilder.append(precedingRef).append(",");
                }
                contributionPersistenceModel.setPrecedingReferences(stringBuilder.toString());
            }

            final TrainingPersistenceModel trainingPersistenceModel = trainingPersistenceMapper.mapTo
                    (contributionControllerModel.getTrainingControllerModel());
            contributionPersistenceModel.setTrainingPersistenceModel(trainingPersistenceModel);
            if (trainingPersistenceModel != null) {
                trainingPersistenceModel.setContributionPersistenceModel(contributionPersistenceModel);
            }
        }

        LOG.debug("Successfully mapped from contribution controller model to persistence model");

        return contributionPersistenceModel;
    }

    @Override
    public ContributionControllerModel mapFrom(ContributionPersistenceModel contributionPersistenceModel) {

        LOG.debug("Mapping from contribution persistence model to controller model");

        ContributionControllerModel contributionControllerModel = null;
        if (contributionPersistenceModel != null) {

            contributionControllerModel = new ContributionControllerModel();
            contributionControllerModel.setContribution(contributionPersistenceModel.getContribution());
            contributionControllerModel.setContributionType(contributionPersistenceModel.getContributionType());

            if (contributionPersistenceModel.getPrecedingReferences() != null) {
                final String[] precedingReferences = contributionPersistenceModel.getPrecedingReferences().split(",");
                contributionControllerModel.setPrecedingContributionReference(precedingReferences);
            }

            contributionControllerModel.setReference(contributionPersistenceModel.getReference());
            contributionControllerModel.setTitle(contributionPersistenceModel.getTitle());
            contributionControllerModel.setTrainingArea(contributionPersistenceModel.getTrainingArea());
            contributionControllerModel.setTrainingControllerModel(trainingPersistenceMapper.mapFrom
                    (contributionPersistenceModel.getTrainingPersistenceModel()));
        }

        LOG.debug("Successfully mapped from contribution controller model to persistence model");

        return contributionControllerModel;
    }
}
