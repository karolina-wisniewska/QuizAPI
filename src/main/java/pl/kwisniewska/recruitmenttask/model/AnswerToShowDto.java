package pl.kwisniewska.recruitmenttask.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnswerToShowDto {

  private Long id;

  private String answer;
}
