package com.cfm.Yolo.infrastructure.adapters.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cfm.Yolo.infrastructure.adapters.entity.UserEntity;

public interface SpringUserRepository extends JpaRepository<UserEntity, Integer> {

  Boolean existsByUsername(String username);

}
