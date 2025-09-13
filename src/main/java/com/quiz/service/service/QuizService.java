package com.quiz.service.service;


import com.quiz.service.dto.QuizQuestionDto;
import com.quiz.service.request.Quizrequest;

import java.util.List;

public interface QuizService
{
    //save quizs
    String saveQuiz(int noofque,String quizName, String category);

    //get quiz question by quiz id
    List<QuizQuestionDto> getQuizQuestion(int quizId);

    //submit quiz
    String submitQuiz(List<Quizrequest> request, int quizId);
}
