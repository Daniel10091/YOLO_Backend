package com.cfm.Yolo.infrastructure.adapters.repositories;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.cfm.Yolo.dominance.models.Person;
import com.cfm.Yolo.dominance.ports.repositories.PersonRepositoryPort;
import com.cfm.Yolo.infrastructure.adapters.entity.PersonEntity;


@Component
public class PersonRepository implements PersonRepositoryPort {
  
  private final SpringPersonRepository springPersonRepository;

  public PersonRepository(SpringPersonRepository springPersonRepository) {
    this.springPersonRepository = springPersonRepository;
  }

  @Override
  public List<Person> findAll() {
    List<PersonEntity> personEntities = this.springPersonRepository.findAll();
    return personEntities.stream().map(PersonEntity::toPerson).collect(Collectors.toList());
  }

  @Override
  public Person findById(Integer id) {
    Optional<PersonEntity> personEntity = this.springPersonRepository.findById(id);

    if (personEntity.isPresent())
      return personEntity.get().toPerson();

    throw new RuntimeException("Person does not exist");
  }

  @Override
  public void save(Person person) {
    PersonEntity personEntity;

    if (Objects.isNull(person.getId())) {
      personEntity = new PersonEntity(person);
    } else {
      personEntity = this.springPersonRepository.findById(person.getId()).get();
      personEntity.update(person);
    }

    this.springPersonRepository.save(personEntity);
  }

}
