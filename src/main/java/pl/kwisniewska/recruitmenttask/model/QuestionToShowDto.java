package pl.kwisniewska.recruitmenttask.model;

import lombok.Data;

import java.util.List;

@Data
public class QuestionToShowDto {

  private Long id;

  private String question;

  private List<AnswerToShowDto> answers;

}
