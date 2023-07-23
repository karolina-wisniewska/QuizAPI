package pl.kwisniewska.recruitmenttask.converter;

import org.springframework.stereotype.Component;
import pl.kwisniewska.recruitmenttask.entity.Answer;
import pl.kwisniewska.recruitmenttask.entity.Question;
import pl.kwisniewska.recruitmenttask.provider.model.QuestionDto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Component
public class ProviderConverter {

  public List<Answer> convertAnswersDtosToAnswerList(Map<String, String> answers, Map<String, Boolean> correctAnswers) {
    List<Answer> answersList = new ArrayList<>();
    Iterator<Map.Entry<String, String>> iter1 = answers.entrySet().iterator();
    Iterator<Map.Entry<String, Boolean>> iter2 = correctAnswers.entrySet().iterator();
    while(iter1.hasNext() && iter2.hasNext()) {
      Map.Entry<String, String> e1 = iter1.next();
      Map.Entry<String, Boolean> e2 = iter2.next();
      Answer answer = new Answer();
      answer.setAnswer(e1.getValue());
      answer.setCorrect(e2.getValue());
      answersList.add(answer);
    }

    return answersList;
  }

  public Question convertQuestionDtoToQuestion(QuestionDto questionDto) {
    Question question = new Question();
    question.setApiId(questionDto.getId());
    question.setQuestion(questionDto.getQuestion());

    Map<String, String> answers = questionDto.getAnswers();
    Map<String, Boolean> correctAnswers = questionDto.getCorrectAnswers();
    List<Answer> answersList = convertAnswersDtosToAnswerList(answers, correctAnswers);

    question.setAnswers(answersList);

    return question;
  }
}
