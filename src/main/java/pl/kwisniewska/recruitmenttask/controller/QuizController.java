package pl.kwisniewska.recruitmenttask.controller;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kwisniewska.recruitmenttask.converter.EntityToDtoConverter;
import pl.kwisniewska.recruitmenttask.entity.Question;
import pl.kwisniewska.recruitmenttask.model.ShowQuestionDto;
import pl.kwisniewska.recruitmenttask.service.QuestionService;

@RestController
@Transactional
@RequiredArgsConstructor
@RequestMapping(value = "/api")
public class QuizController {

  private final QuestionService questionService;
  private final EntityToDtoConverter converter;

  @GetMapping(value = "/questions")
  public ResponseEntity<ShowQuestionDto> getRandomQuestion(){
    Question randomQuestion = questionService.getRandom().get();
    ShowQuestionDto showQuestionDto = converter.convertQuestionToQuizQuestionDto(randomQuestion);
    return new ResponseEntity<>(showQuestionDto, HttpStatus.OK);
  }

  @PostMapping(value = "/answers")
  public String answerQuestion(){
    return "My answer";
  }

}
