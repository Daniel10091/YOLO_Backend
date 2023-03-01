package com.cfm.Yolo.dominance.ports.interfaces;

import java.util.List;

import com.cfm.Yolo.dominance.dtos.PersonDto;

import javassist.NotFoundException; // TODO: Required dependency injection

// TODO: Service class interface
public interface PersonServicePort {

  List<PersonDto> findAllPerson();

  PersonDto findPersonById(Integer id);

  Boolean existsByUsername(String username);

  void savePerson(PersonDto personDto) throws Exception;

  void updatePerson(PersonDto personDto) throws NotFoundException;

}
