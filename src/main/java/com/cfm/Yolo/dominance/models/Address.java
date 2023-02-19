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
public class Address {
  
  private Integer id;
  private Person person;
  private String address;
  private String district;
  private String state;
  private String city;
  private String zipcode;
  private Instant createdDate;

}
