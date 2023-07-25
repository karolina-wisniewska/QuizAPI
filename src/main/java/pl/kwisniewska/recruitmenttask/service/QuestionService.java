package pl.kwisniewska.recruitmenttask.service;

import pl.kwisniewska.recruitmenttask.entity.Question;

import java.util.Set;

public interface QuestionService {
  Question save(Question question);

  Question getRandomQuestion();

  boolean isQuestionPassed(Long questionId, Set<Long> answerIds);
}
