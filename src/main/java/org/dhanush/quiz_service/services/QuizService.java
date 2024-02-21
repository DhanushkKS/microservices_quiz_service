package org.dhanush.quiz_service.services;

import org.dhanush.quiz_monolith.dtos.ViewQuestionDto;
import org.dhanush.quiz_monolith.entites.Question;
import org.dhanush.quiz_monolith.entites.Quiz;
import org.dhanush.quiz_monolith.entites.Response;
import org.dhanush.quiz_monolith.repositories.IQuestionRepository;
import org.dhanush.quiz_monolith.repositories.IQuizRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    private  IQuizRepository quizRepository;

    @Autowired
    private IQuestionRepository questionRepository;
    @Autowired
    private ModelMapper modelMapper;
//    public QuizService(IQuizRepository quizRepository) {
//        this.quizRepository = quizRepository;
//    }

    public ResponseEntity<String> createQuiz(String category, int size, String title) {
        //get questions
        List<Question> questions = questionRepository.getQuestionsByCategory(category,size);


        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizRepository.save(quiz);
        return new ResponseEntity<>("Quiz "+title+ " created success", HttpStatus.CREATED);

    }

    public ResponseEntity<List<ViewQuestionDto>> getQuizQuestions(int id) {
    Optional<Quiz> quiz = quizRepository.findById(id);
    List<Question> questions = quiz.get().getQuestions();
    List<ViewQuestionDto> questionDtos= modelMapper.map(questions,new TypeToken<List<ViewQuestionDto>>(){}.getType());
    return new ResponseEntity<>(questionDtos,HttpStatus.CREATED);
    }

    public ResponseEntity<Integer> calculateQuiz(int id, List<Response> responses) {

        Quiz quiz = quizRepository.findById(id).get();
        List<Question> questions = quiz.getQuestions();
        int correct = 0;
        int i = 0;
        for (Response response:responses){
            if (response.getResponse().equals(questions.get(i).getRightAnswer())){
                correct++;
            }
            i++;
        }
        return new ResponseEntity<>(correct,HttpStatus.OK);

    }
}
