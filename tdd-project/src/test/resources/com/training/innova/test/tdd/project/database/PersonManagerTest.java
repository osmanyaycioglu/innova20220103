package com.training.innova.test.tdd.project.database;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class PersonManagerTest {

    private static final String SURNAME_TEST_FAKE_DATA = "yay";
    PersonManager               pm;

    static class PersonDaoProxy extends PersonDao {

        @Override
        public List<Person> getAllPersons() {
            return Arrays.asList(new Person().setName("osman")
                                             .setSurname("yaycıoğlu")
                                             .setWeight(90)
                                             .setBirthdate(LocalDate.of(1970,
                                                                        9,
                                                                        11)),
                                 new Person().setName("ali")
                                             .setSurname("veli")
                                             .setWeight(105)
                                             .setBirthdate(LocalDate.of(2001,
                                                                        8,
                                                                        11)));
        }

        @Override
        public List<Person> getPersonsBySurname(final String surnameParam) {
            return Arrays.asList(new Person().setName("osman")
                                             .setSurname(surnameParam)
                                             .setWeight(90)
                                             .setBirthdate(LocalDate.of(1970,
                                                                        9,
                                                                        11)),
                                 new Person().setName("ali")
                                             .setSurname(surnameParam)
                                             .setWeight(105)
                                             .setBirthdate(LocalDate.of(2001,
                                                                        8,
                                                                        11)));
        }
    }

    static class PersonDaoDelegate extends PersonDao {


        private final PersonDao personDao;

        public PersonDaoDelegate(final PersonDao personDaoParam) {
            this.personDao = personDaoParam;
        }


        @Override
        public List<Person> getAllPersons() {
            List<Person> allPersonsLoc = this.personDao.getAllPersons();
            allPersonsLoc.addAll(Arrays.asList(new Person().setName("osman")
                                                           .setSurname("yaycıoğlu")
                                                           .setWeight(90)
                                                           .setBirthdate(LocalDate.of(1970,
                                                                                      9,
                                                                                      11)),
                                               new Person().setName("ali")
                                                           .setSurname("veli")
                                                           .setWeight(105)
                                                           .setBirthdate(LocalDate.of(2001,
                                                                                      8,
                                                                                      11))));
            return allPersonsLoc;
        }

        @Override
        public List<Person> getPersonsBySurname(final String surnameParam) {
            return this.personDao.getPersonsBySurname(surnameParam);
        }
    }

    @BeforeEach
    void setUp() throws Exception {
        this.pm = new PersonManager(new PersonDaoProxy());
    }

    @Test
    void testFilterPersonsByWeight() {
        Assertions.assertThat(this.pm.filterPersonsByWeight(100))
                  .contains(new Person().setName("osman")
                                        .setSurname("yaycıoğlu")
                                        .setWeight(90)
                                        .setBirthdate(LocalDate.of(1970,
                                                                   9,
                                                                   11)));
        Assertions.assertThat(this.pm.filterPersonsBySurnameAndWeight(100,
                                                                      PersonManagerTest.SURNAME_TEST_FAKE_DATA))
                  .contains(new Person().setName("osman")
                                        .setSurname(PersonManagerTest.SURNAME_TEST_FAKE_DATA)
                                        .setWeight(90)
                                        .setBirthdate(LocalDate.of(1970,
                                                                   9,
                                                                   11)));
    }

}
