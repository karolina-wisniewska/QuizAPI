package pl.kwisniewska.recruitmenttask.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.kwisniewska.recruitmenttask.entity.Answer;
import pl.kwisniewska.recruitmenttask.entity.Question;
import pl.kwisniewska.recruitmenttask.model.AnswersDto;
import pl.kwisniewska.recruitmenttask.model.CorrectAnswersDto;
import pl.kwisniewska.recruitmenttask.model.QuestionDto;

import java.util.List;

@Component
@RequiredArgsConstructor
public class QuestionDtoToQuestionConverter {

  private final AnswersDtoToAnswerListConverter converter;

  public Question convert(QuestionDto questionDto) {
    Question question = new Question();
    question.setApiId(questionDto.getId());
    question.setQuestion(questionDto.getQuestion());

    AnswersDto answersDto = questionDto.getAnswers();
    CorrectAnswersDto correctAnswersDto = questionDto.getCorrectAnswers();
    List<Answer> answers = converter.convert(answersDto, correctAnswersDto);

    question.setAnswers(answers);

    return question;
  }
}
