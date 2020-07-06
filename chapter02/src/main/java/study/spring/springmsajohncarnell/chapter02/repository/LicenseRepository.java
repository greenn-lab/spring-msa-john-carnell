package study.spring.springmsajohncarnell.chapter02.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import study.spring.springmsajohncarnell.chapter02.model.License;

import java.util.List;

@Repository
public interface LicenseRepository extends CrudRepository<License, String> {
  
  List<License> findByOrganizationId(String organizationId);

  License findByOrganizationIdAndLicenseId(String organizationId, String licenseId);
}
