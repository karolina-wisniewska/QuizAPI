package pl.kwisniewska.recruitmenttask.controller;

import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import pl.kwisniewska.recruitmenttask.entity.Answer;
import pl.kwisniewska.recruitmenttask.entity.Question;
import pl.kwisniewska.recruitmenttask.model.AnswerToCheckDto;
import pl.kwisniewska.recruitmenttask.model.AnswerToShowDto;
import pl.kwisniewska.recruitmenttask.model.CheckDto;
import pl.kwisniewska.recruitmenttask.model.QuestionToShowDto;
import pl.kwisniewska.recruitmenttask.service.QuestionService;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class QuizControllerMockServiceTest {

  @MockBean
  private QuestionService questionService;

  @Autowired
  private TestRestTemplate restTemplate;

  @Test
  public void shouldReturnOkQuestionToShowDto() {
    // given
    Question randomQuestion = new Question(1L, 1L, "Question", Arrays.asList(new Answer(1L, true, "Answer1"), new Answer(2L, false, "Answer2")));
    given(questionService.getRandomQuestion())
            .willReturn(randomQuestion);
    QuestionToShowDto expected = new QuestionToShowDto(1L, "Question", Arrays.asList(new AnswerToShowDto(1L, "Answer1"), new AnswerToShowDto(2L, "Answer2")));

    // when
    ResponseEntity<QuestionToShowDto> questionResponse = restTemplate.getForEntity("/api/questions", QuestionToShowDto.class);

    // then
    assertThat(questionResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(expected.equals(questionResponse.getBody())).isTrue();
  }

  @Test
  public void whenAnswerCorrect_shouldReturnOkTrue() {
    // given
    Set<Long> answers = new HashSet<>(Arrays.asList(1L, 2L));
    AnswerToCheckDto answer = new AnswerToCheckDto(answers, 1L);
    given(questionService.isQuestionPassed(answer.getQuestionId(), answer.getAnswers()))
            .willReturn(true);
    CheckDto expected = new CheckDto(true);

    // when
    ResponseEntity<CheckDto> answerResponse = restTemplate.postForEntity("/api/answers", answer, CheckDto.class);

    // then
    assertThat(answerResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(expected.equals(answerResponse.getBody())).isTrue();
  }

  @Test
  public void whenAnswerIncorrect_shouldReturnOkFalse() {
    // given
    Set<Long> answers = new HashSet<>(Arrays.asList(1L, 2L));
    AnswerToCheckDto answer = new AnswerToCheckDto(answers, 1L);
    given(questionService.isQuestionPassed(answer.getQuestionId(), answer.getAnswers()))
            .willReturn(false);
    CheckDto expected = new CheckDto(false);

    // when
    ResponseEntity<CheckDto> answerResponse = restTemplate.postForEntity("/api/answers", answer, CheckDto.class);

    // then
    assertThat(answerResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(expected.equals(answerResponse.getBody())).isTrue();
  }

  @Test
  public void whenQuestionNotExists_shouldReturnNotFound() {
    // given
    Set<Long> answers = new HashSet<>(Arrays.asList(1L, 2L));
    AnswerToCheckDto answer = new AnswerToCheckDto(answers, 11L);
    given(questionService.isQuestionPassed(answer.getQuestionId(), answer.getAnswers()))
            .willThrow(EntityNotFoundException.class);

    // when
    ResponseEntity<String> answerResponse = restTemplate.postForEntity("/api/answers", answer, String.class);

    // then
    assertThat(answerResponse.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
  }

  @Test
  public void whenNoAnswers_shouldReturnBadRequest() {
    // given
    AnswerToCheckDto answer = new AnswerToCheckDto(null, 11L);

    // when
    ResponseEntity<String> answerResponse = restTemplate.postForEntity("/api/answers", answer, String.class);

    // then
    assertThat(answerResponse.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
  }

  @Test
  public void whenNoQuestionId_shouldReturnBadRequest() {
    // given
    Set<Long> answers = new HashSet<>(Arrays.asList(1L, 2L));
    AnswerToCheckDto answer = new AnswerToCheckDto(answers, null);

    // when
    ResponseEntity<String> answerResponse = restTemplate.postForEntity("/api/answers", answer, String.class);

    // then
    assertThat(answerResponse.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
  }


}