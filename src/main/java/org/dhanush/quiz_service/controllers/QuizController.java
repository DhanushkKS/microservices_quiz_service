package org.dhanush.quiz_service.controllers;

import org.dhanush.quiz_monolith.dtos.ViewQuestionDto;
import org.dhanush.quiz_monolith.entites.Response;
import org.dhanush.quiz_monolith.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/quiz")
public class QuizController {
@Autowired
private  QuizService quizService;


    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category,@RequestParam int size,@RequestParam String title){
        return quizService.createQuiz(category,size,title);
    }
    @GetMapping("/{id}")
    public ResponseEntity<List<ViewQuestionDto>> getQuiz(@PathVariable int id){
        return quizService.getQuizQuestions(id);
    }

    @PostMapping("/submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable int id, @RequestBody List<Response>  responses){
        return quizService.calculateQuiz(id,responses);
    }
}
