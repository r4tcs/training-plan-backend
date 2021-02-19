package com.project.trainingplanbackend.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Set;

@Entity
public class Training {

    @Id
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private String startTime;

    @Column(nullable = false)
    private String endTime;

    public String getEndTime() { return endTime; }

    public void setEndTime(String endTime) { this.endTime = endTime; }

    public Integer getId() {
        return id;
    }

    public String getStartTime() { return startTime; }

    public void setStartTime(String time) { this.startTime = time; }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() { return date; }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public static Comparator<Training> TrainingTimeComparator =
            (training1, training2) -> {
                String trainingTime1 = training1.getStartTime();
                if(trainingTime1.length() == 4){
                    trainingTime1 = '0' + trainingTime1;
                }
                String trainingTime2 = training2.getStartTime();
                if(trainingTime2.length() == 4){
                    trainingTime2 = '0' + trainingTime1;
                }
                return trainingTime1.compareTo(trainingTime2);
            };
}
