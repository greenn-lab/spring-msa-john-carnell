package study.spring.springmsajohncarnell.chapter02.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Organization {
  private String id;
  private String name;
  private String contactName;
  private String contactEmail;
  private String contactPhone;
}
