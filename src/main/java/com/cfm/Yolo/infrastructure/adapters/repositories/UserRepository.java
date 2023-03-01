package com.cfm.Yolo.infrastructure.adapters.repositories;

import com.cfm.Yolo.dominance.ports.repositories.UserRepositoryPort;

public class UserRepository implements UserRepositoryPort {

  SpringUserRepository springUserRepository;

  public UserRepository(SpringUserRepository springUserRepository) {
    this.springUserRepository = springUserRepository;
  }

  @Override
  public Boolean existsByUsername(String username) {
    return this.springUserRepository.existsByUsername(username);
  }

}
