package com.project.trainingplanbackend.service;

import com.project.trainingplanbackend.model.Training;
import com.project.trainingplanbackend.repositories.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class TrainingService {

    @Autowired
    private TrainingRepository trainingRepository;

    public List<Training> getAllTrainings(String monday, String sunday){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate mondayLocalDate = LocalDate.parse(monday,dtf);
        LocalDate sundayLocalDate = LocalDate.parse(sunday,dtf);
        return trainingRepository.findAllByDateBetween(mondayLocalDate, sundayLocalDate);
    }

    public List<Training> getTrainings(String data) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dataLocalDate = LocalDate.parse(data,dtf);
        List<Training> trainingList = trainingRepository.findByDate(dataLocalDate);
        trainingList.sort(Training.TrainingTimeComparator);
        return trainingList;
    }

    public int getTrainingId() {
        return trainingRepository.getTrainingId();
    }

    public void addTraining(Training training) {
        trainingRepository.save(training);
    }

    public void deleteTraining(int trainingId){
        trainingRepository.deleteById(trainingId);
    }

    public List<Training> getTrainingsById(int[] trainingID) {
        ArrayList<Training> trainings = new ArrayList();
        for (int value : trainingID) {
            trainings.add(trainingRepository.getTrainingByIdIs(value));
        }
        return trainings;
    }

}