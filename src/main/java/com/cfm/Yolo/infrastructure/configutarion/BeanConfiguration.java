package com.cfm.Yolo.infrastructure.configutarion;

import com.cfm.Yolo.dominance.adapters.services.PersonServiceImp;
import com.cfm.Yolo.dominance.ports.interfaces.PersonServicePort;
import com.cfm.Yolo.dominance.ports.repositories.PersonRepositoryPort;
import com.cfm.Yolo.dominance.ports.repositories.UserRepositoryPort;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

  @Bean
  PersonServicePort personService(PersonRepositoryPort personRepositoryPort) {
    return new PersonServiceImp(personRepositoryPort);
  }

}
