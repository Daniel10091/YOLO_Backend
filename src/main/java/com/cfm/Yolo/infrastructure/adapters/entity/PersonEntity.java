package com.cfm.Yolo.infrastructure.adapters.entity;

import java.time.Instant;

import javax.persistence.*;

import com.cfm.Yolo.dominance.models.Person;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "person")
@SecondaryTable(name = "user", pkJoinColumns = @PrimaryKeyJoinColumn(name = "id"))
public class PersonEntity {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  private String name;
  private String gender;
  private Instant createdDate;
  // private Set<Address> addresses = new LinkedHashSet<>();
  // private Set<Phone> phones = new LinkedHashSet<>();
  // private Set<Email> emails = new LinkedHashSet<>();
  @OneToOne(mappedBy = "person", cascade = CascadeType.ALL, optional = true)
  private UserEntity user;

  public PersonEntity(Person person) {
  }
  // private Set<Friend> friends;

  public void update(Person person) {
    this.id = person.getId();
    this.name = person.getName();
    this.gender = person.getGender();
    this.createdDate = person.getCreatedDate();
    this.user.setId(person.getUser().getId());
    this.user.setAvatar(person.getUser().getAvatar());
    this.user.setBackground(person.getUser().getBackground());
    this.user.setUsername(person.getUser().getUsername());
    this.user.setSalt(person.getUser().getSalt());
    this.user.setPassword(person.getUser().getPassword());
    this.user.setIsActive(person.getUser().getIsActive());
    this.user.setCreatedDate(person.getUser().getCreatedDate());
  }

  public Person toPerson() {
    return new Person(
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

}
