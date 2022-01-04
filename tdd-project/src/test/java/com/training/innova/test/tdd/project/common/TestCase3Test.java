package com.training.innova.test.tdd.project.common;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.ClassOrderer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestClassOrder;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;

@TestInstance(Lifecycle.PER_METHOD)
//@TestMethodOrder(MethodOrderer.DisplayName.class)
@TestMethodOrder(MethodOrderer.MethodName.class)
//@TestMethodOrder(OrderAnnotation.class)
@TestClassOrder(ClassOrderer.DisplayName.class)
public class TestCase3Test {


    public TestCase3Test() {
        System.out.println("TestCase1Test - Constructor");
    }

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        System.out.println("TestCase1Test - BeforeAll");
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
        System.out.println("TestCase1Test - AfterAll");
    }

    @BeforeEach
    void setUp() throws Exception {
        System.out.println("TestCase1Test - BeforeEach");
    }

    @AfterEach
    void tearDown() throws Exception {
        System.out.println("TestCase1Test - AfterEach");
    }

    @Test
    @DisplayName("my test 1")
    @Order(2)
    void test1() {
        System.out.println("TestCase1Test - test1");
    }

    @Test
    @DisplayName("my test 2")
    @Order(1)
    void test2() {
        System.out.println("TestCase1Test - test2");
    }

}
