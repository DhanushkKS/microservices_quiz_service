package org.dhanush.quiz_service.repositories;

import org.dhanush.quiz_monolith.entites.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IQuizRepository extends JpaRepository<Quiz,Integer> {
}
