package com.app.neurorehab.service;

import com.app.neurorehab.controller.model.ContributionControllerModel;
import com.app.neurorehab.controller.model.ProfileControllerModel;
import com.app.neurorehab.controller.model.Request.UpdateProfileRequest;
import com.app.neurorehab.controller.model.Response.ContributionResponse.KanbanResponseBody;
import com.app.neurorehab.controller.model.Response.ProfileResponseBody;
import com.app.neurorehab.controller.model.UserControllerModel;
import com.app.neurorehab.domain.model.DataTypes.Exceptions.CustomException;
import com.app.neurorehab.domain.model.DataTypes.Exceptions.ExceptionMessage;
import com.app.neurorehab.persistence.UserPersistenceService;
import com.app.neurorehab.persistence.mapper.ContributionKanbanPersistenceMapper;
import com.app.neurorehab.persistence.mapper.ProfilePersistenceMapper;
import com.app.neurorehab.persistence.mapper.UserPersistenceMapper;
import com.app.neurorehab.persistence.model.ProfilePersistenceModel;
import com.app.neurorehab.persistence.model.UserPersistenceModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.Set;

/**
 * Handler for user related services.
 */
@Service
public class UserService {

    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

    private UserPersistenceService userPersistenceService;
    private UserPersistenceMapper userPersistenceMapper;
    private ContributionKanbanPersistenceMapper contributionKanbanPersistenceMapper;

    @Autowired
    public UserService(final UserPersistenceService userPersistenceService,
                       final UserPersistenceMapper userPersistenceMapper,
                       final ProfilePersistenceMapper profilePersistenceMapper,
                       final ContributionKanbanPersistenceMapper contributionKanbanPersistenceMapper) {

        this.userPersistenceService = userPersistenceService;
        this.userPersistenceMapper = userPersistenceMapper;
        this.contributionKanbanPersistenceMapper = contributionKanbanPersistenceMapper;
    }

    @Transactional
    public void updateProfile(final UpdateProfileRequest updateProfileRequest,
                              final String userEmail) {

        LOG.debug("Updating profile: {}", updateProfileRequest);

        final UserPersistenceModel userPersistenceModel = userPersistenceService
                .findUserByEmail(userEmail);

        if (userPersistenceModel == null) {
            throw new CustomException(HttpStatus.NOT_FOUND, ExceptionMessage.USER_NONEXISTENT);
        }

        final ProfilePersistenceModel profilePersistenceModel = userPersistenceModel.getProfilePersistenceModel();
        profilePersistenceModel.setSummary(updateProfileRequest.getSummary());
        profilePersistenceModel.setAbout(updateProfileRequest.getAbout());
        profilePersistenceModel.setLocation(updateProfileRequest.getCity() + "," + updateProfileRequest.getCountry());
        profilePersistenceModel.setProfession(updateProfileRequest.getProfession());

        LOG.debug("Successfully updated profile {}", profilePersistenceModel);
    }

    @Transactional
    public void updateProfilePicture(final byte[] profilePicture, final String userEmail) {

        LOG.debug("Updating profile picture");

        final UserPersistenceModel userPersistenceModel = userPersistenceService.findUserByEmail(userEmail);

        if (userPersistenceModel == null) {
            throw new CustomException(HttpStatus.NOT_FOUND, ExceptionMessage.USER_NONEXISTENT);
        }

        ProfilePersistenceModel profilePersistenceModel = userPersistenceModel.getProfilePersistenceModel();
        if (profilePersistenceModel == null) {
            profilePersistenceModel = new ProfilePersistenceModel();
        }

        profilePersistenceModel.setPicture(profilePicture);

        LOG.debug("Successfully updated profile {}", profilePersistenceModel.toString());
    }

    @Transactional
    public ProfileResponseBody getUserByReference(final String userReference, final String email) {

        LOG.debug("Looking for user with reference: {}", userReference);

        final UserPersistenceModel userPersistenceModel = userPersistenceService.findUserByUserReference(userReference);

        final KanbanResponseBody kanbanResponseBody = contributionKanbanPersistenceMapper.mapToProfileKanban
                (userPersistenceModel.getContributionPersistenceModels());

        final UserControllerModel userControllerModel = userPersistenceMapper.mapFrom(userPersistenceModel);

        final ProfileResponseBody profileResponseBody = new ProfileResponseBody();
        profileResponseBody.setFname(userControllerModel.getFname());
        profileResponseBody.setLname(userControllerModel.getLname());
        profileResponseBody.setProfileControllerModel(userControllerModel.getProfileControllerModel());
        profileResponseBody.setKanbanResponseBody(kanbanResponseBody);

        if (email != null) {
            if (email.equals(userPersistenceModel.getEmail())) {
                profileResponseBody.setIsOwner(true);
            } else {
                profileResponseBody.setIsOwner(false);
            }
        }

        LOG.debug("Successfully returned user");

        return profileResponseBody;
    }
}
