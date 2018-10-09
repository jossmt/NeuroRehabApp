package com.app.neurorehab.persistence.test;

import com.app.neurorehab.domain.model.DataTypes.TrainingArea;
import com.app.neurorehab.persistence.model.TrainingPersistenceModel;
import com.app.neurorehab.persistence.repository.TrainingRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ContextConfiguration("classpath*:JDBCConfig.xml")
public class TrainingRepositoryTest {

    private static final Logger LOG = LoggerFactory.getLogger(TrainingRepositoryTest.class);

    @Autowired
    private TrainingRepository trainingRepository;

    @Test
    public void getTraining() {

        final Set<TrainingPersistenceModel> trainingPersistenceModelSet = trainingRepository.findByTrainingArea
                (TrainingArea.ATTENTION.getValue());

        System.out.println("Size : {}" +  trainingPersistenceModelSet.size());
    }
}
