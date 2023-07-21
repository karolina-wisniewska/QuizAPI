package pl.kwisniewska.recruitmenttask.converter;

import org.springframework.stereotype.Component;
import pl.kwisniewska.recruitmenttask.entity.Answer;
import pl.kwisniewska.recruitmenttask.entity.Question;
import pl.kwisniewska.recruitmenttask.provider.model.AnswersDto;
import pl.kwisniewska.recruitmenttask.provider.model.CorrectAnswersDto;
import pl.kwisniewska.recruitmenttask.provider.model.QuestionDto;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProviderConverter {

  public List<Answer> convertAnswersDtosToAnswerList(AnswersDto answersDto, CorrectAnswersDto correctAnswersDto) {
    List<Answer> answers = new ArrayList<>();
    Answer answerA = new Answer();
    answerA.setAnswer(answersDto.getAnswerA());
    answerA.setCorrect(correctAnswersDto.getIsACorrect());
    answers.add(answerA);

    Answer answerB = new Answer();
    answerB.setAnswer(answersDto.getAnswerB());
    answerB.setCorrect(correctAnswersDto.getIsBCorrect());
    answers.add(answerB);

    Answer answerC = new Answer();
    answerC.setAnswer(answersDto.getAnswerC());
    answerC.setCorrect(correctAnswersDto.getIsCCorrect());
    answers.add(answerC);

    Answer answerD = new Answer();
    answerD.setAnswer(answersDto.getAnswerD());
    answerD.setCorrect(correctAnswersDto.getIsDCorrect());
    answers.add(answerD);

    Answer answerE = new Answer();
    answerE.setAnswer(answersDto.getAnswerE());
    answerE.setCorrect(correctAnswersDto.getIsBCorrect());
    answers.add(answerE);

    Answer answerF = new Answer();
    answerF.setAnswer(answersDto.getAnswerB());
    answerF.setCorrect(correctAnswersDto.getIsBCorrect());
    answers.add(answerF);

    return answers;
  }

  public Question convertQuestionDtoToQuestion(QuestionDto questionDto) {
    Question question = new Question();
    question.setApiId(questionDto.getId());
    question.setQuestion(questionDto.getQuestion());

    AnswersDto answersDto = questionDto.getAnswers();
    CorrectAnswersDto correctAnswersDto = questionDto.getCorrectAnswers();
    List<Answer> answers = convertAnswersDtosToAnswerList(answersDto, correctAnswersDto);

    question.setAnswers(answers);

    return question;
  }

}
