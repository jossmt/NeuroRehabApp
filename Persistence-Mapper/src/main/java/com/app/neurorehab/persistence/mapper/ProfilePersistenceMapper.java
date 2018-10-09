package com.app.neurorehab.persistence.mapper;

import com.app.neurorehab.controller.model.ProfileControllerModel;
import com.app.neurorehab.persistence.mapper.constants.Mapper;
import com.app.neurorehab.persistence.model.ProfilePersistenceModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ProfilePersistenceMapper implements Mapper<ProfilePersistenceModel, ProfileControllerModel> {

    private static final Logger LOG = LoggerFactory.getLogger(ProfilePersistenceMapper.class);

    @Override
    public ProfilePersistenceModel mapTo(ProfileControllerModel profileControllerModel) {

        LOG.debug("Mapping from profile controller model to persistence model");

        ProfilePersistenceModel profilePersistenceModel = null;
        if (profileControllerModel != null) {

            profilePersistenceModel = new ProfilePersistenceModel();
            profilePersistenceModel.setAbout(profileControllerModel.getAbout());
            profilePersistenceModel.setLocation(profileControllerModel.getLocation());
            profilePersistenceModel.setProfession(profileControllerModel.getProfession());
            profilePersistenceModel.setRating(profileControllerModel.getRating());
            profilePersistenceModel.setSummary(profileControllerModel.getSummary());
            profilePersistenceModel.setPicture(profileControllerModel.getPicture());
        }

        LOG.debug("Successfully mapped from profile persistence model to controller model");

        return profilePersistenceModel;
    }

    @Override
    public ProfileControllerModel mapFrom(ProfilePersistenceModel profilePersistenceModel) {

        LOG.debug("Mapping from profile persistence model to controller model");

        ProfileControllerModel profileControllerModel = null;
        if (profilePersistenceModel != null) {

            profileControllerModel = new ProfileControllerModel();
            profileControllerModel.setAbout(profilePersistenceModel.getAbout());
            profileControllerModel.setLocation(profilePersistenceModel.getLocation());
            profileControllerModel.setProfession(profilePersistenceModel.getProfession());
            profileControllerModel.setRating(profilePersistenceModel.getRating());
            profileControllerModel.setSummary(profilePersistenceModel.getSummary());
            profileControllerModel.setPicture(profilePersistenceModel.getPicture());
        }

        LOG.debug("Successfully mapped from profile persistence model to controller model");

        return profileControllerModel;
    }
}
