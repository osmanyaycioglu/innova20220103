package com.training.innova.test.tdd.project.common;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.training.innova.test.tdd.project.calculator.Calculator;

@TestInstance(Lifecycle.PER_METHOD)
public class TestCase7Test {

    Calculator calc;

    @BeforeEach
    void setUp() throws Exception {
        this.calc = new Calculator();
    }

    @TestFactory
    Stream<DynamicTest> test1() {
        return Stream.of(DynamicTest.dynamicTest("my test 1",
                                                 () -> {
                                                     Assertions.assertEquals(100,
                                                                             this.calc.multiply(20,
                                                                                                5));

                                                 }),
                         DynamicTest.dynamicTest("my test 2",
                                                 () -> {
                                                     Assertions.assertEquals(15,
                                                                             this.calc.multiply(3,
                                                                                                5));

                                                 }));
    }

    @Test
    void test2() {
        System.out.println("TestCase1Test - test2");
    }

}
