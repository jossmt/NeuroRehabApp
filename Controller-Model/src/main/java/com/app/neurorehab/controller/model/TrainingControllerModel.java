package com.app.neurorehab.controller.model;

import com.app.neurorehab.domain.model.DataTypes.TrainingArea;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TrainingControllerModel {

    private String reference;
    private String title;
    private String description;
    private Date creationDate;
    private Integer rating;
    private TrainingArea trainingArea;

    /**
     * Gets trainingArea.
     *
     * @return Value of trainingArea.
     */
    public TrainingArea getTrainingArea() {
        return trainingArea;
    }

    /**
     * Sets new trainingArea.
     *
     * @param trainingArea
     *         New value of trainingArea.
     */
    public void setTrainingArea(TrainingArea trainingArea) {
        this.trainingArea = trainingArea;
    }

    /**
     * Sets new reference.
     *
     * @param reference
     *         New value of reference.
     */
    public void setReference(String reference) {
        this.reference = reference;
    }

    /**
     * Gets reference.
     *
     * @return Value of reference.
     */
    public String getReference() {
        return reference;
    }

    /**
     * Gets description.
     *
     * @return Value of description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets new description.
     *
     * @param description
     *         New value of description.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets creationDate.
     *
     * @return Value of creationDate.
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * Sets new creationDate.
     *
     * @param creationDate
     *         New value of creationDate.
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Sets new rating.
     *
     * @param rating
     *         New value of rating.
     */
    public void setRating(Integer rating) {
        this.rating = rating;
    }

    /**
     * Gets rating.
     *
     * @return Value of rating.
     */
    public Integer getRating() {
        return rating;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        TrainingControllerModel that = (TrainingControllerModel) o;

        return new EqualsBuilder()
                .append(getReference(), that.getReference())
                .append(getTitle(), that.getTitle())
                .append(getCreationDate(), that.getCreationDate())
                .append(getDescription(), that.getDescription())
                .append(getRating(), that.getRating())
                .append(getTrainingArea(), that.getTrainingArea())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getReference())
                .append(getTitle())
                .append(getCreationDate())
                .append(getDescription())
                .append(getRating())
                .append(getTrainingArea())
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("reference", reference)
                .append("title", title)
                .append("description", description)
                .append("creationDate", creationDate)
                .append("rating", rating)
                .append("trainingArea", trainingArea)
                .toString();
    }
}
