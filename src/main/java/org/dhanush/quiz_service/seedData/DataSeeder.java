package org.dhanush.quiz_service.seedData;

import org.dhanush.quiz_monolith.entites.Question;
import org.dhanush.quiz_monolith.repositories.IQuestionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataSeeder implements CommandLineRunner {


    private final IQuestionRepository questionRepository;

    public DataSeeder(IQuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Question[] dummyQuestions = {
                new Question(1, "java", "easy", "Object-oriented programming language", "Integrated development environment", "Java Development Kit", "None of the above", "What does JDK stand for?", "Java Development Kit"),
                new Question(2, "python", "medium", "A data structure", "A looping construct", "A way to perform list comprehension", "None of the above", "What is a list comprehension in Python?", "A way to perform list comprehension"),
                new Question(3, "c#", "hard", "A type of loop", "A programming language", "An object-oriented database management system", "None of the above", "What is C#?", "A programming language"),
                new Question(4, "java", "easy", "Object-oriented programming language", "Integrated development environment", "Java Development Kit", "None of the above", "What does JDK stand for?", "None of the above"),
                new Question(5, "python", "medium", "A data structure", "A looping construct", "A way to perform list comprehension", "None of the above", "What is a list comprehension in Python?", "Object-oriented programming language"),
                new Question(6, "c#", "hard", "A type of loop", "A programming language", "An object-oriented database management system", "None of the above", "What is C#?", "A type of loop"),
                new Question(7, "java", "easy", "Object-oriented programming language", "Integrated development environment", "Java Development Kit", "None of the above", "What does JDK stand for?", "An object-oriented database management system"),
                new Question(8, "python", "medium", "A data structure", "A looping construct", "A way to perform list comprehension", "None of the above", "What is a list comprehension in Python?", "Integrated development environment"),
                new Question(9, "c#", "hard", "A type of loop", "A programming language", "An object-oriented database management system", "None of the above", "What is C#?", "A way to perform list comprehension"),
                new Question(10, "java", "easy", "Object-oriented programming language", "Integrated development environment", "Java Development Kit", "None of the above", "What does JDK stand for?", "A programming language"),
                new Question(11, "html", "easy", "Hypertext Markup Language", "Hypertext Transfer Protocol", "High-level programming language", "None of the above", "What does HTML stand for?", "Hypertext Markup Language"),
                new Question(12, "php", "medium", "Personal Home Page", "Hypertext Preprocessor", "Private Home Page", "None of the above", "What does PHP stand for?", "Hypertext Preprocessor"),
                new Question(13, "javascript", "hard", "A scripting language", "A programming language", "A markup language", "None of the above", "What is JavaScript?", "A scripting language"),
                new Question(14, "html", "easy", "Hypertext Markup Language", "Hypertext Transfer Protocol", "High-level programming language", "None of the above", "What does HTML stand for?", "Hypertext Transfer Protocol"),
                new Question(15, "php", "medium", "Personal Home Page", "Hypertext Preprocessor", "Private Home Page", "None of the above", "What does PHP stand for?", "Private Home Page"),
                new Question(16, "javascript", "hard", "A scripting language", "A programming language", "A markup language", "None of the above", "What is JavaScript?", "A programming language"),
                new Question(17, "html", "easy", "Hypertext Markup Language", "Hypertext Transfer Protocol", "High-level programming language", "None of the above", "What does HTML stand for?", "None of the above"),
                new Question(18, "php", "medium", "Personal Home Page", "Hypertext Preprocessor", "Private Home Page", "None of the above", "What does PHP stand for?", "Hypertext Preprocessor"),
                new Question(19, "javascript", "hard", "A scripting language", "A programming language", "A markup language", "None of the above", "What is JavaScript?", "A markup language"),
                new Question(20, "html", "easy", "Hypertext Markup Language", "Hypertext Transfer Protocol", "High-level programming language", "None of the above", "What does HTML stand for?", "High-level programming language")
        };
        questionRepository.saveAll(Arrays.asList(dummyQuestions));

    }
}
