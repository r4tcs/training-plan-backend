package com.project.trainingplanbackend.controller;

import com.project.trainingplanbackend.model.Training;
import com.project.trainingplanbackend.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class TrainingController {

    @Autowired
    private TrainingService trainingService;

    @GetMapping("/get-all-trainings")
    public List<Training> getAllTrainings(@RequestParam String monday, String sunday) {
        return trainingService.getAllTrainings(monday, sunday);
    }

    @GetMapping("/get-day-trainings")
    public List<Training> getMondayTrainings(@RequestParam String date) {
        return trainingService.getTrainings(date);
    }

    @GetMapping("/get-training-id")
    public int getTrainingId(){
        return trainingService.getTrainingId();
    }

    @GetMapping("/get-trainings-by-id")
    public List<Training> getTrainingsById(@RequestParam int[] trainingID){
        return trainingService.getTrainingsById(trainingID);
    }

    @PostMapping("/add-training")
    public void addTraining(@RequestBody Training training) {
        trainingService.addTraining(training);
    }

    @DeleteMapping("/delete-training")
    public void deleteTraining(@RequestParam int trainingId){
        trainingService.deleteTraining(trainingId);
    }
}
