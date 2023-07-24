package pl.kwisniewska.recruitmenttask.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.kwisniewska.recruitmenttask.properties.QuizProperties;
import pl.kwisniewska.recruitmenttask.model.ProviderQuestionDto;

@Service
@RequiredArgsConstructor
public class ProviderServiceImpl implements ProviderService {

  private final QuizProperties quizProperties;

  @Override
  public ProviderQuestionDto getData() {
    RestTemplate restTemplate = new RestTemplate();
    ProviderQuestionDto[] providerQuestionDtoResource = restTemplate.getForObject(quizProperties.getUrl(), ProviderQuestionDto[].class);
    return providerQuestionDtoResource[0];
  }
}
