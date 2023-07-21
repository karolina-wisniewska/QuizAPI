package pl.kwisniewska.recruitmenttask.provider.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CorrectAnswersDto {

  @JsonProperty("answer_a_correct")
  private Boolean isACorrect;

  @JsonProperty("answer_b_correct")
  private Boolean isBCorrect;

  @JsonProperty("answer_c_correct")
  private Boolean isCCorrect;

  @JsonProperty("answer_d_correct")
  private Boolean isDCorrect;

  @JsonProperty("answer_e_correct")
  private Boolean isECorrect;

  @JsonProperty("answer_f_correct")
  private Boolean isFCorrect;

}
