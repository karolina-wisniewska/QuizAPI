package pl.kwisniewska.recruitmenttask.service.impl;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kwisniewska.recruitmenttask.entity.Answer;
import pl.kwisniewska.recruitmenttask.repository.AnswerRepository;
import pl.kwisniewska.recruitmenttask.service.AnswerService;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class AnswerServiceImpl implements AnswerService {

  private final AnswerRepository answerRepository;

  public Answer save(Answer answer) {
    return answerRepository.save(answer);
  }

  @Override
  public Set<Answer> findCorrectAnswersByQuestionId(Long questionId) {
    Set<Answer> correctAnswers = answerRepository.findAnswersByQuestionId(questionId);
    if (correctAnswers.isEmpty()) {
      throw new EntityNotFoundException("Question number " + questionId + " does not exist");
    }
    return correctAnswers.stream()
            .filter(a -> a.isCorrect())
            .collect(Collectors.toSet());
  }

}
