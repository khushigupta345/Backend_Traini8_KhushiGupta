package com.example.repository;





import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.entity.TrainingCenter;
//for crud operation
@Repository
public interface TrainingRepository extends JpaRepository<TrainingCenter, Long> {
   //fetch based on city
    List<TrainingCenter> findByAddress_City(String city);
    //fetch based on state
    List<TrainingCenter> findByAddress_State(String state);
    //fetch based on course 
    List<TrainingCenter> findByCoursesOfferedContaining(String course);
    //fetch based on city address state
    List<TrainingCenter> findByAddress_CityAndAddress_State(String city, String state);

    List<TrainingCenter> findByAddress_CityAndAddress_StateAndCoursesOfferedContaining(String city, String state, String course);

}
