package com.quiz.service.serviceImpl;


import com.quiz.service.dto.QuizQuestionDto;
import com.quiz.service.entity.Questions;
import com.quiz.service.entity.Quiz;
import com.quiz.service.feign.QuestionInterface;
import com.quiz.service.repository.QuizRepository;
import com.quiz.service.request.Quizrequest;
import com.quiz.service.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizServiceImpl implements QuizService
{
    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private QuestionInterface questionInterface;

    //save quiz with title ,noofque , categorybmodified
    @Override
    public String saveQuiz(int noofque, String quizName, String category) {

        //List<Questions> questionsList = quizRepository.findRandomQuestion(noofque,category);

        Quiz quiz = new Quiz();
        quiz.setTitle(quizName);

        //API By using feign client
        List<Integer> questionList  = questionInterface.getQuestionList(noofque, category).getBody();

//        quiz.setNoOfQue(noofque);
//        quiz.setCategory(category);

        quiz.setQuestionsList(questionList);
//
        quizRepository.save(quiz);
        return "Quiz is created";
    }

    //get quiz question with id method
    @Override
    public List<QuizQuestionDto> getQuizQuestion(int quizId) {

        //because quiz questions will be retriend from questions table so we have to use that repo

        Quiz quiz = quizRepository.findById(quizId).get();
        List<Integer> questionsIdList = quiz.getQuestionsList();
        List<QuizQuestionDto> body = questionInterface.getQuestionByQUeId(questionsIdList).getBody();
        return body;

        //List<QuizQuestionDto> dtoList = new ArrayList<>();
//
//        for( Questions questions :questionsList){
//            QuizQuestionDto dto = new QuizQuestionDto();
//            dto.setId(questions.getId());
//            dto.setQuestion(questions.getQuestion());
//            dto.setOption1(questions.getOption1());
//            dto.setOption2(questions.getOption2());
//            dto.setOption3(questions.getOption3());
//            dto.setOption4(questions.getOption4());
//            dtoList.add(dto);
//        }

    }


    //submit quiz implemented
    @Override
    public String submitQuiz(List<Quizrequest> request, int quizId) {

        ResponseEntity<Integer> result = questionInterface.getResult(request);

        String msg = "Your result is :" + result.getBody();

        return msg;

//        int correctAnswer = 0;
//        for(Questions q:questionListOfQuiz){
//            for(Quizrequest quizRequest :request ){
//                if(quizRequest.getQueId() == q.getId()){
//                    if(quizRequest.getSelectedOption() == q.getCorrect_option()){
//                        correctAnswer++;
//                    }
//                }
//            }
//        }
//        String msg = "Your score is : " + correctAnswer;
//
//        return msg;

    }
}
