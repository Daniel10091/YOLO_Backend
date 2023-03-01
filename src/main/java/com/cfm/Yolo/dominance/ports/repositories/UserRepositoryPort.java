package com.cfm.Yolo.dominance.ports.repositories;

// TODO: Persistence interface, which will search the database and persist the database
public interface UserRepositoryPort {

  Boolean existsByUsername(String username);

}
