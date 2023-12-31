package pl.kwisniewska.recruitmenttask.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProviderQuestionDto {

  private Long id;

  private String question;

  private Map<String, String> answers;

  @JsonProperty("correct_answers")
  private Map<String, Boolean> correctAnswers;

}
