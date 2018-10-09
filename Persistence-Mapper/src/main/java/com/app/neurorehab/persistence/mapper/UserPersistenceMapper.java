package com.app.neurorehab.persistence.mapper;

import com.app.neurorehab.controller.model.UserControllerModel;
import com.app.neurorehab.persistence.mapper.constants.Mapper;
import com.app.neurorehab.persistence.mapper.constants.SetMapper;
import com.app.neurorehab.persistence.model.UserPersistenceModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserPersistenceMapper implements Mapper<UserPersistenceModel, UserControllerModel> {

    private static final Logger LOG = LoggerFactory.getLogger(UserPersistenceMapper.class);

    private ProfilePersistenceMapper profilePersistenceMapper;
    private TrainingResultsPersistenceMapper trainingResultsPersistenceMapper;
    private ContributionPersistenceMapper contributionPersistenceMapper;
    private SetMapper setMapper;

    @Autowired
    public UserPersistenceMapper(final ProfilePersistenceMapper profilePersistenceMapper,
                                 final TrainingResultsPersistenceMapper trainingResultsPersistenceMapper,
                                 final ContributionPersistenceMapper contributionPersistenceMapper) {

        this.profilePersistenceMapper = profilePersistenceMapper;
        this.trainingResultsPersistenceMapper = trainingResultsPersistenceMapper;
        this.contributionPersistenceMapper = contributionPersistenceMapper;
        setMapper = new SetMapper();
    }

    @Override
    public UserPersistenceModel mapTo(final UserControllerModel userControllerModel) {

        LOG.debug("Mapping from user controller model to persistence model");

        UserPersistenceModel userPersistenceModel = null;
        if (userControllerModel != null) {

            userPersistenceModel = new UserPersistenceModel();
            userPersistenceModel.setFname(userControllerModel.getFname());
            userPersistenceModel.setLname(userControllerModel.getLname());
            userPersistenceModel.setEmail(userControllerModel.getEmail());
            userPersistenceModel.setUserReference(userControllerModel.getUserReference());

            userPersistenceModel.setTrainingResultsPersistenceModels(setMapper.mapSet
                    (trainingResultsPersistenceMapper, true, userControllerModel.getTrainingResultsControllerModels()));
            userPersistenceModel.setContributionPersistenceModels(setMapper.mapSet
                    (contributionPersistenceMapper, true, userControllerModel.getContributionControllerModels()));
            userPersistenceModel.setProfilePersistenceModel(profilePersistenceMapper.mapTo(userControllerModel
                                                                                                   .getProfileControllerModel()));
        }

        LOG.debug("Successfully mapped from user controller model to persistence model");

        return userPersistenceModel;
    }

    @Override
    public UserControllerModel mapFrom(final UserPersistenceModel userPersistenceModel) {

        LOG.debug("Mapping from user persistence model to controller model");

        UserControllerModel userControllerModel = null;
        if (userPersistenceModel != null) {

            userControllerModel = new UserControllerModel();

            userControllerModel.setFname(userPersistenceModel.getFname());
            userControllerModel.setLname(userPersistenceModel.getLname());
            userControllerModel.setEmail(userPersistenceModel.getEmail());
            userControllerModel.setUserReference(userPersistenceModel.getUserReference());

            userControllerModel.setContributionControllerModels(setMapper.mapSet(
                    contributionPersistenceMapper, false, userPersistenceModel.getContributionPersistenceModels()));
            userControllerModel.setTrainingResultsControllerModels(setMapper.mapSet(
                    trainingResultsPersistenceMapper, false,
                    userPersistenceModel.getTrainingResultsPersistenceModels()));
            userControllerModel.setProfileControllerModel(profilePersistenceMapper.mapFrom(
                    userPersistenceModel.getProfilePersistenceModel()));


        }

        LOG.debug("Successfully mapped from user persistence model to controller model");

        return userControllerModel;
    }
}
