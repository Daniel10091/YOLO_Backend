package com.cfm.Yolo.dominance.models;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

import com.cfm.Yolo.dominance.dtos.PersonDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Person {
  
  private Integer id;
  private String name;
  private String gender;
  private Instant createdDate;
  private Set<Address> addresses = new LinkedHashSet<>();
  private Set<Phone> phones = new LinkedHashSet<>();
  private Set<Email> emails = new LinkedHashSet<>();
  private User user;
  private Set<Friend> friends;

  public Person(PersonDto personDto) {
    this.id = personDto.getCode();
    this.name = personDto.getName();
    this.gender = personDto.getGender();
    this.createdDate = personDto.getCreatedDate();
    this.user.setId(personDto.getCode());
    this.user.setAvatar(personDto.getAvatar());
    this.user.setBackground(personDto.getBackground());
    this.user.setUsername(personDto.getUsername());
    this.user.setSalt(personDto.getSalt());
    this.user.setPassword(personDto.getPassword());
    this.user.setCreatedDate(personDto.getUserCreatedDate());
  }

  public PersonDto toPersonDto() {
    return new PersonDto(
      this.id,
      this.name,
      this.gender,
      this.createdDate,
      this.user.getAvatar(),
      this.user.getBackground(),
      this.user.getUsername(),
      this.user.getSalt(),
      this.user.getPassword(),
      this.user.getIsActive(),
      this.user.getCreatedDate()
    );
  }

  public Person(
          Integer id,
          String name,
          String gender,
          Instant createdDate,
          byte[] avatar,
          byte[] background,
          String username,
          String salt,
          String Password,
          Boolean isActive,
          Instant userCreatedDate
  ) {
    this.id = id;
    this.name = name;
    this.gender = gender;
    this.createdDate = createdDate;
    this.user.setAvatar(avatar);
    this.user.setBackground(background);
    this.user.setUsername(username);
    this.user.setSalt(salt);
    this.user.setPassword(Password);
    this.user.setIsActive(isActive);
    this.user.setCreatedDate(userCreatedDate);
  }
}
