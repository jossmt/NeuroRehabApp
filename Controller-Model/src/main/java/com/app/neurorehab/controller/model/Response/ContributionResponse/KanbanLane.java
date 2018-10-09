package com.app.neurorehab.controller.model.Response.ContributionResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.HashSet;
import java.util.Set;

public class KanbanLane {

    private String id;

    private String title;

    @JsonProperty(value = "cards")
    private Set<KanbanCard> kanbanCards;

    public KanbanLane(){}

    public KanbanLane(final String id, final String title) {
        this.id = id;
        this.title = title;
    }

    /**
     * Gets title.
     *
     * @return Value of title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets id.
     *
     * @return Value of id.
     */
    public String getId() {
        return id;
    }

    /**
     * Sets new id.
     *
     * @param id
     *         New value of id.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Sets new title.
     *
     * @param title
     *         New value of title.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Sets new kanbanCards.
     *
     * @param kanbanCards
     *         New value of kanbanCards.
     */
    public void setKanbanCards(Set<KanbanCard> kanbanCards) {
        this.kanbanCards = kanbanCards;
    }

    /**
     * Gets kanbanCards.
     *
     * @return Value of kanbanCards.
     */
    public Set<KanbanCard> getKanbanCards() {
        return kanbanCards;
    }

    public void addKanbanCard(final KanbanCard kanbanCard){
        if(kanbanCards == null){
            kanbanCards = new HashSet<>();
        }
        kanbanCards.add(kanbanCard);
    }
}
