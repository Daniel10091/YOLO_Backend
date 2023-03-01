package com.cfm.Yolo.dominance.adapters.services;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
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
  // private final UserRepositoryPort userRepository;

  public PersonServiceImp(PersonRepositoryPort personRepository) {
    this.personRepository = personRepository;
  }

  @Override
  public List<PersonDto> findAllPerson() {
    List<Person> people = this.personRepository.findAll();
    List<PersonDto> peopleDtos = people.stream().map(Person::toPersonDto).collect(Collectors.toList());
    return peopleDtos;
  }

  @Override
  public PersonDto findPersonById(Integer id) {
    Person person = this.personRepository.findById(id);
    return person.toPersonDto();
  }

  @Override
  public Boolean existsByUsername(String username) {
    return this.personRepository.existsByUsername(username);
  }

  // @Override
  // public void savePerson(PersonDto personDto) throws Exception {
  // Person person = new Person(personDto);
  // String verifyUsernameExiste =
  // personRepository.findByUsername(personDto.getUsername());

  // if (person.getUser().getUsername() != verifyUsernameExiste)
  // this.personRepository.save(person);
  // else
  // throw new Exception("Username already exists");
  // }

  @Override
  public void savePerson(PersonDto personDto) throws Exception {
    // Person saveReturn = null;
    Person person = null;
    // String verifyUsernameExiste =

    byte[] salt = generateSalt();

    personDto.setPassword(encryptPassword(personDto.getPassword(), salt));
    personDto.setSalt(Base64.getEncoder().encodeToString(salt));

    if (personDto.getCode() != null) {
      person = personRepository.findById(personDto.getCode());
      if (person != null) {
        person.setName(personDto.getName());
        person.setGender(personDto.getGender());
        person.getUser().setAvatar(personDto.getAvatar());
        person.getUser().setBackground(personDto.getBackground());
        person.getUser().setUsername(personDto.getUsername());
        person.getUser().setSalt(Base64.getEncoder().encodeToString(salt));
        person.getUser().setPassword(encryptPassword(personDto.getPassword(), salt));
        if (personDto.getIsActive() != null)
          person.getUser().setIsActive(personDto.getIsActive());
      } else {
        throw new Exception("Preencha todos os campos obrigatórios");
      }
    } else {
      if (!personRepository.existsByUsername(personDto.getUsername())) {
        person = personDto.toModel();
      } else {
        throw new Exception("Nome de usuário já existe");
      }
    }
    if (person != null)
      this.personRepository.save(person);
    else
      throw new Exception("Não foi possível salvar o usuário");
  }

  @Override
  public void updatePerson(PersonDto personDto) throws NotFoundException {
    Person person = this.personRepository.findById(personDto.getCode());

    if (Objects.isNull(person))
      throw new NotFoundException("Person not found");

    this.personRepository.save(person);
  }

  // TODO: A cada novo usuário é gerado um salt aleatório, que é concatenado com a
  // senha antes da criptografia.
  // TODO: Desta forma, mesmo que dois usuários tenham, a mesma senha, eles terão
  // hashes diferentes armazenados no banco de dados.
  /**
   * @return
   */
  private byte[] generateSalt() {
    SecureRandom random = new SecureRandom();
    byte[] salt = new byte[16];
    random.nextBytes(salt);
    return salt;
  }

  /**
   * @param password
   * @param salt
   * @return
   */
  private String encryptPassword(String password, byte[] salt) {
    try {
      MessageDigest digest = MessageDigest.getInstance("SHA-256");
      digest.update(salt);
      byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
      return Base64.getEncoder().encodeToString(hash);
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException(e);
    }
  }

}
