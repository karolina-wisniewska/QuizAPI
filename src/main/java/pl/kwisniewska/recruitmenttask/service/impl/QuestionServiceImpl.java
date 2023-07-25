package pl.kwisniewska.recruitmenttask.service.impl;

import jakarta.persistence.EntityNotFoundException;
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
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

  private final QuizProperties quizProperties;
  private final QuestionRepository questionRepository;
  private final AnswerService answerService;

  public Question save(Question question) {
    question.getAnswers().stream()
            .filter(answer -> Objects.nonNull(answer.getAnswer()))
            .forEach(answer -> answerService.save(answer));
    return questionRepository.save(question);
  }

  private Question findById(Long id) {
    return questionRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
  }

  public Question getRandomQuestion(){
    Long randomIndex = getRandomIndex();
    return findById(randomIndex);
  }

  // Jeżeli nie można założyć, że identyfikatory są narastające i nie da się ich usuwać, można przykładowo:
  // 1. Pobrać z bazy wszystkie pytania do kolekcji 'availableQuestions'
  // 2. Wylosować liczbę 'randomId' z zakresu <0, rozmiar kolekcji 'availableQuestions' - 1>
  // 3. Pobrać i zwrócić wartość 'questionId'' z pozycji 'randomId'
  private Long getRandomIndex(){
    int size = quizProperties.getNumberOfQuestions();
    Random random = new Random();
    return (long) (random.nextInt(size) + 1);
  }

  public boolean isQuestionPassed(Long questionId, Set<Long> answerIds) {
    Set<Answer> correctAnswers = answerService.findCorrectAnswersByQuestionId(questionId);
    Set<Long> correctAnswerIds = correctAnswers.stream()
            .map(answer -> answer.getId())
            .collect(Collectors.toSet());
    return correctAnswerIds.equals(answerIds);
  }
}
