package com.cfm.Yolo.infrastructure.adapters.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cfm.Yolo.infrastructure.adapters.entity.PersonEntity;

public interface SpringPersonRepository extends JpaRepository<PersonEntity, Integer> {

}
