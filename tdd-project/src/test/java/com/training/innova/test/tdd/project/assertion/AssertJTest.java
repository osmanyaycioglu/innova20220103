package com.training.innova.test.tdd.project.assertion;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

import com.training.innova.test.common.Person;

public class AssertJTest {

    private final Condition<Person> fatPerson = new Condition<>(p -> p.getWeight() > 100,
                                                                "fat person");
    private final Condition<Person> oldPerson = new Condition<>(p -> p.getBirthdate()
                                                                      .isBefore(LocalDate.of(2000,
                                                                                             1,
                                                                                             1)),
                                                                "old person");


    @Test
    void test1() {
        assertThat("osman").isEqualTo("osman")
                           .contains("os")
                           .containsSubsequence("man")
                           .containsAnyOf("os",
                                          "mos")
                           .endsWith("n")
                           .startsWith("os");

        String str1 = "osman";
        String str2 = "osman";
        assertThat(str1 == str2).isEqualTo(true);

        Person person1 = new Person().setName("osman")
                                     .setSurname("yaycıoğlu")
                                     .setWeight(105)
                                     .setBirthdate(LocalDate.of(1970,
                                                                9,
                                                                11));
        Person person2 = new Person().setName("osman")
                                     .setSurname("yaycıoğlu")
                                     .setWeight(95)
                                     .setBirthdate(LocalDate.of(1970,
                                                                9,
                                                                11));

        assertThat(person1).isNotEqualTo(person2);
        assertThat(person1).is(this.fatPerson)
                           .is(this.oldPerson);
        //assertThat(person1 == person2).isEqualTo(true);

        List<String> asListLoc = Arrays.asList("osman",
                                               "mehmet",
                                               "ali");
        assertThat(asListLoc).as("List testleri 1")
                             .contains("osman")
                             .contains("ali")
                             .startsWith("osman")
                             .doesNotContain("ayşe")
                             .doesNotContainNull();

        Assertions.assertThatThrownBy(() -> exceptionTest())
                  .isInstanceOf(IllegalArgumentException.class)
                  .hasMessageContaining("ex1")
                  .hasMessageStartingWith("test")
                  .hasMessageEndingWith("ex1");


    }

    public static String exceptionTest() {
        throw new IllegalArgumentException("test message ex1");
    }

}
