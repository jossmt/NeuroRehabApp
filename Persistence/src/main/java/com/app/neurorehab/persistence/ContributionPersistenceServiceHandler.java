package com.app.neurorehab.persistence;

import com.app.neurorehab.domain.model.DataTypes.Exceptions.CustomException;
import com.app.neurorehab.domain.model.DataTypes.Exceptions.ExceptionMessage;
import com.app.neurorehab.persistence.model.UserPersistenceModel;
import com.app.neurorehab.persistence.repository.ContributionRepository;
import com.app.neurorehab.persistence.model.ContributionPersistenceModel;
import com.app.neurorehab.persistence.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ContributionPersistenceServiceHandler implements ContributionPersistenceService {

    private static final Logger LOG = LoggerFactory.getLogger(ContributionPersistenceService.class);

    private ContributionRepository contributionRepository;
    private UserRepository userRepository;

    @Autowired
    public ContributionPersistenceServiceHandler(final ContributionRepository contributionRepository,
                                                 final UserRepository userRepository) {

        this.contributionRepository = contributionRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Set<ContributionPersistenceModel> getAllContributions(final Boolean isAccepted) {

        LOG.debug("Getting all contributions");

        final Set<ContributionPersistenceModel> contributionPersistenceModels;
        if (isAccepted != null) {
            contributionPersistenceModels = contributionRepository.findAllByAcceptance(isAccepted);
        } else {
            contributionPersistenceModels = contributionRepository.findAllAsSet();
        }

        LOG.debug("Returning all contributions");

        return contributionPersistenceModels;
    }

    @Override
    public ContributionPersistenceModel getContributionByReference(String reference) {

        LOG.debug("Getting contribution by reference: {}", reference);

        final ContributionPersistenceModel contributionPersistenceModel = contributionRepository.findByReference
                (reference);

        LOG.debug("Found contribution: {}", contributionPersistenceModel);

        return contributionPersistenceModel;
    }
}
