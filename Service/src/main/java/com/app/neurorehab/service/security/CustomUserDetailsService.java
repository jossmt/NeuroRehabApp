package com.app.neurorehab.service.security;

import com.app.neurorehab.persistence.model.security.UserPrincipal;
import com.app.neurorehab.persistence.model.UserPersistenceModel;
import com.app.neurorehab.persistence.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    private static final Logger LOG = LoggerFactory.getLogger(CustomUserDetailsService.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {

        LOG.debug("Loading user by username: {}", username);

        UserPersistenceModel user = userRepository.findByEmail(username);
        if (user == null) {
            LOG.error("Username not found with username: {}", username);
            throw new UsernameNotFoundException("User not found with username : " + username);
        }

        return UserPrincipal.create(user);
    }
}
