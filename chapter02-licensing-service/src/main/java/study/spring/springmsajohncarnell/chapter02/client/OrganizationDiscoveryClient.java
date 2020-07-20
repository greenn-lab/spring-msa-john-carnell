package study.spring.springmsajohncarnell.chapter02.client;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import study.spring.springmsajohncarnell.chapter02.model.Organization;

import java.util.List;

@Component
@RequiredArgsConstructor
public class OrganizationDiscoveryClient {
  
  private final DiscoveryClient discoveryClient;
  
  public Organization getOrganization(final String organizationId) {
    final RestTemplate template = new RestTemplate();
    final List<ServiceInstance> instances = discoveryClient.getInstances("organizationservice");
    
    if (instances.isEmpty()) {
      return null;
    }
    
    final String uri = String.format("%s/v1/organizations/%s", instances.get(0).getUri().toString(), organizationId);
    
    return template
        .getForEntity(uri, Organization.class, organizationId)
        .getBody();
  }
  
  
}
