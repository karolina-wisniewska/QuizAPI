package pl.kwisniewska.recruitmenttask.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kwisniewska.recruitmenttask.entity.Answer;
import pl.kwisniewska.recruitmenttask.repository.AnswerRepository;

@Service
@RequiredArgsConstructor
public class AnswerService {

  private final AnswerRepository answerRepository;

  public Answer save(Answer answer){
    return answerRepository.save(answer);
  }
}
