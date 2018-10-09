package com.app.neurorehab.persistence.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;

/**
 * Training Results model as represented by DB.
 */
@Entity
@Table(name = "TrainingResults")
public class TrainingResultsPersistenceModel {

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "Results")
    private Integer results;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "training_id")
    private TrainingPersistenceModel trainingPersistenceModel;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "owner_id", nullable = false)
    private UserPersistenceModel userPersistenceModel;


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
     * Gets trainingPersistenceModel.
     *
     * @return Value of trainingPersistenceModel.
     */
    public TrainingPersistenceModel getTrainingPersistenceModel() {
        return trainingPersistenceModel;
    }

    /**
     * Sets new results.
     *
     * @param results
     *         New value of results.
     */
    public void setResults(Integer results) {
        this.results = results;
    }

    /**
     * Gets results.
     *
     * @return Value of results.
     */
    public Integer getResults() {
        return results;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        TrainingResultsPersistenceModel that = (TrainingResultsPersistenceModel) o;

        return new EqualsBuilder()
                .append(getResults(), that.getResults())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getResults())
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("results", results)
                .toString();
    }
}
