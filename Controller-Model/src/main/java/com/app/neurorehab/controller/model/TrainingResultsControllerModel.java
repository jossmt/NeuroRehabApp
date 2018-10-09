package com.app.neurorehab.controller.model;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.stereotype.Component;

/**
 * Training Results model as represented by DB.
 */
@Component
public class TrainingResultsControllerModel {

    private Integer results;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        TrainingResultsControllerModel that = (TrainingResultsControllerModel) o;

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
