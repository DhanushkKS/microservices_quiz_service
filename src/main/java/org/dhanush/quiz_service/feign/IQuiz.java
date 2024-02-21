package org.dhanush.quiz_service.feign;

import org.dhanush.quiz_service.dtos.ViewQuestionDto;
import org.dhanush.quiz_service.entites.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("QUESTION-SERVICE")
public interface IQuiz {
    String baseUrl = "api/v1/question/";

    @GetMapping(baseUrl+"generate")
    ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String category, @RequestParam int size);
    //get questions(qusetion id)

    @PostMapping(baseUrl+"getQuestions")
    ResponseEntity<List<ViewQuestionDto>> getQuestionsFromId(@RequestBody List<Integer> questionIds);
    //calculate answeres
    @PostMapping(baseUrl+"getScore")
    ResponseEntity<Integer> getScore(@RequestBody List<Response> responses);

}
