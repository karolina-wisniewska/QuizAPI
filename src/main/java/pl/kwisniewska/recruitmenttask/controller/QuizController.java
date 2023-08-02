package pl.kwisniewska.recruitmenttask.controller;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import pl.kwisniewska.recruitmenttask.converter.EntityToDtoConverter;
import pl.kwisniewska.recruitmenttask.entity.Question;
import pl.kwisniewska.recruitmenttask.model.AnswerToCheckDto;
import pl.kwisniewska.recruitmenttask.model.CheckDto;
import pl.kwisniewska.recruitmenttask.model.QuestionToShowDto;
import pl.kwisniewska.recruitmenttask.service.QuestionService;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api")
public class QuizController {

  private final QuestionService questionService;
  private final EntityToDtoConverter converter;

  @GetMapping(value = "/questions")
  public ResponseEntity<QuestionToShowDto> showRandomQuestion() {
    Question randomQuestion = questionService.getRandomQuestion();
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

  @ExceptionHandler(EntityNotFoundException.class)
  public ResponseEntity<String> handleEntityNotFoundExceptions() {
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
}
