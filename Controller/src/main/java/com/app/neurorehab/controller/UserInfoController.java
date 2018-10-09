package com.app.neurorehab.controller;

import com.app.neurorehab.controller.model.ContributionControllerModel;
import com.app.neurorehab.controller.model.ProfileControllerModel;
import com.app.neurorehab.controller.model.Request.UpdateProfilePictureRequest;
import com.app.neurorehab.controller.model.Request.UpdateProfileRequest;
import com.app.neurorehab.controller.model.Response.ProfileResponseBody;
import com.app.neurorehab.controller.model.UserControllerModel;
import com.app.neurorehab.controller.security.handlers.JwtTokenProvider;
import com.app.neurorehab.domain.model.DataTypes.Exceptions.CustomException;
import com.app.neurorehab.domain.model.DataTypes.Exceptions.ExceptionMessage;
import com.app.neurorehab.persistence.model.security.UserPrincipal;
import com.app.neurorehab.service.ContributionService;
import com.app.neurorehab.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Set;

@CrossOrigin
@Controller
@RequestMapping("/app/rest/user")
public class UserInfoController {

    private static final Logger LOG = LoggerFactory.getLogger(UserInfoController.class);

    private UserService userService;
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    public UserInfoController(final UserService userService,
                              final JwtTokenProvider jwtTokenProvider) {

        this.userService = userService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @RequestMapping(value = "/profile", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity updateUserProfile(@RequestBody final UpdateProfileRequest updateProfileRequest,
                                            final Authentication authentication) {

        LOG.debug("Updating profile:{}", updateProfileRequest);

        final String email = ((UserPrincipal) authentication.getPrincipal()).getUsername();

        userService.updateProfile(updateProfileRequest, email);

        LOG.debug("Profile updated successfully");

        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/profile/picture", method = RequestMethod.POST, consumes = "application/octet-stream")
    public ResponseEntity updateUserProfilePicture(@RequestBody final byte[] image, final Authentication
            authentication) {

        LOG.debug("Profile Image Update: {}", image);

        final String email = ((UserPrincipal) authentication.getPrincipal()).getUsername();

        userService.updateProfilePicture(image, email);

        LOG.debug("Profile updated successfully");

        return ResponseEntity.ok().build();
    }

    @Transactional
    @RequestMapping(value = "/profile/{userref}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    ProfileResponseBody getUserProfile(@RequestHeader("Authorization") String authorization,
                                       @PathVariable final String userref, final Authentication authentication) {

        LOG.debug("Returning profile for user: {}");

        String email = null;

        try {
            email = jwtTokenProvider.getUserIdFromJWT(authorization.substring(7, authorization.length()));
        } catch (Exception e) {
            LOG.debug("Profile request was for unauthorised user");
        }

        if (authentication != null) {
            if (authentication.getPrincipal() != null) {
                email = ((UserPrincipal) authentication.getPrincipal()).getUsername();
            }
        }

        final ProfileResponseBody profileResponseBody = userService.getUserByReference(userref, email);

        LOG.debug("Profile successfully loaded: {}", profileResponseBody);

        return profileResponseBody;
    }
}
