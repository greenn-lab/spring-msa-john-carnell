package study.spring.springmsajohncarnell.chapter02.client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import study.spring.springmsajohncarnell.chapter02.model.Organization;

@Component
@RequiredArgsConstructor
public class OrganizationRestTemplateClient {
  
  private final RestTemplate restTemplate;
  
  public Organization getOrganization(String organizationId) {
    return restTemplate.getForEntity(
        "http://organizationservice/v1/organizations/{organizationId}",
        Organization.class, organizationId).getBody();
  }
}
