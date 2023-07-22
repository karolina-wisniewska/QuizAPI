package pl.kwisniewska.recruitmenttask.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kwisniewska.recruitmenttask.entity.Answer;
import pl.kwisniewska.recruitmenttask.repository.AnswerRepository;

import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AnswerService {

  private final AnswerRepository answerRepository;

  public Answer save(Answer answer){
    return answerRepository.save(answer);
  }

  public Set<Answer> findCorrectAnswersByQuestionId(Long questionId) {
    Set<Answer> allAnswers = answerRepository.findAnswersByQuestionId(questionId);
    if(allAnswers.isEmpty()){
      throw new NoSuchElementException();
    }
    return allAnswers.stream()
            .filter(a -> a.isCorrect())
            .collect(Collectors.toSet());
  }

}
