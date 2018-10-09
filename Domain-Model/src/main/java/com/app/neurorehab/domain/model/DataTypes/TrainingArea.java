package com.app.neurorehab.domain.model.DataTypes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Areas of neural development.
 */
public enum TrainingArea {

    ATTENTION ("attention"),
    MEMORY("memory"),
    EXECUTIVE_FUNCTION("executivefunction"),
    EMPLOYMENT ("employment"),
    SPEED ("speed"),
    COMMUNICATION("communication")
    ;

    private static final Logger LOG = LoggerFactory.getLogger(TrainingArea.class);

    private String value;

    TrainingArea(final String value){

        this.value = value;
    }

    public String getValue(){
        return value;
    }

    public static TrainingArea getTrainingArea(final String value) {

        TrainingArea trainingAreaDefault = null;
        for (final TrainingArea trainingArea : TrainingArea.values()) {

            LOG.debug("Training value: {}", trainingArea);

            if (trainingArea.getValue().equals(value)) {
                trainingAreaDefault = trainingArea;
            }
        }

        return trainingAreaDefault;
    }
}
