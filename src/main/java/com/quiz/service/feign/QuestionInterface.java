package com.quiz.service.feign;

import com.quiz.service.dto.QuizQuestionDto;
import com.quiz.service.request.Quizrequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("QUESTION-SERVICE")
public interface QuestionInterface
{
    //get questions api
    @GetMapping("/questions/getQuestions")
    public ResponseEntity<List<Integer>> getQuestionList(@RequestParam(name = "noofque") int noofque,
                                                         @RequestParam(name = "category")String category);
    //getquestions by id .
    //use requestparam for getmapping and requestbody for postmapping
    @PostMapping("/questions/getQuestionsByQuestionId")
    public ResponseEntity<List<QuizQuestionDto>> getQuestionByQUeId(@RequestBody List<Integer> queId);

    //submit or getresult
    @PostMapping("/questions/getResult")
    public ResponseEntity<Integer> getResult(@RequestBody List<Quizrequest> quizrequest);

}
