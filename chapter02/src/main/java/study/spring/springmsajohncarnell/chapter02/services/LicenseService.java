package study.spring.springmsajohncarnell.chapter02.services;

import org.springframework.stereotype.Service;
import study.spring.springmsajohncarnell.chapter02.model.License;

import java.util.UUID;

@Service
public class LicenseService {
  
  public License getLicense(String licenseId) {
    return License.builder()
        .id(licenseId)
        .organizationId(UUID.randomUUID().toString())
        .productName("Test Product Name")
        .licenseType("PerSeat")
        .build();
  }
  
  public void saveLicense(License license) {
  
  }
  
  public void updateLicense(License license) {
  
  }
  
  public void deleteLicense(License license) {
  
  }
  
}
