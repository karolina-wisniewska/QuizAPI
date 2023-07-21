package pl.kwisniewska.recruitmenttask.model;

import lombok.Data;

import java.util.Set;

@Data
public class AnswerToCheckDto {

  private Set<Long> answers;
  private Long questionId;
}
