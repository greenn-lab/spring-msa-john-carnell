package study.spring.springmsajohncarnell.chapter02.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import study.spring.springmsajohncarnell.chapter02.config.ServiceConfig;
import study.spring.springmsajohncarnell.chapter02.model.License;
import study.spring.springmsajohncarnell.chapter02.repository.LicenseRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LicenseService {
  
  private final LicenseRepository repository;
  
  private final ServiceConfig config;


  public License getLicense(String organizationId, String licenseId) {
    final License license = repository.findByOrganizationIdAndLicenseId(organizationId, licenseId);

    license.setComment(config.getExampleProperty());
    
    return license;
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
