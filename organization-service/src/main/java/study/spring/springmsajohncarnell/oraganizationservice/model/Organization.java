package study.spring.springmsajohncarnell.oraganizationservice.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "organizations")
@Getter
@Setter
@Builder
public class Organization {
  
  @Id
  @Column(name = "organization_id")
  private String id;
  
  private String name;
  private String contactName;
  private String contactEmail;
  private String contactPhone;

}
