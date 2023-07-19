package pl.kwisniewska.recruitmenttask.provider;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@ConfigurationProperties("quiz-api")
@PropertySource("classpath:application.yaml")
@Getter
@Setter
public class QuizApiProperties {

  private String url;

  private List<Param> params = new ArrayList<>();

  @Getter
  @Setter
  private class Param {
    private String name;
    private String value;
  }
}
