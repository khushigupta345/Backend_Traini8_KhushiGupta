package com.example.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.entity.TrainingCenter;
import com.example.repository.TrainingRepository;
import com.example.service.TrainingService;

import java.util.List;

@Service
public class TrainingServiceImpl implements TrainingService {

    @Autowired
    private TrainingRepository repository;
    // saving new center
    @Override
    public TrainingCenter save(TrainingCenter trainingCenter) {
        return repository.save(trainingCenter);
    }
 // fetch all centers
    @Override
    public List<TrainingCenter> get() {
        return repository.findAll(); 
    }

	@Override
	public List<TrainingCenter> getTrainingCenters(String city, String state, String course) {
	    //fetch based on state, city, course
        if (city != null && state != null && course != null) {
            return repository.findByAddress_CityAndAddress_StateAndCoursesOfferedContaining(city, state, course);
        }
        //fetch based on state and city
        if (city != null && state != null) {
            return repository.findByAddress_CityAndAddress_State(city, state);
        }
        //fetch based on city
        if (city != null) {
            return repository.findByAddress_City(city);
        }
        //fetch based on state
        if (state != null) {
            return repository.findByAddress_State(state);
        }
        //fetch based on course
        if (course != null) {
            return repository.findByCoursesOfferedContaining(course);
        }
		return repository.findAll();
	}

	
}

