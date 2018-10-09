package com.app.neurorehab.controller.model.Response.ContributionResponse;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashSet;
import java.util.Set;

public class KanbanResponseBody {

    @JsonProperty(value = "lanes")
    private Set<KanbanLane> kanbanLanes;

    public KanbanResponseBody() {

    }

    public KanbanResponseBody(final Set<KanbanLane> kanbanLanes) {
        this.kanbanLanes = kanbanLanes;
    }

    /**
     * Sets new kanbanLanes.
     *
     * @param kanbanLanes
     *         New value of kanbanLanes.
     */
    public void setKanbanLanes(Set<KanbanLane> kanbanLanes) {
        this.kanbanLanes = kanbanLanes;
    }

    /**
     * Gets kanbanLanes.
     *
     * @return Value of kanbanLanes.
     */
    public Set<KanbanLane> getKanbanLanes() {
        return kanbanLanes;
    }


    public KanbanLane getKanbanLaneByTitle(final String title) {

        if(kanbanLanes == null){
            kanbanLanes = new HashSet<>();
        }

        for (final KanbanLane kanbanLane : kanbanLanes) {
            if (kanbanLane.getTitle().equals(title)) {
                return kanbanLane;
            }
        }

        //Creates kanban lane for given title
        final KanbanLane kanbanLane = new KanbanLane("lane" + kanbanLanes.size(), title);
        kanbanLanes.add(kanbanLane);
        return kanbanLane;
    }
}
