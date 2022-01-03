package com.training.innova.test.tdd.project.calculator;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;


class CalculatorTest {

    Calculator calc;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
    }

    @BeforeEach
    void setUp() throws Exception {
        this.calc = new Calculator();
    }

    @AfterEach
    void tearDown() throws Exception {
    }

    @Test
    void add_operation() {
        Integer addLoc = this.calc.add(10,
                                       10);
        if (addLoc != 20) {
            throw new AssertionFailedError("10 , 10 toplaman sonuçu 20 olmadı");
        }
        Integer add2Loc = this.calc.add(10,
                                        20);
        if (add2Loc != 30) {
            throw new AssertionFailedError("10 , 20 toplaman sonuçu 20 olmadı");
        }
        try {
            Integer add3Loc = this.calc.add(null,
                                            20);
        } catch (IllegalArgumentException eLoc) {
        }

        try {
            Integer add4Loc = this.calc.add(10,
                                            null);
        } catch (IllegalArgumentException eLoc) {
        }

    }

    @Test
    void add_operation2() {

    }

}
