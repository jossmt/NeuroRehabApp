package com.app.neurorehab.persistence;

import com.app.neurorehab.domain.model.DataTypes.Exceptions.CustomException;
import com.app.neurorehab.domain.model.DataTypes.Exceptions.ExceptionMessage;
import com.app.neurorehab.persistence.model.ProfilePersistenceModel;
import com.app.neurorehab.persistence.model.UserPersistenceModel;
import com.app.neurorehab.persistence.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserPersistenceServiceHandler implements UserPersistenceService {

    private static final Logger LOG = LoggerFactory.getLogger(UserPersistenceService.class);

    private UserRepository userRepository;

    @Autowired
    public UserPersistenceServiceHandler(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ProfilePersistenceModel updateProfile(final ProfilePersistenceModel profilePersistenceModel,
                                                 final Authentication authentication) {

        final UserPersistenceModel userPersistenceModel = userRepository.findByEmail(authentication.getPrincipal()
                                                                                                .toString());

        LOG.debug("Updating profile: {} for user: {}", profilePersistenceModel, userPersistenceModel);

        userPersistenceModel.setProfilePersistenceModel(profilePersistenceModel);

        userRepository.save(userPersistenceModel);
        LOG.debug("Successfully updated user profile");

        return null;
    }

    @Transactional
    @Override
    public UserPersistenceModel findUserByUserReference(final String userReference) {

        final UserPersistenceModel userPersistenceModel = userRepository.findByReference(userReference);

        if(userPersistenceModel == null){
            throw new CustomException(HttpStatus.NOT_FOUND, ExceptionMessage.USER_NONEXISTENT);
        }

        if(!userPersistenceModel.hasProfilePersistenceModel()){
            throw new CustomException(HttpStatus.BAD_REQUEST, ExceptionMessage.PROFILE_NOT_SETUP);
        }

        LOG.debug("Returning user: {}", userPersistenceModel);

        return userPersistenceModel;
    }

    @Transactional
    public UserPersistenceModel findUserByEmail(final String uname) {

        LOG.debug("Finding user by uname: {}", uname);

        final UserPersistenceModel userPersistenceModel = userRepository.findByEmail(uname);

        LOG.debug("Returning user: {}", userPersistenceModel);

        return userPersistenceModel;
    }

}
