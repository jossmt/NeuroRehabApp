package com.app.neurorehab.persistence.model;

import com.app.neurorehab.domain.model.DataTypes.TrainingArea;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.util.Date;

/**
 * Training model as represented by DB
 */
@Entity
@Table(name = "Training")
public class TrainingPersistenceModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "reference")
    private String reference;

    @Column(name = "title")
    private String title;

    @Column(name = "creation_date")
    private Date creationDate;

    @Column(name = "description")
    private String description;

    @Column(name = "rating")
    private Integer rating;

    @Enumerated(EnumType.STRING)
    @Column(name = "training_area")
    private TrainingArea trainingArea;

    @Column(name = "accepted")
    private boolean accepted;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "contribution_id")
    private ContributionPersistenceModel contributionPersistenceModel;

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
     * Sets new accepted.
     *
     * @param accepted
     *         New value of accepted.
     */
    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    /**
     * Gets accepted.
     *
     * @return Value of accepted.
     */
    public boolean isAccepted() {
        return accepted;
    }

    /**
     * Gets contributionPersistenceModel.
     *
     * @return Value of contributionPersistenceModel.
     */
    public ContributionPersistenceModel getContributionPersistenceModel() {
        return contributionPersistenceModel;
    }

    /**
     * Sets new contributionPersistenceModel.
     *
     * @param contributionPersistenceModel
     *         New value of contributionPersistenceModel.
     */
    public void setContributionPersistenceModel(ContributionPersistenceModel contributionPersistenceModel) {
        this.contributionPersistenceModel = contributionPersistenceModel;
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
     * Sets new creationDate.
     *
     * @param creationDate
     *         New value of creationDate.
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
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
     * Sets new description.
     *
     * @param description
     *         New value of description.
     */
    public void setDescription(String description) {
        this.description = description;
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
     * Gets description.
     *
     * @return Value of description.
     */
    public String getDescription() {
        return description;
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
     * Gets title.
     *
     * @return Value of title.
     */
    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        TrainingPersistenceModel that = (TrainingPersistenceModel) o;

        return new EqualsBuilder()
                .append(getReference(), that.getReference())
                .append(getTitle(), that.getTitle())
                .append(getDescription(), that.getDescription())
                .append(getCreationDate(), that.getCreationDate())
                .append(getRating(), that.getRating())
                .append(getTrainingArea(), that.getTrainingArea())
                .append(isAccepted(), that.isAccepted())
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
                .append(isAccepted())
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
                .append("accepted", accepted)
                .toString();
    }
}
