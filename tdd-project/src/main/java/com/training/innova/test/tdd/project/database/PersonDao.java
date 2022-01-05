package com.training.innova.test.tdd.project.database;

import java.util.List;

public class PersonDao {

    private final Database database = new Database();

    public List<Person> getAllPersons() {
        return this.database.getPersonBySQL("select * from Person");
    }

    public List<Person> getPersonsBySurname(final String surname) {
        return this.database.getPersonBySQL("select * from Person where surname=?");
    }

}
