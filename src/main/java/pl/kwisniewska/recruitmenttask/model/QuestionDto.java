package pl.kwisniewska.recruitmenttask.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuestionDto {

  private Long id;

  private String question;

  private AnswersDto answers;

  @JsonProperty("correct_answers")
  private CorrectAnswersDto correctAnswers;
}
