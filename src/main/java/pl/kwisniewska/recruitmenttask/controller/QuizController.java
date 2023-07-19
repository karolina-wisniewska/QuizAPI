package pl.kwisniewska.recruitmenttask.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class QuizController {

  @GetMapping(value = "/questions")
  public String getRandomQuestion(){
    return "Random question";
  }

  @PostMapping(value = "/answers")
  public String answerQuestion(){
    return "My answer";
  }

}
