package study.spring.springmsajohncarnell.chapter02.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "licenses")
@Getter
@Builder
public class License {
  
  @Id
  @Setter
  private String licenseId;
  
  private String organizationId;
  private String productName;
  
  @Setter
  private String comment;
  
}
