package pl.kwisniewska.recruitmenttask.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kwisniewska.recruitmenttask.entity.Answer;
import pl.kwisniewska.recruitmenttask.repository.AnswerRepository;
import pl.kwisniewska.recruitmenttask.service.AnswerService;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AnswerServiceImpl implements AnswerService {

  private final AnswerRepository answerRepository;

  public Answer save(Answer answer){
    return answerRepository.save(answer);
  }

  public Set<Answer> findCorrectAnswersByQuestionId(Long questionId) {
    Set<Answer> correctAnswers = answerRepository.findAnswersByQuestionId(questionId);
    if(correctAnswers.isEmpty()){
      throw new EntityNotFoundException();
    }
    return correctAnswers.stream()
            .filter(a -> a.isCorrect())
            .collect(Collectors.toSet());
  }

}
