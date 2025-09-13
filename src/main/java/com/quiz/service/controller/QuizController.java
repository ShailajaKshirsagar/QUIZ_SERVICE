package com.quiz.service.controller;

import com.quiz.service.dto.QuizQuestionDto;
import com.quiz.service.request.Quizrequest;
import com.quiz.service.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    //create quiz api
    @PostMapping("/createQuiz")
    public ResponseEntity<String> createQuiz(@RequestParam(required = true) int noofque, @RequestParam(required = true)String quizName,
                                             @RequestParam(required = true)String category){

      String msg  = quizService.saveQuiz(noofque,quizName,category);
      return new ResponseEntity<>(msg,HttpStatus.OK);
    }

    //getquizquestions api
    @GetMapping("/getQuizQuestions/{id}")
    public ResponseEntity<List<QuizQuestionDto>> getQuizQuestion(@PathVariable("id") int quizId) {
        List<QuizQuestionDto> questions = quizService.getQuizQuestion(quizId);
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    //submit quiz api
    @PostMapping("/submitAns/{id}")
    public  ResponseEntity<String> submitAns(@RequestBody List<Quizrequest> quizrequest, @PathVariable("id") int quizId){
        String msg = quizService.submitQuiz(quizrequest,quizId);
        return new ResponseEntity<>(msg,HttpStatus.OK);
    }
}
