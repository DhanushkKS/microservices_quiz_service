package org.dhanush.quiz_service.dtos;

import lombok.Data;

@Data
public class QuizDto {
    private String category;
    private String title;
    private int size;
}
