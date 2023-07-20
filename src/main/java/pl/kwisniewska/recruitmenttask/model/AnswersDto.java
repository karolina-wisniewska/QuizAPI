package pl.kwisniewska.recruitmenttask.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AnswersDto {

  @JsonProperty("answer_a")
  private String answerA;

  @JsonProperty("answer_b")
  private String answerB;

  @JsonProperty("answer_c")
  private String answerC;

  @JsonProperty("answer_d")
  private String answerD;

  @JsonProperty("answer_e")
  private String answerE;

  @JsonProperty("answer_f")
  private String answerF;
}
