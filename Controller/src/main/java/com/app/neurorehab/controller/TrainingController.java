package com.app.neurorehab.controller;

import com.app.neurorehab.controller.model.TrainingControllerModel;
import com.app.neurorehab.domain.model.DataTypes.Exceptions.CustomException;
import com.app.neurorehab.domain.model.DataTypes.Exceptions.ExceptionMessage;
import com.app.neurorehab.domain.model.DataTypes.TrainingArea;
import com.app.neurorehab.service.TrainingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@CrossOrigin

@Controller
@RequestMapping("/app/rest/training")
public class TrainingController {

    private static final Logger LOG = LoggerFactory.getLogger(TrainingController.class);

    private TrainingService trainingService;

    @Autowired
    public TrainingController(final TrainingService trainingService) {

        this.trainingService = trainingService;
    }

    @RequestMapping(value = "/{area}", method = RequestMethod.GET)
    public @ResponseBody
    Set<TrainingControllerModel> getTrainingData(@PathVariable(name = "area") final String trainingArea) {

        LOG.debug("Finding training for training area: {}", trainingArea);

        final TrainingArea trainingAreaEnum = TrainingArea.getTrainingArea(trainingArea);

        if (trainingAreaEnum == null) {

            throw new CustomException(HttpStatus.NOT_FOUND, ExceptionMessage.TRAINING_AREA_NONEXISTENT);
        }

        final Set<TrainingControllerModel> trainingControllerModels = trainingService.getTrainingData(trainingAreaEnum);

        LOG.debug("Returning training options");

        return trainingControllerModels;
    }

    @RequestMapping(value = "/{area}/{reference}", method = RequestMethod.GET)
    public @ResponseBody
    TrainingControllerModel getTrainingData(@PathVariable(name = "area") final String trainingArea, @PathVariable(name = "reference") final String uniqueReference) {

        LOG.debug("Finding training by reference: {}", uniqueReference);

        final TrainingArea trainingAreaEnum = TrainingArea.getTrainingArea(trainingArea);

        if (trainingAreaEnum == null) {

            throw new CustomException(HttpStatus.NOT_FOUND, ExceptionMessage.TRAINING_AREA_NONEXISTENT);
        }

        final TrainingControllerModel trainingControllerModel = trainingService.getTrainingData(uniqueReference);

        LOG.debug("Found training data: {}", trainingControllerModel);

        return trainingControllerModel;
    }

}
