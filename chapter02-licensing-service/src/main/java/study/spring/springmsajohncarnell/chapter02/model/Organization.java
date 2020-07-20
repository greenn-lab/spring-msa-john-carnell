package study.spring.springmsajohncarnell.chapter02.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Organization {
  
  private String id;
  private String name;
  private String contactName;
  private String contactEmail;
  private String contactPhone;
  
}
