package pl.kwisniewska.recruitmenttask.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Set;

@Data
public class AnswerToCheckDto {

  @NotEmpty
  @NotNull
  private Set<Long> answers;

  @NotNull
  private Long questionId;
}
