package com.quiz.service.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
//DTO class
public class QuizQuestionDto
{
    private int id;

    private String question;

    private String option1;

    private String option2;

    private String option3;

    private String option4;
}
