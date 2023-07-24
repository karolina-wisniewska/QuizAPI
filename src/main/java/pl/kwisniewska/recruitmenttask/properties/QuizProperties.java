package pl.kwisniewska.recruitmenttask.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("quiz-api")
@PropertySource("classpath:application.yaml")
@Getter
@Setter
public class QuizProperties {

  private String url;

}
