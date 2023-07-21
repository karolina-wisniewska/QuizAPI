package pl.kwisniewska.recruitmenttask.provider.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.kwisniewska.recruitmenttask.provider.QuizProperties;
import pl.kwisniewska.recruitmenttask.provider.model.QuestionDto;

@Service
@RequiredArgsConstructor
public class ProviderServiceImpl implements ProviderService {

  private final QuizProperties quizProperties;

  @Override
  public QuestionDto getData() {
    RestTemplate restTemplate = new RestTemplate();
    QuestionDto[] questionDtoResource = restTemplate.getForObject(quizProperties.getUrl(), QuestionDto[].class);
    return questionDtoResource[0];
  }
}
