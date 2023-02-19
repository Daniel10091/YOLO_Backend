package com.cfm.Yolo.dominance.models;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Phone {
  
  private Integer id;
  private Person person;
  private String ddd;
  private String phoneNumber;
  private String phoneExtension;
  private Instant createdDate;

}
