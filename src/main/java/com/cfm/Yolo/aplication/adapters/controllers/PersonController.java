package com.cfm.Yolo.aplication.adapters.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cfm.Yolo.dominance.dtos.PersonDto;
import com.cfm.Yolo.dominance.ports.interfaces.PersonServicePort;

import javassist.NotFoundException;

@RestController
@RequestMapping("yolo/api/person")
public class PersonController {
  
  private final PersonServicePort personServicePort;
  
  public PersonController(PersonServicePort personServicePort) {
    this.personServicePort = personServicePort;
  }

  @PostMapping("/save")
  void createPerson(@RequestBody PersonDto personDto) {
    personServicePort.savePerson(personDto);
  }

  @GetMapping("/findAll")
  List<PersonDto> getPeople() {
    return personServicePort.findAllPerson();
  }

  @PutMapping("/update")
  void updatePerson(@RequestBody PersonDto personDto) throws NotFoundException {
    personServicePort.updatePerson(personDto);
  }

}
