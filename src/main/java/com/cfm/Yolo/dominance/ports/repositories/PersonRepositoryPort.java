package com.cfm.Yolo.dominance.ports.repositories;

import java.util.List;

import com.cfm.Yolo.dominance.models.Person;

// TODO: Persistence interface, which will search the database and persist the database
public interface PersonRepositoryPort {

  List<Person> findAll();

  Person findById(Integer id);

  Boolean existsByUsername(String username);

  void save(Person person);

}
