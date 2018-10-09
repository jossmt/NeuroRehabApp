package com.app.neurorehab.service;

import com.app.neurorehab.controller.model.ContributionControllerModel;
import com.app.neurorehab.controller.model.Request.ContributionsRequest;
import com.app.neurorehab.controller.model.Response.ContributionResponse.KanbanResponseBody;
import com.app.neurorehab.domain.model.DataTypes.Exceptions.CustomException;
import com.app.neurorehab.domain.model.DataTypes.Exceptions.ExceptionMessage;
import com.app.neurorehab.persistence.ContributionPersistenceService;
import com.app.neurorehab.persistence.UserPersistenceService;
import com.app.neurorehab.persistence.mapper.ContributionKanbanPersistenceMapper;
import com.app.neurorehab.persistence.mapper.ContributionPersistenceMapper;
import com.app.neurorehab.persistence.mapper.constants.SetMapper;
import com.app.neurorehab.persistence.model.ContributionPersistenceModel;
import com.app.neurorehab.persistence.model.UserPersistenceModel;
import com.app.neurorehab.persistence.model.security.UserPrincipal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * Handler for contribution related services.
 */
@Service
public class ContributionService {

    private static final Logger LOG = LoggerFactory.getLogger(ContributionService.class);

    private SetMapper setMapper;
    private UserPersistenceService userPersistenceService;
    private ContributionPersistenceService contributionPersistenceService;
    private ContributionPersistenceMapper contributionPersistenceMapper;
    private ContributionKanbanPersistenceMapper contributionKanbanPersistenceMapper;

    @Autowired
    public ContributionService(final UserPersistenceService userPersistenceService,
                               final ContributionPersistenceService contributionPersistenceService,
                               final ContributionPersistenceMapper contributionPersistenceMapper,
                               final ContributionKanbanPersistenceMapper contributionKanbanPersistenceMapper) {

        this.userPersistenceService = userPersistenceService;
        this.contributionPersistenceService = contributionPersistenceService;
        this.contributionPersistenceMapper = contributionPersistenceMapper;
        this.contributionKanbanPersistenceMapper = contributionKanbanPersistenceMapper;
        setMapper = new SetMapper();
    }

    public Set<ContributionControllerModel> getAllContributions() {

        LOG.debug("Getting all contributions");

        final Set<ContributionPersistenceModel> contributionPersistenceModels = contributionPersistenceService
                .getAllContributions(null);

        final Set<ContributionControllerModel> contributionControllerModels = setMapper.mapSet
                (contributionPersistenceMapper, false, contributionPersistenceModels);

        LOG.debug("Returning all contributions");

        return contributionControllerModels;
    }

    @Transactional
    public KanbanResponseBody getAllContributionsAsKanban(final ContributionsRequest contributionsRequest) {

        LOG.debug("Getting all contributions");

        final Set<ContributionPersistenceModel> contributionPersistenceModels = contributionPersistenceService
                .getAllContributions(contributionsRequest.isAccepted());

        final KanbanResponseBody kanbanResponseBody = contributionKanbanPersistenceMapper.mapToKanban
                (contributionPersistenceModels);

        LOG.debug("Returning all contributions");

        return kanbanResponseBody;
    }

    public ContributionControllerModel getContributionByReference(final String reference) {

        LOG.debug("Finding contribution by reference: {}", reference);

        final ContributionPersistenceModel contributionPersistenceModel = contributionPersistenceService
                .getContributionByReference(reference);

        final ContributionControllerModel contributionControllerModel = contributionPersistenceMapper.mapFrom
                (contributionPersistenceModel);

        LOG.debug("Successfully found contribution: {}", contributionControllerModel);

        return contributionControllerModel;
    }

    @Transactional
    public void addContribution(final ContributionControllerModel contributionControllerModel,
                                final String email) {

        LOG.debug("Adding contribution: {} for user: {}", contributionControllerModel.toString(), email);

        final UserPersistenceModel userPersistenceModel = userPersistenceService.findUserByEmail(
                (email));

        if (userPersistenceModel == null) {
            throw new CustomException(HttpStatus.NOT_FOUND, ExceptionMessage.USER_NONEXISTENT);
        }

        final ContributionPersistenceModel contributionPersistenceModel = contributionPersistenceMapper.mapTo
                (contributionControllerModel);

        LOG.debug("Contribution Persistence Model: {}", contributionPersistenceModel);

        LOG.debug("Training persistence Model: {}", contributionPersistenceModel.getTrainingPersistenceModel());

        userPersistenceModel.addContributionPersistenceModel(contributionPersistenceModel);

        LOG.debug("Successfully added contribution");
    }
}
