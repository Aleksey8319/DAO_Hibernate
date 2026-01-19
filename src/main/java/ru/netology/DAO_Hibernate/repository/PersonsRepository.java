package ru.netology.DAO_Hibernate.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.netology.DAO_Hibernate.entity.Human;
import ru.netology.DAO_Hibernate.entity.Person;

import java.util.List;


@Repository
public class PersonsRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public void repositoryInit() {

        Human human1 = Human.builder().name("alexey").surname("Bogomolov").age(44).build();
        Human human2 = Human.builder().name("Alexey").surname("Orlov").age(45).build();
        Human human3 = Human.builder().name("ALEXEY").surname("Mirin").age(44).build();
        Human human4 = Human.builder().name("Vasiliy").surname("Stepanov").age(58).build();
        Human human5 = Human.builder().name("Vasiliy").surname("Utkin").age(52).build();

        Person person1 = Person.builder().human(human1).phoneNumber("+79993412345").cityOfLeaving("Samara").build();
        entityManager.persist(person1);
        Person person2 = Person.builder().human(human2).phoneNumber("+79993412346").cityOfLeaving("Moscow").build();
        entityManager.persist(person2);
        Person person3 = Person.builder().human(human3).phoneNumber("+79993412347").cityOfLeaving("Irkutsk").build();
        entityManager.persist(person3);
        Person person4 = Person.builder().human(human4).phoneNumber("+79993412348").cityOfLeaving("Kemerovo").build();
        entityManager.persist(person4);
        Person person5 = Person.builder().human(human5).phoneNumber("+79993412349").cityOfLeaving("Moscow").build();
        entityManager.persist(person5);

        System.out.println("repositoryInit done");
    }

    public List<Person> getPersonsByCity(String city) {
        List<Person> persons = entityManager.createQuery("SELECT e FROM Person e").getResultList();
        List<Person> filteredPersons = persons.stream().filter(p -> p.getCityOfLeaving().toLowerCase().equals(city.toLowerCase())).toList();
        return filteredPersons;
    }
}
