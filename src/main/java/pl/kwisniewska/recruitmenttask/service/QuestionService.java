package pl.kwisniewska.recruitmenttask.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kwisniewska.recruitmenttask.entity.Question;
import pl.kwisniewska.recruitmenttask.repository.QuestionRepository;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class QuestionService {

  private final QuestionRepository questionRepository;
  private final AnswerService answerService;

  public Question save(Question question) {
    question.getAnswers().stream()
            .forEach(answer -> {
              if(Objects.nonNull(answer.getAnswer())){
                answerService.save(answer);
              }
            });
    return questionRepository.save(question);
  }
}
