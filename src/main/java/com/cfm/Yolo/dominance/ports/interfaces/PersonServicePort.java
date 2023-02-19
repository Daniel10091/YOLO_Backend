package com.cfm.Yolo.dominance.ports.interfaces;

import java.util.List;

import com.cfm.Yolo.dominance.dtos.PersonDto;

import javassist.NotFoundException; // TODO: Required dependency injection

// TODO: Service class interface
public interface PersonServicePort {
  
  List<PersonDto> findAllPerson();

  void savePerson(PersonDto personDto);

  void updatePerson(PersonDto personDto) throws NotFoundException;

}
