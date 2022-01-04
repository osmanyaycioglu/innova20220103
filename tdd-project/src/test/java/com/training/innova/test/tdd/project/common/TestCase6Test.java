package com.training.innova.test.tdd.project.common;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_METHOD)
@DisplayNameGeneration(MyDisplayNameGenerator.class)
@MyGroup("group testi")
public class TestCase6Test {


    // @DisplayName("xyz ")
    // @MyGroup("group1")
    @Test
    void whenICallThis_expectSomething() {
        System.out.println("TestCase1Test - test1");
    }

    // @MyGroup("group2")
    @Test
    void whenICallThis_expectSomethingDifferent() {
        System.out.println("TestCase1Test - test2");
    }

}
