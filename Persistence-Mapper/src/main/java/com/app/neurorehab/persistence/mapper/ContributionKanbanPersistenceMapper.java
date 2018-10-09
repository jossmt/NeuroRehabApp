package com.app.neurorehab.persistence.mapper;

import com.app.neurorehab.controller.model.Response.ContributionResponse.KanbanCard;
import com.app.neurorehab.controller.model.Response.ContributionResponse.KanbanLane;
import com.app.neurorehab.controller.model.Response.ContributionResponse.KanbanResponseBody;
import com.app.neurorehab.domain.model.DataTypes.ContributionType;
import com.app.neurorehab.persistence.model.ContributionPersistenceModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class ContributionKanbanPersistenceMapper {

    private static final Logger LOG = LoggerFactory.getLogger(ContributionKanbanPersistenceMapper.class);

    public KanbanResponseBody mapToKanban(final Set<ContributionPersistenceModel> contributionPersistenceModels) {

        LOG.debug("Mapping contributions to kanban format..");

        KanbanResponseBody kanbanResponseBody = null;
        if (contributionPersistenceModels != null) {

            kanbanResponseBody = new KanbanResponseBody();

            for (final ContributionPersistenceModel contributionPersistenceModel : contributionPersistenceModels) {


                final String contributionType = ContributionType.stringifyContributionType
                        (contributionPersistenceModel.getContributionType());

                final KanbanLane kanbanLane = kanbanResponseBody.getKanbanLaneByTitle
                        (contributionType);

                final KanbanCard kanbanCard = new KanbanCard();
                kanbanCard.setId(contributionPersistenceModel.getReference());
                kanbanCard.setTitle(contributionPersistenceModel.getTitle());
                kanbanCard.setAuthor(contributionPersistenceModel.getUserPersistenceModel().getFname() + " " +
                                             contributionPersistenceModel.getUserPersistenceModel().getLname());

                kanbanLane.addKanbanCard(kanbanCard);

            }
        }

        LOG.debug("Successfully mapped contributions to kanban data format..");

        return kanbanResponseBody;
    }

    public KanbanResponseBody mapToProfileKanban(final Set<ContributionPersistenceModel>
                                                         contributionPersistenceModels) {

        LOG.debug("Mapping contributions to kanban format..");

        //Default response..
        KanbanResponseBody kanbanResponseBody = new KanbanResponseBody();
        final KanbanLane kanbanLane = kanbanResponseBody.getKanbanLaneByTitle
                ("My Contributions");
        kanbanLane.setKanbanCards(new HashSet<>());

        if (contributionPersistenceModels != null) {

            for (final ContributionPersistenceModel contributionPersistenceModel : contributionPersistenceModels) {


                final String contributionType = ContributionType.stringifyContributionType
                        (contributionPersistenceModel.getContributionType());

                final KanbanCard kanbanCard = new KanbanCard();
                kanbanCard.setId(contributionPersistenceModel.getReference());
                kanbanCard.setTitle(contributionPersistenceModel.getTitle());
                kanbanCard.setAuthor(contributionPersistenceModel.getUserPersistenceModel().getFname() + " " +
                                             contributionPersistenceModel.getUserPersistenceModel().getLname());
                kanbanCard.setLabel(contributionType);
                kanbanCard.setLabelColour("#FF3B3F");
                kanbanLane.addKanbanCard(kanbanCard);

            }
        }

        LOG.debug("Successfully mapped contributions to kanban data format..");

        return kanbanResponseBody;
    }
}
