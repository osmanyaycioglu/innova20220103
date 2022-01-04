package com.training.innova.test.tdd.project.common;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_METHOD)
public class TestCase1Test {


    public TestCase1Test() {
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
    void test1() {
        System.out.println("TestCase1Test - test1");
    }

    @Test
    void test2() {
        System.out.println("TestCase1Test - test2");
    }

}
