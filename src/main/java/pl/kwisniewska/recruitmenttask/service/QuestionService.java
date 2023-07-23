package pl.kwisniewska.recruitmenttask.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kwisniewska.recruitmenttask.entity.Answer;
import pl.kwisniewska.recruitmenttask.entity.Question;
import pl.kwisniewska.recruitmenttask.repository.QuestionRepository;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuestionService {

  private final QuestionRepository questionRepository;
  private final AnswerService answerService;

  public Question save(Question question) {
    question.getAnswers().stream()
            .filter(answer -> Objects.nonNull(answer.getAnswer()))
            .forEach(answer -> answerService.save(answer));
    return questionRepository.save(question);
  }

  private Question findById(Long id) {
    return questionRepository.findById(id).orElseThrow(NoSuchElementException::new);
  }

  private long count(){
    return questionRepository.count();
  }

  public Question getRandomQuestion(){
    Long randomIndex = getRandomIndex();
    return findById(randomIndex);
  }

  // Jeżeli nie można założyć, że identyfikatory są narastające i nie da się ich usuwać, można przykładowo:
  // 1. Pobrać z bazy wszystkie pytania do kolekcji 'availableQuestions'
  // 2. Wylosować liczbę 'randomId' z zakresu <1, rozmiar kolekcji 'availableQuestions'>
  // 3. Pobrać i zwrócić wartość 'questionId'' z pozycji 'randomId'
  private Long getRandomIndex(){
    int size = (int) count();
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
