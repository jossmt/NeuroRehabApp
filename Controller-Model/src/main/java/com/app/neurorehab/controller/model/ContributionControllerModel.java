package com.app.neurorehab.controller.model;


import com.app.neurorehab.domain.model.DataTypes.ContributionType;
import com.app.neurorehab.domain.model.DataTypes.TrainingArea;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.stereotype.Component;

@Component
public class ContributionControllerModel {

    private String reference;
    private String title;
    private ContributionType contributionType;
    private TrainingArea trainingArea;
    private String[] precedingContributionReferences;
    private String contribution;
    private TrainingControllerModel trainingControllerModel;


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
     * Sets new trainingControllerModel.
     *
     * @param trainingControllerModel
     *         New value of trainingControllerModel.
     */
    public void setTrainingControllerModel(TrainingControllerModel trainingControllerModel) {
        this.trainingControllerModel = trainingControllerModel;
    }

    /**
     * Gets trainingControllerModel.
     *
     * @return Value of trainingControllerModel.
     */
    public TrainingControllerModel getTrainingControllerModel() {
        return trainingControllerModel;
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
     * Sets new reference.
     *
     * @param reference
     *         New value of reference.
     */
    public void setReference(String reference) {
        this.reference = reference;
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
     * Sets new precedingContributionReference.
     *
     * @param precedingContributionReferences
     *         New value of precedingContributionReference.
     */
    public void setPrecedingContributionReference(String[] precedingContributionReferences) {
        this.precedingContributionReferences = precedingContributionReferences;
    }

    /**
     * Gets precedingContributionReference.
     *
     * @return Value of precedingContributionReference.
     */
    public String[] getPrecedingContributionReferences() {
        return precedingContributionReferences;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ContributionControllerModel that = (ContributionControllerModel) o;

        return new EqualsBuilder()
                .append(getReference(), that.getReference())
                .append(getTitle(), that.getTitle())
                .append(getContributionType(), that.getContributionType())
                .append(getTrainingArea(), that.getTrainingArea())
                .append(getContribution(), that.getContribution())
                .append(getTrainingControllerModel(), that.getTrainingControllerModel())
                .append(getPrecedingContributionReferences(), that.getPrecedingContributionReferences())
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
                .append(getTrainingControllerModel())
                .append(getPrecedingContributionReferences())
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("reference", reference)
                .append("title", title)
                .append("preceding reference", precedingContributionReferences)
                .append("contributionType", contributionType)
                .append("trainingArea", trainingArea)
                .append("contribution", contribution)
                .append("trainingData", trainingControllerModel)
                .toString();
    }
}
