package org.dhanush.quiz_service.services;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.dhanush.quiz_service.dtos.QuizDto;
import org.dhanush.quiz_service.dtos.ViewQuestionDto;
import org.dhanush.quiz_service.entites.Quiz;
import org.dhanush.quiz_service.entites.Response;
import org.dhanush.quiz_service.feign.IQuiz;
import org.dhanush.quiz_service.repositories.IQuizRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    private IQuizRepository quizRepository;
    @Autowired
    private IQuiz iQuiz;

//    @Autowired
//    private IQuestionRepository questionRepository;
    @Autowired
    private ModelMapper modelMapper;
//    public QuizService(IQuizRepository quizRepository) {
//        this.quizRepository = quizRepository;
//    }

    public ResponseEntity<String> createQuiz(QuizDto quizDto) {
        List<Integer> questions = iQuiz.getQuestionsForQuiz(quizDto.getCategory(),quizDto.getSize()).getBody();
        String title = quizDto.getTitle();
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionIds(questions);
        quizRepository.save(quiz);
        return new ResponseEntity<>("Quiz "+title+ " created success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<ViewQuestionDto>> getQuizQuestions(int id) {
    Optional<Quiz> quiz = quizRepository.findById(id);
    List<Integer> questionIds = quiz.get().getQuestionIds();
    ResponseEntity<List<ViewQuestionDto>> questions = iQuiz.getQuestionsFromId(questionIds);
    return questions;
    }

    public ResponseEntity<Integer> calculateQuiz(int id, List<Response> responses) {

       Quiz quiz = quizRepository.findById(id).get();
        ResponseEntity<Integer> score = iQuiz.getScore(responses);

        return score;

    }
}
