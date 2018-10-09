package com.app.neurorehab.controller;

import com.app.neurorehab.controller.model.ContributionControllerModel;
import com.app.neurorehab.controller.model.Request.ContributionsRequest;
import com.app.neurorehab.controller.model.Response.ContributionResponse.KanbanResponseBody;
import com.app.neurorehab.persistence.model.security.UserPrincipal;
import com.app.neurorehab.service.ContributionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.ws.rs.core.Response;
import java.util.Set;

@Controller
@RequestMapping("/app/rest/contributions")
public class ContributionController {

    private static final Logger LOG = LoggerFactory.getLogger(ContributionController.class);

    private ContributionService contributionService;

    @Autowired
    public ContributionController(final ContributionService contributionService) {

        this.contributionService = contributionService;
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json", consumes = "application/json")
    public @ResponseBody
    Set<ContributionControllerModel> getAllContributions() {

        LOG.debug("Getting all contributions");

        final Set<ContributionControllerModel> allContributions = contributionService.getAllContributions();

        LOG.debug("Returning all contributions");

        return allContributions;
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public @ResponseBody
    KanbanResponseBody getAllContributions(@Valid @RequestBody final ContributionsRequest contributionsRequest) {

        LOG.debug("Getting all contributions");

        final KanbanResponseBody kanbanResponseBody = contributionService.getAllContributionsAsKanban
                (contributionsRequest);

        LOG.debug("Returning all contributions");

        return kanbanResponseBody;
    }

    @RequestMapping(value = "/{reference}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    ContributionControllerModel getContribution(@PathVariable final String reference) {

        LOG.debug("Searching for contribution with reference: {}", reference);

        final ContributionControllerModel contribution = contributionService.getContributionByReference(reference);

        LOG.debug("Returning contribution: {}", contribution);

        return contribution;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity addContribution(@RequestBody final ContributionControllerModel
                                        contributionControllerModel,
                                final Authentication authentication) {

        LOG.debug("Adding new contribution: {}", contributionControllerModel);

        final String email = ((UserPrincipal) authentication.getPrincipal()).getUsername();

        contributionService.addContribution(contributionControllerModel, email);

        LOG.debug("Added contribution successfully");

        return ResponseEntity.ok().build();
    }
}
