package pl.kwisniewska.recruitmenttask.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kwisniewska.recruitmenttask.converter.EntityToDtoConverter;
import pl.kwisniewska.recruitmenttask.entity.Question;
import pl.kwisniewska.recruitmenttask.model.AnswerToCheckDto;
import pl.kwisniewska.recruitmenttask.model.CheckDto;
import pl.kwisniewska.recruitmenttask.model.QuestionToShowDto;
import pl.kwisniewska.recruitmenttask.service.QuestionService;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

@RestController
@Transactional
@RequiredArgsConstructor
@RequestMapping(value = "/api")
public class QuizController {

  private final QuestionService questionService;
  private final EntityToDtoConverter converter;

  @GetMapping(value = "/questions")
  public ResponseEntity<QuestionToShowDto> getRandomQuestion() {
    Question randomQuestion = questionService.getRandom().get();
    QuestionToShowDto questionToShowDto = converter.convertQuestionToQuizQuestionDto(randomQuestion);
    return new ResponseEntity<>(questionToShowDto, HttpStatus.OK);
  }

  @PostMapping(value = "/answers")
  public ResponseEntity<CheckDto> answerQuestion(@Valid @RequestBody AnswerToCheckDto answerToCheckDto) {
    Long questionId = answerToCheckDto.getQuestionId();
    Set<Long> answers = answerToCheckDto.getAnswers();
    boolean isPassed = questionService.isQuestionPassed(questionId, answers);
    CheckDto checkDto = converter.convertBooleanToCheckDto(isPassed);

    return new ResponseEntity<>(checkDto, HttpStatus.OK);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Map<String, String>> handleValidationExceptions(
          MethodArgumentNotValidException ex) {
    Map<String, String> errors = new HashMap<>();
    ex.getBindingResult().getAllErrors().forEach((error) -> {
      String fieldName = ((FieldError) error).getField();
      String errorMessage = error.getDefaultMessage();
      errors.put(fieldName, errorMessage);
    });
    return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(NoSuchElementException.class)
  public ResponseEntity<String> handleQuestionNotFoundExceptions() {
    String message = "Question not found";
    return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
  }
}
