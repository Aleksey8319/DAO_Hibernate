package ru.netology.DAO_Hibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.netology.DAO_Hibernate.entity.Person;
import ru.netology.DAO_Hibernate.repository.PersonsRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class PersonsService {

    private final PersonsRepository repository;

    @Transactional
    public void run() {

        Human human1 = Human.builder().name("alexey").surname("Bogomolov").age(44).build();
        Human human2 = Human.builder().name("Alexey").surname("Orlov").age(45).build();
        Human human3 = Human.builder().name("ALEXEY").surname("Mirin").age(44).build();
        Human human4 = Human.builder().name("Vasiliy").surname("Stepanov").age(58).build();
        Human human5 = Human.builder().name("Vasiliy").surname("Utkin").age(52).build();

        Person person1 = Person.builder().human(human1).phoneNumber("+79993412345").cityOfLiving("Samara").build();
        repository.save(person1);
        Person person2 = Person.builder().human(human2).phoneNumber("+79993412346").cityOfLiving("Moscow").build();
        repository.save(person2);
        Person person3 = Person.builder().human(human3).phoneNumber("+79993412347").cityOfLiving("Irkutsk").build();
        repository.save(person3);
        Person person4 = Person.builder().human(human4).phoneNumber("+79993412348").cityOfLiving("Kemerovo").build();
        repository.save(person4);
        Person person5 = Person.builder().human(human5).phoneNumber("+79993412349").cityOfLiving("Moscow").build();
        repository.save(person5);

    }

    public List<Person> getPersonsByCity(String city) {
        return repository.findByIgnoreCaseCityOfLiving(city);
    }

    public List<Person> getPersonsByAge(int age) {
        return repository.findByHumanAgeLessThanOrderByHumanAgeAsc(age);
    }

    public List<Person> getPersonsByNameSurname(String name, String surname) {
        return repository.findByHumanNameIgnoreCaseAndHumanSurnameIgnoreCase(name, surname);
    }

}

