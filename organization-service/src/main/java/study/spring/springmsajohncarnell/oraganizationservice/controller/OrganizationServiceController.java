package study.spring.springmsajohncarnell.oraganizationservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.spring.springmsajohncarnell.oraganizationservice.model.Organization;

@RestController
@RequestMapping("v1/organizations")
public class OrganizationServiceController {
  
  @GetMapping("/{organizationId}")
  public Organization getOrganization(@PathVariable String organizationId) {
    return Organization.builder()
        .id(organizationId)
        .build();
  }
  
}
