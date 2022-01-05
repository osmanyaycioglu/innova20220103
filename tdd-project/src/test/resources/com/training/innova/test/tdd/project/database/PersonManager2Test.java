package com.training.innova.test.tdd.project.database;

import java.time.LocalDate;
import java.util.Arrays;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class PersonManager2Test {

    private static final String SURNAME_TEST_FAKE_DATA = "yay";
    PersonManager               pm;

    @Mock
    PersonDao                   mockPersonDaoLoc;

    @BeforeEach
    void setUp() throws Exception {
        Mockito.when(this.mockPersonDaoLoc.getAllPersons())
               .thenReturn(Arrays.asList(new Person().setName("osman")
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
        this.pm = new PersonManager(this.mockPersonDaoLoc);
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
    }

}
