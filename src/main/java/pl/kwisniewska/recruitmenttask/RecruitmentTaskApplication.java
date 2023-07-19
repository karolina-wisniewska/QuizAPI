package pl.kwisniewska.recruitmenttask;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Quiz API", version = "1.0", description = "API for solving quizzes"))

public class RecruitmentTaskApplication {

  public static void main(String[] args) {
    SpringApplication.run(RecruitmentTaskApplication.class, args);
  }

}
