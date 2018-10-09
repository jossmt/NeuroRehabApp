package com.app.neurorehab.controller;

import com.app.neurorehab.controller.model.Jwt.JwtAuthenticationResponse;
import com.app.neurorehab.controller.model.Request.LoginRequest;
import com.app.neurorehab.controller.model.Request.SignupRequest;
import com.app.neurorehab.controller.security.handlers.JwtTokenProvider;
import com.app.neurorehab.domain.model.DataTypes.Exceptions.CustomException;
import com.app.neurorehab.domain.model.DataTypes.Exceptions.ExceptionMessage;
import com.app.neurorehab.persistence.model.ProfilePersistenceModel;
import com.app.neurorehab.persistence.model.RolePersistenceModel;
import com.app.neurorehab.persistence.model.UserPersistenceModel;
import com.app.neurorehab.persistence.repository.RoleRepository;
import com.app.neurorehab.persistence.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Arrays;
import java.util.Random;

@Controller
@RequestMapping("/api/auth")
public class AuthController {

    private static final Logger LOG = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenProvider tokenProvider;

    @RequestMapping(value = "/signin", method = RequestMethod.POST, produces = "application/json", consumes =
            "application/json")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        LOG.debug("Signin request received");

        Authentication authentication;
        try {
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getUsername(),
                            loginRequest.getPassword()
                    )
            );
        }
        catch(BadCredentialsException exception){
            throw new CustomException(HttpStatus.BAD_REQUEST, ExceptionMessage.USER_PASSWORD_INVALID);
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST, produces = "application/json", consumes =
            "application/json")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (userRepository.emailExists(signUpRequest.getEmail())) {
            throw new CustomException(HttpStatus.BAD_REQUEST, "Username is already taken!");
        }

        final UserPersistenceModel userPersistenceModel = new UserPersistenceModel();
        userPersistenceModel.setEmail(signUpRequest.getEmail());
        userPersistenceModel.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        RolePersistenceModel userRole = roleRepository.findByName("user_role");
        userPersistenceModel.setRolePersistenceModels(Arrays.asList(userRole));

        String userReference = generateUniqueUserReference(userPersistenceModel.getEmail());
        while(userRepository.userReferenceExists(userReference)){
            userReference = generateUniqueUserReference(userPersistenceModel.getEmail());
        }
        userPersistenceModel.setUserReference(userReference);

        final UserPersistenceModel userPersisted = userRepository.save(userPersistenceModel);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/users/{username}")
                .buildAndExpand(userPersisted.getEmail()).toUri();

        return ResponseEntity.created(location).body(new CustomException(HttpStatus.OK, "User registered " +
                "successfully"));
    }

    private String generateUniqueUserReference(final String username) {

        final String[] emailSplit = username.split("@");

        final Random random = new Random();
        final Integer randomInteger = random.nextInt(500);

        return emailSplit[0] + randomInteger;
    }
}