package pl.kwisniewska.recruitmenttask;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.kwisniewska.recruitmenttask.converter.ProviderConverter;
import pl.kwisniewska.recruitmenttask.entity.Question;
import pl.kwisniewska.recruitmenttask.provider.model.QuestionDto;
import pl.kwisniewska.recruitmenttask.provider.service.ProviderService;
import pl.kwisniewska.recruitmenttask.service.QuestionService;

import java.util.stream.IntStream;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Quiz API", version = "1.0", description = "API for solving quizzes"))
public class RecruitmentTaskApplication {

  public static void main(String[] args) {
    SpringApplication.run(RecruitmentTaskApplication.class, args);
  }

  @Bean
  CommandLineRunner runner(ProviderService providerService, ProviderConverter providerConverter, QuestionService questionService) {
    return args -> IntStream.range(0,10)
            .forEach(i -> {
              QuestionDto questionDto = providerService.getData();
              Question question = providerConverter.convertQuestionDtoToQuestion(questionDto);
              questionService.save(question);
            });
  }
}
