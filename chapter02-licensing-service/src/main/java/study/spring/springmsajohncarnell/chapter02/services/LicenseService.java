package study.spring.springmsajohncarnell.chapter02.services;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import study.spring.springmsajohncarnell.chapter02.client.OrganizationRestTemplateClient;
import study.spring.springmsajohncarnell.chapter02.config.ServiceConfig;
import study.spring.springmsajohncarnell.chapter02.model.License;
import study.spring.springmsajohncarnell.chapter02.model.Organization;
import study.spring.springmsajohncarnell.chapter02.repository.LicenseRepository;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
@Slf4j
public class LicenseService {
  
  private final LicenseRepository repository;
  
  private final ServiceConfig config;
  
  private final OrganizationRestTemplateClient organizationRestTemplateClient;
  
  
  public License getLicense(String organizationId, String licenseId) {
    final License license = repository.findByOrganizationIdAndLicenseId(organizationId, licenseId);
    
    Organization organization = getOrganization(organizationId);
    
    license.setComment(config.getExampleProperty());
    
    license.setOrganizationName(organization.getName());
    license.setContactName(organization.getContactName());
    license.setContactEmail(organization.getContactEmail());
    license.setContactPhone(organization.getContactPhone());
    return license;
  }
  
  @HystrixCommand
  private Organization getOrganization(String organizationId) {
    return organizationRestTemplateClient.getOrganization(organizationId);
  }
  
  //  @HystrixCommand(
  //      commandProperties = {
  //          @HystrixProperty(
  //              name = "execution.isolation.thread.timeoutInMillseconds",
  //              value = "5000"
  //          )
  //      }
  //  )
  @HystrixCommand(
      threadPoolKey = "licenseByOrgThreadPool",
      threadPoolProperties = {
        @HystrixProperty(name = "coreSize", value = "30"),
        @HystrixProperty(name = "maxQueueSize", value = "10")
      }
  )
  public List<License> getLicensesByOrg(String organizationId) {
    
    final int count = ThreadLocalRandom.current().nextInt(3) + 1;
    
    log.info("random count: {}", count);
    
    
    final Organization organization = getOrganization(organizationId);
    
    
    if (3 == count) {
      try {
        TimeUnit.SECONDS.sleep(11);
      }
      catch (InterruptedException e) {
        log.error(e.getMessage());
      }
    }
    
    return repository.findByOrganizationId(organizationId);
  }
  
  public void saveLicense(License license) {
    license.setLicenseId(UUID.randomUUID().toString());
    repository.save(license);
  }
  
  public void updateLicense(License license) {
    throw new UnsupportedOperationException();
  }
  
  public void deleteLicense(License license) {
    throw new UnsupportedOperationException();
  }
  
}
