package pl.kwisniewska.recruitmenttask.service;

import pl.kwisniewska.recruitmenttask.entity.Answer;

import java.util.Set;

public interface AnswerService {

  Answer save(Answer answer);

  Set<Answer> findCorrectAnswersByQuestionId(Long questionId);
}
