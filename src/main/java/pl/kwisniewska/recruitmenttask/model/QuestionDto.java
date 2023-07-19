package pl.kwisniewska.recruitmenttask.model;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;
import pl.kwisniewska.recruitmenttask.entity.Answer;

import java.util.ArrayList;
import java.util.List;

@Data
public class QuestionDto {

  private Long id;

  private String question;

  private List<AnswerDto> answers;

}
