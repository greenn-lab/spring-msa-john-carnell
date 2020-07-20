package study.spring.springmsajohncarnell.chapter02.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "licenses")
@Getter
@Setter
@Builder
public class License {
  
  @Id
  @Setter
  private String licenseId;
  
  private String organizationId;
  
  @Transient
  private String organizationName;
  
  @Transient
  private String contactName;
  
  @Transient
  private String contactPhone;
  
  @Transient
  private String contactEmail;
  
  private String productName;
  private String clientType;
  private String licenseType;
  private Integer licenseMax;
  private Integer licenseAllocated;
  
  @Setter
  private String comment;
  
}
