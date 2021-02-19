package com.project.trainingplanbackend.service;

import com.project.trainingplanbackend.model.Exercise;
import com.project.trainingplanbackend.repositories.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseService {

    @Autowired
    private ExerciseRepository exerciseRepository;

    public void addExercise(Exercise exercise) {
        exerciseRepository.save(exercise);
    }

    public int getExerciseId() {
        return exerciseRepository.getExerciseId();
    }

    public List<Exercise> getExercises(int trainingId) {
        return exerciseRepository.getExercisesByTrainingID(trainingId);
    }

    public List<Exercise> getAllExercises() {
        return exerciseRepository.findAll();
    }

    public void deleteExercise(int exerciseId){
        exerciseRepository.deleteById(exerciseId);
    }

    public void deleteAllExercisesWithTrainingId(int trainingId){
        exerciseRepository.deleteExercisesByTrainingID(trainingId);
    }

    public List<Exercise> getDistinctExercisesName() {
        return exerciseRepository.getDistinctByName();
    }
}
