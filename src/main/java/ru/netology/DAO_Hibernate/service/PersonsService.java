package ru.netology.DAO_Hibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.netology.DAO_Hibernate.entity.Person;
import ru.netology.DAO_Hibernate.repository.PersonsRepository;

import java.util.List;

@Service
public class PersonsService {
    private final PersonsRepository personsRepository;

    @Autowired
    public PersonsService(PersonsRepository personsRepository) {
        this.personsRepository = personsRepository;
        personsRepository.repositoryInit();
    }

    public List<Person> getPersonsByCity(String city) {
        return personsRepository.getPersonsByCity(city);
    }
}
