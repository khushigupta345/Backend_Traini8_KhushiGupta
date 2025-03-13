package com.example.controller;



import com.example.entity.TrainingCenter;
import com.example.service.TrainingService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class TrainingController {

    @Autowired
    private TrainingService service;

    // for creating new training center
    @PostMapping(value = "/traingpost",consumes = "application/json;charset=UTF-8")
    public ResponseEntity<TrainingCenter> createTrainingCenter(@Valid @RequestBody TrainingCenter trainingCenter) {
    	System.out.println(trainingCenter.getContactPhone());
        TrainingCenter tc= service.save(trainingCenter);
        return ResponseEntity.ok(tc);
    }

//retrieve data from database
    @GetMapping("/list")
    public ResponseEntity<List<TrainingCenter>> getTrainingCentersList(
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String state,
            @RequestParam(required = false) String course) {

        List<TrainingCenter> centers = service.getTrainingCenters(city, state, course);
     // no data found
        if (centers.isEmpty()) {
            return ResponseEntity.noContent().build(); 
        }
     // return list of centers

        return ResponseEntity.ok(centers); 
    }

}