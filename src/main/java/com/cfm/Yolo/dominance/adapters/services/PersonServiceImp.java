package com.cfm.Yolo.dominance.adapters.services;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.cfm.Yolo.dominance.dtos.PersonDto;
import com.cfm.Yolo.dominance.models.Person;
import com.cfm.Yolo.dominance.ports.interfaces.PersonServicePort;
import com.cfm.Yolo.dominance.ports.repositories.PersonRepositoryPort;

import javassist.NotFoundException;

public class PersonServiceImp implements PersonServicePort {

  private final PersonRepositoryPort personRepository;

  public PersonServiceImp(PersonRepositoryPort personRepository) {
    this.personRepository = personRepository;
  }

  @Override
  public void savePerson(PersonDto personDto) {
    Person person = new Person(personDto);
    this.personRepository.save(person);
  }

  @Override
  public List<PersonDto> findAllPerson() {
    List<Person> people = this.personRepository.findAll();
    List<PersonDto> peopleDtos = people.stream().map(Person::toPersonDto).collect(Collectors.toList());
    return peopleDtos;
  }

  @Override
  public void updatePerson(PersonDto personDto) throws NotFoundException {
    Person person = this.personRepository.findById(personDto.getCode());
    
    if (Objects.isNull(person)) 
      throw new NotFoundException("Person not found");

    this.personRepository.save(person);
  }
  
}
