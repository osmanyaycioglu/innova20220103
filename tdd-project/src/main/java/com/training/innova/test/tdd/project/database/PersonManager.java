package com.training.innova.test.tdd.project.database;

import java.util.ArrayList;
import java.util.List;

public class PersonManager {

    private final PersonDao personDao;

    public PersonManager(final PersonDao personDaoParam) {
        super();
        this.personDao = personDaoParam;
    }


    public List<Person> filterPersonsByWeight(final int maxWeight) {
        List<Person> allPersonsLoc = this.personDao.getAllPersons();
        List<Person> result = new ArrayList<>();
        for (Person personLoc : allPersonsLoc) {
            if (personLoc.getWeight() < maxWeight) {
                result.add(personLoc);
            }
        }
        return result;
    }

    public List<Person> filterPersonsBySurnameAndWeight(final int maxWeight,
                                                        final String surname) {
        List<Person> allPersonsLoc = this.personDao.getPersonsBySurname(surname);
        List<Person> result = new ArrayList<>();
        for (Person personLoc : allPersonsLoc) {
            if (personLoc.getWeight() < maxWeight) {
                result.add(personLoc);
            }
        }
        return result;
    }

}
