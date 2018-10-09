package com.app.neurorehab.persistence.mapper.test;

import com.app.neurorehab.controller.model.*;
import com.app.neurorehab.domain.model.DataTypes.ContributionType;
import com.app.neurorehab.domain.model.DataTypes.TrainingArea;
import com.app.neurorehab.persistence.mapper.*;
import com.app.neurorehab.persistence.model.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;

/**
 * Test for UserPersistenceMapper (integration - includes all other mappers)
 */
public class UserPersistenceMapperTest {

    private UserPersistenceMapper userPersistenceMapper;
    private ProfilePersistenceMapper profilePersistenceMapper;
    private TrainingResultsPersistenceMapper trainingResultsPersistenceMapper;
    private TrainingPersistenceMapper trainingPersistenceMapper;
    private ContributionPersistenceMapper contributionPersistenceMapper;

    @Before
    public void setUp() {
        profilePersistenceMapper = new ProfilePersistenceMapper();
        trainingPersistenceMapper = new TrainingPersistenceMapper();
        trainingResultsPersistenceMapper = new TrainingResultsPersistenceMapper();
        contributionPersistenceMapper = new ContributionPersistenceMapper(trainingPersistenceMapper);
        userPersistenceMapper = new UserPersistenceMapper(profilePersistenceMapper, trainingResultsPersistenceMapper,
                                                          contributionPersistenceMapper);
    }

    @Test
    public void testMapTo(){

        final UserControllerModel userControllerModel = new UserControllerModel();
        userControllerModel.setFname("Jack");
        userControllerModel.setLname("Johnson");
        userControllerModel.setUserReference("userReference");
        userControllerModel.setEmail("jack_johnson3");
        final ProfileControllerModel profileControllerModel = new ProfileControllerModel();
        profileControllerModel.setAbout("about");
        profileControllerModel.setLocation("location");
        profileControllerModel.setProfession("profession");
        profileControllerModel.setRating(4);
        profileControllerModel.setSummary("background");
        final ContributionControllerModel contributionControllerModel = new ContributionControllerModel();
        contributionControllerModel.setContribution("contributing");
        contributionControllerModel.setContributionType(ContributionType.CONCEPT);
        contributionControllerModel.setReference("ref-e12");
        contributionControllerModel.setTrainingArea(TrainingArea.ATTENTION);
        contributionControllerModel.setPrecedingContributionReference(new String[]{"C-149"});
        final TrainingControllerModel trainingControllerModel = new TrainingControllerModel();
        trainingControllerModel.setReference("ref-99");
        trainingControllerModel.setTitle("Title");
        trainingControllerModel.setCreationDate(new Date());
        trainingControllerModel.setRating(5);
        trainingControllerModel.setDescription("description");
        trainingControllerModel.setTrainingArea(TrainingArea.ATTENTION);
        final TrainingResultsControllerModel trainingResultsControllerModel = new TrainingResultsControllerModel();
        trainingResultsControllerModel.setResults(13);

        userControllerModel.setProfileControllerModel(profileControllerModel);
        userControllerModel.setContributionControllerModels(new HashSet<>(Arrays.asList(contributionControllerModel)));
        userControllerModel.setTrainingResultsControllerModels(new HashSet<>(Arrays.asList(trainingResultsControllerModel)));

        final UserPersistenceModel userPersistenceModel = userPersistenceMapper.mapTo(userControllerModel);

    }

    @Test
    public void testMapFrom(){
        final UserPersistenceModel userPersistenceModel = new UserPersistenceModel();
        userPersistenceModel.setFname("Jack");
        userPersistenceModel.setLname("Johnson");
        userPersistenceModel.setUserReference("userReference");
        userPersistenceModel.setPassword("password123");
        userPersistenceModel.setEmail("jack_johnson3");
        final ProfilePersistenceModel profilePersistenceModel = new ProfilePersistenceModel();
        profilePersistenceModel.setSummary("Background");
        profilePersistenceModel.setAbout("about");
        profilePersistenceModel.setLocation("location");
        profilePersistenceModel.setProfession("profession");
        profilePersistenceModel.setRating(5);
        profilePersistenceModel.setSummary("background");
        final ContributionPersistenceModel contributionPersistenceModel = new ContributionPersistenceModel();
        contributionPersistenceModel.setAccepted(false);
        contributionPersistenceModel.setContribution("contributing");
        contributionPersistenceModel.setContributionType(ContributionType.CONCEPT);
        contributionPersistenceModel.setReference("ref-e12");
        contributionPersistenceModel.setTrainingArea(TrainingArea.ATTENTION);
        contributionPersistenceModel.setPrecedingReferences("C-149,");
        final TrainingPersistenceModel trainingPersistenceModel = new TrainingPersistenceModel();
        trainingPersistenceModel.setAccepted(false);
        trainingPersistenceModel.setReference("ref-99");
        trainingPersistenceModel.setTitle("Title");
        trainingPersistenceModel.setCreationDate(new Date());
        trainingPersistenceModel.setRating(5);
        trainingPersistenceModel.setDescription("description");
        trainingPersistenceModel.setTrainingArea(TrainingArea.ATTENTION);
        final TrainingResultsPersistenceModel trainingResultsPersistenceModel = new TrainingResultsPersistenceModel();
        trainingResultsPersistenceModel.setResults(13);

        userPersistenceModel.setProfilePersistenceModel(profilePersistenceModel);
        userPersistenceModel.setContributionPersistenceModels(new HashSet<>(Arrays.asList(contributionPersistenceModel)));
        userPersistenceModel.setTrainingResultsPersistenceModels(new HashSet<>(Arrays.asList(trainingResultsPersistenceModel)));

        profilePersistenceModel.setUserPersistenceModel(userPersistenceModel);

        contributionPersistenceModel.setTrainingPersistenceModel(trainingPersistenceModel);
        contributionPersistenceModel.setUserPersistenceModel(userPersistenceModel);

        trainingPersistenceModel.setContributionPersistenceModel(contributionPersistenceModel);

        trainingResultsPersistenceModel.setTrainingPersistenceModel(trainingPersistenceModel);
        trainingResultsPersistenceModel.setUserPersistenceModel(userPersistenceModel);

        final UserControllerModel userControllerModel = userPersistenceMapper.mapFrom(userPersistenceModel);

        System.out.println(userControllerModel.getContributionControllerModels());
    }
}
