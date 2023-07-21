package pl.kwisniewska.recruitmenttask.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kwisniewska.recruitmenttask.entity.Question;
import pl.kwisniewska.recruitmenttask.repository.QuestionRepository;

import java.util.Objects;
import java.util.Optional;
import java.util.Random;

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

  private Optional<Question> findById(Long id) {
    return questionRepository.findById(id);
  }

  private long count(){
    return questionRepository.count();
  }

  public Optional<Question> getRandom(){
    Long randomIndex = getRandomIndex();
    return findById(randomIndex);
  }

  private Long getRandomIndex(){
    long size = count();
    Random random = new Random();
    return random.nextLong(size) + 1;
  }
}
