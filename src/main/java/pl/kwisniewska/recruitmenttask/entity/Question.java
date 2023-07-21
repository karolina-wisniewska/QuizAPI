package pl.kwisniewska.recruitmenttask.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Question {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "api_id")
  private Long apiId;

  private String question;

  @OneToMany
  @JoinColumn(name = "question_id")
  private List<Answer> answers;
}
