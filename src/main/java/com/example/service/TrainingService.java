package com.example.service;





import java.util.List;



import com.example.entity.TrainingCenter;



//service interface for loose coupling 
public interface TrainingService {

	 // save new training center
    TrainingCenter save(TrainingCenter trainingCenter);

    // fetch all training centers
    List<TrainingCenter> get();

    // fetch centers based on filters (city, state, course)
    List<TrainingCenter> getTrainingCenters(String city, String state, String course);
}
