package com.app.neurorehab.controller.model.Response.ContributionResponse;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashSet;
import java.util.Set;

public class KanbanCard {

    private String id;

    private String author;

    private String title;

    private String cardColour;

    private String label;

    private String labelColour;

    public KanbanCard() {

    }

    public KanbanCard(final String id, final String author, final String title) {
        this.id = id;
        this.author = author;
        this.title = title;
    }


    /**
     * Gets author.
     *
     * @return Value of author.
     */
    public String getAuthor() {
        return author;
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
     * Sets new author.
     *
     * @param author
     *         New value of author.
     */
    public void setAuthor(String author) {
        this.author = author;
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
     * Gets title.
     *
     * @return Value of title.
     */
    public String getTitle() {
        return title;
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
     * Sets new cardColour.
     *
     * @param cardColour
     *         New value of cardColour.
     */
    public void setCardColour(String cardColour) {
        this.cardColour = cardColour;
    }

    /**
     * Gets cardColour.
     *
     * @return Value of cardColour.
     */
    public String getCardColour() {
        return cardColour;
    }

    /**
     * Sets new labelColour.
     *
     * @param labelColour
     *         New value of labelColour.
     */
    public void setLabelColour(String labelColour) {
        this.labelColour = labelColour;
    }

    /**
     * Gets label.
     *
     * @return Value of label.
     */
    public String getLabel() {
        return label;
    }

    /**
     * Gets labelColour.
     *
     * @return Value of labelColour.
     */
    public String getLabelColour() {
        return labelColour;
    }

    /**
     * Sets new label.
     *
     * @param label
     *         New value of label.
     */
    public void setLabel(String label) {
        this.label = label;
    }
}
