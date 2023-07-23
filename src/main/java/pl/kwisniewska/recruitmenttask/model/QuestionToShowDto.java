package pl.kwisniewska.recruitmenttask.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionToShowDto {

  private Long id;

  private String question;

  private List<AnswerToShowDto> answers;

}
