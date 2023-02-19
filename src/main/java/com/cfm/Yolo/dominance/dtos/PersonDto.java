package com.cfm.Yolo.dominance.dtos;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PersonDto {
  
  private Integer code;
  private String name;
  private String gender;
  private Instant createdDate;
  private byte[] avatar;
  private byte[] background;
  private String username;
  private String salt;
  private String password;
  private Boolean isActive;
  private Instant userCreatedDate;

}
