package com.training.innova.test.tdd.project.calculator;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("Hesap Makinesi -> Toplama testi")
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
    @DisplayName("Hesap Makinesi -> Çıkarma testi")
    void subs_operation() {
        Assertions.assertAll("Ana çıkartma testi : ",
                             () -> Assertions.assertEquals(0,
                                                           this.calc.subs(10,
                                                                          10)),
                             () -> Assertions.assertAll("Alt çıkarma testi",
                                                        () -> Assertions.assertEquals(80,
                                                                                      this.calc.subs(100,
                                                                                                     20)),
                                                        () -> Assertions.assertEquals(0,
                                                                                      this.calc.subs(100,
                                                                                                     100))),
                             () -> Assertions.assertEquals(-10,
                                                           this.calc.subs(10,
                                                                          20)),
                             () -> Assertions.assertThrows(IllegalArgumentException.class,
                                                           () -> this.calc.subs(10,
                                                                                null)),
                             () -> Assertions.assertThrows(IllegalArgumentException.class,
                                                           () -> this.calc.subs(null,
                                                                                null)));
    }

    @Test
    @DisplayName("Hesap Makinesi -> Çarpma testi")
    void multiply_operation() {
        Assertions.assertEquals(100,
                                this.calc.multiply(10,
                                                   10),
                                "test ettim 100 gelmeliydi geldi");
        Assertions.assertEquals(200,
                                this.calc.multiply(10,
                                                   20),
                                "test ettim 100 gelmeliydi geldi");
        Assertions.assertThrows(IllegalArgumentException.class,
                                () -> this.calc.multiply(10,
                                                         null));
        Assertions.assertThrows(IllegalArgumentException.class,
                                () -> this.calc.multiply(null,
                                                         null));

    }

    @Test
    @DisplayName("Hesap Makinesi -> Bölme testi")
    void divide_operation() {
        Assertions.assertEquals(1,
                                this.calc.divide(10,
                                                 10));
        Assertions.assertEquals(2,
                                this.calc.divide(20,
                                                 10));
        Double divideLoc = this.calc.divide(1,
                                            3);
        Assertions.assertTrue((divideLoc > 0.333333) && (divideLoc < 0.34));

        Assertions.assertThrows(IllegalArgumentException.class,
                                () -> this.calc.divide(10,
                                                       null));
        Assertions.assertThrows(IllegalArgumentException.class,
                                () -> this.calc.divide(null,
                                                       null));
        Double divideLoc2 = this.calc.divide(10,
                                             0);

        Assertions.assertTrue(Double.isInfinite(divideLoc2));
    }

}
