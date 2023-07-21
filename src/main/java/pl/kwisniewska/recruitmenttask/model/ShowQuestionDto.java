package pl.kwisniewska.recruitmenttask.model;

import lombok.Data;

import java.util.List;

@Data
public class ShowQuestionDto {

  private Long id;

  private String question;

  private List<ShowAnswerDto> answers;

}
