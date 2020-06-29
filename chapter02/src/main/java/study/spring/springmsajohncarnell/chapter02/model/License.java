package study.spring.springmsajohncarnell.chapter02.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class License{
  private String id;
  private String organizationId;
  private String productName;
  private String licenseType;
}
