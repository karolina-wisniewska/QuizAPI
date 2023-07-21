package pl.kwisniewska.recruitmenttask.converter;

import org.springframework.stereotype.Component;
import pl.kwisniewska.recruitmenttask.entity.Answer;
import pl.kwisniewska.recruitmenttask.entity.Question;
import pl.kwisniewska.recruitmenttask.model.AnswerToShowDto;
import pl.kwisniewska.recruitmenttask.model.QuestionToShowDto;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EntityToDtoConverter {

  private AnswerToShowDto convertAnswerToQuizAnswerDto(Answer answer) {
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
            .map(answer -> convertAnswerToQuizAnswerDto(answer))
            .collect(Collectors.toList());
    questionToShowDto.setAnswers(answerDtos);
    return questionToShowDto;
  }
}
