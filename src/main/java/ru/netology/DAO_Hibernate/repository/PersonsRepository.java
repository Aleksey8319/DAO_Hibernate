package ru.netology.DAO_Hibernate.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.netology.DAO_Hibernate.entity.Human;
import ru.netology.DAO_Hibernate.entity.Person;

import java.util.List;


@Repository
public interface PersonsRepository extends JpaRepository<Person, Human> {
    List<Person> findByIgnoreCaseCityOfLiving(String city);

    List<Person> findByHumanAgeLessThanOrderByHumanAgeAsc(int humanAge);

    List<Person> findByHumanNameIgnoreCaseAndHumanSurnameIgnoreCase(String humanName, String humanSurname);
}

