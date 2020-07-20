package study.spring.springmsajohncarnell.chapter02.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import study.spring.springmsajohncarnell.chapter02.client.OrganizationDiscoveryClient;
import study.spring.springmsajohncarnell.chapter02.client.OrganizationFeignClient;
import study.spring.springmsajohncarnell.chapter02.client.OrganizationRestTemplateClient;
import study.spring.springmsajohncarnell.chapter02.config.ServiceConfig;
import study.spring.springmsajohncarnell.chapter02.model.License;
import study.spring.springmsajohncarnell.chapter02.model.Organization;
import study.spring.springmsajohncarnell.chapter02.repository.LicenseRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LicenseService {
  
  private final LicenseRepository repository;
  
  private final ServiceConfig config;
  
  private final OrganizationDiscoveryClient organizationDiscoveryClient;
  
  private final OrganizationFeignClient organizationFeignClient;
  
  private final OrganizationRestTemplateClient organizationRestTemplateClient;
  
  
  public License getLicense(String organizationId, String licenseId, String clientType) {
    final License license = repository.findByOrganizationIdAndLicenseId(organizationId, licenseId);
    
    Organization organization = retrieveOrganization(organizationId, clientType);
    
    license.setComment(config.getExampleProperty());
    
    license.setOrganizationName(organization.getName());
    license.setContactName(organization.getContactName());
    license.setContactEmail(organization.getContactEmail());
    license.setContactPhone(organization.getContactPhone());
    return license;
  }
  
  private Organization retrieveOrganization(String organizationId, String clientType) {
    Organization organization = null;
    
    switch (clientType) {
      case "feign":
        System.out.println("I am using the feign client");
        organization = organizationFeignClient.getOrganization(organizationId);
        break;
      case "discovery":
        System.out.println("I am using the discovery client");
        organization = organizationDiscoveryClient.getOrganization(organizationId);
        break;
      case "rest":
      default:
        System.out.println("I am using the rest client");
        organization = organizationRestTemplateClient.getOrganization(organizationId);
    }
    
    return organization;
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
