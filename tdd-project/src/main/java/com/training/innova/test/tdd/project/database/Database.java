package com.training.innova.test.tdd.project.database;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Database {

    // Db Connection pool
    //
    public List<Person> getPersonBySQL(final String sql) {
        // Statement
        // Resultset
        return Arrays.asList(new Person().setName("osman")
                                         .setSurname("yaycıoğlu")
                                         .setWeight(105)
                                         .setBirthdate(LocalDate.of(1970,
                                                                    9,
                                                                    11)),
                             new Person().setName("ali")
                                         .setSurname("veli")
                                         .setWeight(90)
                                         .setBirthdate(LocalDate.of(2001,
                                                                    8,
                                                                    11)));
    }


}
