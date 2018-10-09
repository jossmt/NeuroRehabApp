package com.app.neurorehab.persistence.model;

import com.app.neurorehab.domain.model.DataTypes.ContributionType;
import com.app.neurorehab.domain.model.DataTypes.TrainingArea;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.util.List;

/**
 * Contribution model as represented by DB.
 */
@Entity
@Table(name = "Contribution")
public class ContributionPersistenceModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "reference")
    private String reference;

    @Column(name = "title")
    private String title;

    @Column(name = "precedingReferences")
    private String precedingReferences;

    @Enumerated(EnumType.STRING)
    @Column(name = "contribution_type")
    private ContributionType contributionType;

    @Enumerated(EnumType.STRING)
    @Column(name = "training_area")
    private TrainingArea trainingArea;

    @Column(name = "contribution")
    private String contribution;

    @Column(name = "accepted")
    private boolean accepted;

    @OneToOne(mappedBy = "contributionPersistenceModel", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private TrainingPersistenceModel trainingPersistenceModel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", nullable = false)
    private UserPersistenceModel userPersistenceModel;

    /**
     * Gets contribution.
     *
     * @return Value of contribution.
     */
    public String getContribution() {
        return contribution;
    }

    /**
     * Gets contributionType.
     *
     * @return Value of contributionType.
     */
    public ContributionType getContributionType() {
        return contributionType;
    }

    /**
     * Gets trainingArea.
     *
     * @return Value of trainingArea.
     */
    public TrainingArea getTrainingArea() {
        return trainingArea;
    }

    /**
     * Sets new contribution.
     *
     * @param contribution
     *         New value of contribution.
     */
    public void setContribution(String contribution) {
        this.contribution = contribution;
    }

    /**
     * Sets new contributionType.
     *
     * @param contributionType
     *         New value of contributionType.
     */
    public void setContributionType(ContributionType contributionType) {
        this.contributionType = contributionType;
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
     * Gets trainingPersistenceModel.
     *
     * @return Value of trainingPersistenceModel.
     */
    public TrainingPersistenceModel getTrainingPersistenceModel() {
        return trainingPersistenceModel;
    }

    /**
     * Sets new trainingPersistenceModel.
     *
     * @param trainingPersistenceModel
     *         New value of trainingPersistenceModel.
     */
    public void setTrainingPersistenceModel(TrainingPersistenceModel trainingPersistenceModel) {
        this.trainingPersistenceModel = trainingPersistenceModel;
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
     * Sets new accepted.
     *
     * @param accepted
     *         New value of accepted.
     */
    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    /**
     * Gets userPersistenceModel.
     *
     * @return Value of userPersistenceModel.
     */
    public UserPersistenceModel getUserPersistenceModel() {
        return userPersistenceModel;
    }

    /**
     * Sets new userPersistenceModel.
     *
     * @param userPersistenceModel
     *         New value of userPersistenceModel.
     */
    public void setUserPersistenceModel(UserPersistenceModel userPersistenceModel) {
        this.userPersistenceModel = userPersistenceModel;
    }

    /**
     * Gets precedingReferences.
     *
     * @return Value of precedingReferences.
     */
    public String getPrecedingReferences() {
        return precedingReferences;
    }

    /**
     * Sets new precedingReferences.
     *
     * @param precedingReferences
     *         New value of precedingReferences.
     */
    public void setPrecedingReferences(String precedingReferences) {
        this.precedingReferences = precedingReferences;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ContributionPersistenceModel that = (ContributionPersistenceModel) o;

        return new EqualsBuilder()
                .append(getReference(), that.getReference())
                .append(getTitle(), that.getTitle())
                .append(getContributionType(), that.getContributionType())
                .append(getTrainingArea(), that.getTrainingArea())
                .append(getContribution(), that.getContribution())
                .append(getPrecedingReferences(), that.getPrecedingReferences())
                .append(isAccepted(), that.isAccepted())
                .append(getTrainingPersistenceModel(), that.getTrainingPersistenceModel())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getReference())
                .append(getTitle())
                .append(getContributionType())
                .append(getTrainingArea())
                .append(getContribution())
                .append(getPrecedingReferences())
                .append(isAccepted())
                .append(getTrainingPersistenceModel())
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("reference", reference)
                .append("title", title)
                .append("contributionType", contributionType)
                .append("preceding references", precedingReferences)
                .append("trainingArea", trainingArea)
                .append("contribution", contribution)
                .append("accepted", accepted)
                .toString();
    }
}
