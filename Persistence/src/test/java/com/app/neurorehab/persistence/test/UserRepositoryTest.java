package com.app.neurorehab.persistence.test;

import com.app.neurorehab.domain.model.DataTypes.ContributionType;
import com.app.neurorehab.domain.model.DataTypes.TrainingArea;
import com.app.neurorehab.persistence.model.*;
import com.app.neurorehab.persistence.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ContextConfiguration("classpath*:JDBCConfig.xml")
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

//    @Rollback(false)
    @Test
    public void nestedSaveTest() {

        final UserPersistenceModel userPersistenceModel = new UserPersistenceModel();
        userPersistenceModel.setFname("Joss");
        userPersistenceModel.setLname("MT");
        userPersistenceModel.setUserReference("reference");
        userPersistenceModel.setPassword("password123");
        userPersistenceModel.setEmail("jossmt");
        final ProfilePersistenceModel profilePersistenceModel = new ProfilePersistenceModel();
        profilePersistenceModel.setSummary("Background Joss");
        profilePersistenceModel.setAbout("about joss");
        profilePersistenceModel.setLocation("joss location");
        profilePersistenceModel.setProfession("joss profession");
        profilePersistenceModel.setRating(4);
        final ContributionPersistenceModel contributionPersistenceModel = new ContributionPersistenceModel();
        contributionPersistenceModel.setAccepted(true);
        contributionPersistenceModel.setContribution("This is the contribution of Joss.");
        contributionPersistenceModel.setContributionType(ContributionType.TESTCASE);
        contributionPersistenceModel.setTitle("This is a contribution title of Joss.");
        contributionPersistenceModel.setReference("ref-e134");
        contributionPersistenceModel.setTrainingArea(TrainingArea.ATTENTION);
        final TrainingPersistenceModel trainingPersistenceModel = new TrainingPersistenceModel();
        trainingPersistenceModel.setAccepted(false);
        trainingPersistenceModel.setReference("ref-928");
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

        userRepository.save(userPersistenceModel);

    }

    @Transactional
    @Test
    public void testContributionAdd(){
        final UserPersistenceModel userPersistenceModel = new UserPersistenceModel();
        userPersistenceModel.setFname("Joss");
        userPersistenceModel.setLname("MT");
        userPersistenceModel.setUserReference("reference");
        userPersistenceModel.setPassword("password123");
        userPersistenceModel.setEmail("jossmt");

        final ContributionPersistenceModel contributionPersistenceModel = new ContributionPersistenceModel();
        contributionPersistenceModel.setAccepted(true);
        contributionPersistenceModel.setContribution("This is the contribution of Joss.");
        contributionPersistenceModel.setContributionType(ContributionType.TESTCASE);
        contributionPersistenceModel.setTitle("This is a contribution title of Joss.");
        contributionPersistenceModel.setReference("ref-e134");
        contributionPersistenceModel.setTrainingArea(TrainingArea.ATTENTION);

        final UserPersistenceModel persistedModel = userRepository.save(userPersistenceModel);

        persistedModel.addContributionPersistenceModel(contributionPersistenceModel);
    }

    @Rollback(false)
    @Transactional
//    @Test
    public void updatePassword(){

        final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        final UserPersistenceModel userPersistenceModel = userRepository.findByEmail("jack_johnson3");

        final String newPassword = passwordEncoder.encode("dollar123");

        userPersistenceModel.setPassword(newPassword);
    }
}
