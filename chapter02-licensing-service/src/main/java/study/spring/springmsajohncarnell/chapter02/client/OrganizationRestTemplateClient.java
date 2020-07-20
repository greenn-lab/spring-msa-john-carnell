package study.spring.springmsajohncarnell.chapter02.client;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import study.spring.springmsajohncarnell.chapter02.model.Organization;

@Component
@RequiredArgsConstructor
public class OrganizationRestTemplateClient {
  
  private final RestTemplate restTemplate;
  
  public Organization getOrganization(String organizationId) {
    final ResponseEntity<Organization> entity = restTemplate.getForEntity(
        "http://organizationservice/v1/organizations/{organizationId}",
        Organization.class, organizationId);
    return entity.getBody();
  }
}
