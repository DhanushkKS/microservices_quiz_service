package org.dhanush.quiz_service.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ViewQuestionDto {
private int id;
private String option1;
private String option2;
private String option3;
private String option4;

}
