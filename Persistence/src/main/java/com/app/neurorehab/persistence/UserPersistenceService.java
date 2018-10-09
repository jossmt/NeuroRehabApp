package com.app.neurorehab.persistence;

import com.app.neurorehab.persistence.model.ProfilePersistenceModel;
import com.app.neurorehab.persistence.model.UserPersistenceModel;
import org.springframework.security.core.Authentication;

public interface UserPersistenceService {

    UserPersistenceModel findUserByUserReference(String userReference);

    ProfilePersistenceModel updateProfile(ProfilePersistenceModel profilePersistenceModel,
                                          Authentication authentication);

    UserPersistenceModel findUserByEmail(String uname);
}
