package com.project.trainingplanbackend.repositories;

import com.project.trainingplanbackend.model.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TrainingRepository extends JpaRepository<Training, Integer> {
    List<Training> findByDate(LocalDate date);
    List<Training> findAllByDateBetween(LocalDate date1, LocalDate date2);
    @Query(value = "select COALESCE(MAX(id),0) AS id FROM Training")
    int getTrainingId();
    Training getTrainingByIdIs(int Id);
}