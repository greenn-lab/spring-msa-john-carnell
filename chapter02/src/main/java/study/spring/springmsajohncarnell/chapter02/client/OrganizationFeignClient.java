package study.spring.springmsajohncarnell.chapter02.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import study.spring.springmsajohncarnell.chapter02.model.Organization;

@FeignClient("organizationservice")
public interface OrganizationFeignClient {
  
  @GetMapping(
      path = "/v1/organizations/{organizationId}",
      consumes = "application/json"
  )
  Organization getOrganization(@PathVariable String organizationId);
  
}
