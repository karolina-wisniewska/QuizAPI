package pl.kwisniewska.recruitmenttask.converter;

import org.springframework.stereotype.Component;
import pl.kwisniewska.recruitmenttask.entity.Answer;
import pl.kwisniewska.recruitmenttask.entity.Question;
import pl.kwisniewska.recruitmenttask.model.ShowAnswerDto;
import pl.kwisniewska.recruitmenttask.model.ShowQuestionDto;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EntityToDtoConverter {

  private ShowAnswerDto convertAnswerToQuizAnswerDto(Answer answer) {
    ShowAnswerDto showAnswerDto = new ShowAnswerDto();
    showAnswerDto.setId(answer.getId());
    showAnswerDto.setAnswer(answer.getAnswer());
    return showAnswerDto;
  }

  public ShowQuestionDto convertQuestionToQuizQuestionDto(Question question) {
    ShowQuestionDto showQuestionDto = new ShowQuestionDto();
    showQuestionDto.setId(question.getId());
    showQuestionDto.setQuestion(question.getQuestion());
    List<Answer> answers = question.getAnswers();
    List<ShowAnswerDto> answerDtos = answers.stream()
            .map(answer -> convertAnswerToQuizAnswerDto(answer))
            .collect(Collectors.toList());
    showQuestionDto.setAnswers(answerDtos);
    return showQuestionDto;
  }
}
