package com.quiz.service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

//Entity class
@Setter
@Getter
public class Questions {

    private int id;

    private String question;

    private String option1;

    private String option2;

    private String option3;

    private String option4;

    private int correct_option;

    private String category;

    private String difficulty_level;

}
