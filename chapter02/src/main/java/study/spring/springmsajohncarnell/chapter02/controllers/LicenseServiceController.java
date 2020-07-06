package study.spring.springmsajohncarnell.chapter02.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import study.spring.springmsajohncarnell.chapter02.model.License;
import study.spring.springmsajohncarnell.chapter02.services.LicenseService;

@RestController
@RequestMapping(value = "v1/organizations/{organizationId}/licenses")
@RequiredArgsConstructor
public class LicenseServiceController {
  
  private final LicenseService licenseService;
  
  @RequestMapping(value = "/{licenseId}", method = RequestMethod.GET)
  public License getLicenses(@PathVariable("organizationId") String organizationId,
                             @PathVariable("licenseId") String licenseId) {
    
    //return licenseService.getLicense(licenseId);
    return License.builder()
        .licenseId(licenseId)
        .organizationId(organizationId)
        .productName("Teleco")
        .build();
  }
  
  @PutMapping("{licenseId}")
  public String updateLicenses(@PathVariable("licenseId") String licenseId) {
    return String.format("This is the put");
  }
  
  @PostMapping("{licenseId}")
  public String saveLicenses(@PathVariable("licenseId") String licenseId) {
    return String.format("This is the post");
  }
  
  @DeleteMapping("{licenseId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public String deleteLicenses(@PathVariable("licenseId") String licenseId) {
    return String.format("This is the Delete");
  }
  
}
