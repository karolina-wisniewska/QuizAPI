package pl.kwisniewska.recruitmenttask.service.impl;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kwisniewska.recruitmenttask.entity.Answer;
import pl.kwisniewska.recruitmenttask.entity.Question;
import pl.kwisniewska.recruitmenttask.properties.QuizProperties;
import pl.kwisniewska.recruitmenttask.repository.QuestionRepository;
import pl.kwisniewska.recruitmenttask.service.AnswerService;
import pl.kwisniewska.recruitmenttask.service.QuestionService;

import java.util.Objects;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

  private final QuizProperties quizProperties;
  private final QuestionRepository questionRepository;
  private final AnswerService answerService;

  @Override
  public Question save(Question question) {
    question.getAnswers().stream()
            .filter(answer -> Objects.nonNull(answer.getAnswer()))
            .forEach(answer -> answerService.save(answer));
    return questionRepository.save(question);
  }

  private Question findById(Long id) {
    return questionRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Question number " + id + "does not exist"));
  }

  @Override
  public Question getRandomQuestion(){
    Long randomIndex = getRandomIndex();
    return findById(randomIndex);
  }

  private Long getRandomIndex(){
    int size = quizProperties.getNumberOfQuestions();
    Random random = new Random();
    return (long) (random.nextInt(size) + 1);
  }

  @Override
  public boolean isQuestionPassed(Long questionId, Set<Long> answerIds) {
    Set<Answer> correctAnswers = answerService.findCorrectAnswersByQuestionId(questionId);
    Set<Long> correctAnswerIds = correctAnswers.stream()
            .map(answer -> answer.getId())
            .collect(Collectors.toSet());
    return correctAnswerIds.equals(answerIds);
  }
}
