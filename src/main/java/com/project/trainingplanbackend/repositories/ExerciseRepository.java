package com.project.trainingplanbackend.repositories;

import com.project.trainingplanbackend.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Integer> {
    @Query("select COALESCE(MAX(id),0) AS id FROM Exercise")
    int getExerciseId();
    List<Exercise> getExercisesByTrainingID(int trainingId);
    @Transactional
    void deleteExercisesByTrainingID(int trainingId);
    @Query("select e from Exercise e" +
            " group by e.name")
    List<Exercise> getDistinctByName();
}
