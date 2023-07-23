package pl.kwisniewska.recruitmenttask.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnswerToCheckDto {

  @NotEmpty
  @NotNull
  private Set<Long> answers;

  @NotNull
  private Long questionId;
}
