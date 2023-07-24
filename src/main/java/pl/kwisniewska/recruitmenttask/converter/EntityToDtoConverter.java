package pl.kwisniewska.recruitmenttask.converter;

import org.springframework.stereotype.Component;
import pl.kwisniewska.recruitmenttask.entity.Answer;
import pl.kwisniewska.recruitmenttask.entity.Question;
import pl.kwisniewska.recruitmenttask.model.AnswerToShowDto;
import pl.kwisniewska.recruitmenttask.model.CheckDto;
import pl.kwisniewska.recruitmenttask.model.QuestionToShowDto;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EntityToDtoConverter {

  private AnswerToShowDto convertAnswerToAnswerToShowDto(Answer answer) {
    AnswerToShowDto answerToShowDto = new AnswerToShowDto();
    answerToShowDto.setId(answer.getId());
    answerToShowDto.setAnswer(answer.getAnswer());
    return answerToShowDto;
  }

  public QuestionToShowDto convertQuestionToQuizQuestionDto(Question question) {
    QuestionToShowDto questionToShowDto = new QuestionToShowDto();
    questionToShowDto.setId(question.getId());
    questionToShowDto.setQuestion(question.getQuestion());
    List<Answer> answers = question.getAnswers();
    List<AnswerToShowDto> answerDtos = answers.stream()
            .map(answer -> convertAnswerToAnswerToShowDto(answer))
            .collect(Collectors.toList());
    questionToShowDto.setAnswers(answerDtos);
    return questionToShowDto;
  }

  public CheckDto convertBooleanToCheckDto(boolean isPassed) {
    CheckDto checkDto = new CheckDto();
    checkDto.setCorrect(isPassed);
    return checkDto;
  }
}
