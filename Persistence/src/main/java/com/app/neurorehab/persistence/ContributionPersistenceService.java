package com.app.neurorehab.persistence;

import com.app.neurorehab.persistence.model.ContributionPersistenceModel;

import java.util.Set;

public interface ContributionPersistenceService {

    Set<ContributionPersistenceModel> getAllContributions(Boolean accepted);

    ContributionPersistenceModel getContributionByReference(String reference);
}
