package pl.kwisniewska.recruitmenttask.model;

import lombok.Data;

import java.util.List;

@Data
public class AnswerToCheckDto {

  private List<Long> answers;
  private Long questionId;
}
