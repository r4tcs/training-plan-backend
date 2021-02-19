package com.project.trainingplanbackend.controller;

import com.project.trainingplanbackend.model.Exercise;
import com.project.trainingplanbackend.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class ExerciseController {

    @Autowired
    private ExerciseService exerciseService;

    @PostMapping("/add-exercise")
    public void addExercises(@RequestBody Exercise exercise){
        exerciseService.addExercise(exercise);
    }

    @GetMapping("/get-exercise-id")
    public int getExerciseId(){
        return exerciseService.getExerciseId();
    }

    @GetMapping("/get-exercises")
    public List<Exercise> getExercises(@RequestParam int trainingId) {
        return exerciseService.getExercises(trainingId);
    }

    @GetMapping("/get-all-exercises")
    public List<Exercise> getAllExercises() {
        return exerciseService.getAllExercises();
    }

    @GetMapping("/get-distinct-exercises-name")
    public List<Exercise> getDistinctExercisesName() {
        return exerciseService.getDistinctExercisesName();
    }

    @DeleteMapping("/delete-exercise")
    public void deleteExercise(@RequestParam int exerciseId) { exerciseService.deleteExercise(exerciseId); }

    @DeleteMapping("/delete-all-exercises-with-training-id")
    public void deleteAllExercisesWithTrainingId(@RequestParam int trainingId) { exerciseService.deleteAllExercisesWithTrainingId(trainingId); }
}
