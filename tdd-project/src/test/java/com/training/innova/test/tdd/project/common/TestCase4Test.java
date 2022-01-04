package com.training.innova.test.tdd.project.common;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

import com.training.innova.test.tdd.project.calculator.Calculator;

// @TestInstance(Lifecycle.PER_CLASS)
public class TestCase4Test {

    private final Integer[][] dataset = new Integer[][] {
                                                          {
                                                            10,
                                                            10,
                                                            100
                                                          },
                                                          {
                                                            20,
                                                            20,
                                                            400
                                                          },
                                                          {
                                                            3,
                                                            5,
                                                            15
                                                          }
    };

    Calculator                calc;

    @BeforeEach
    void setUp() throws Exception {
        this.calc = new Calculator();
    }

    @RepeatedTest(3)
    @DisplayName("Hesap Makinesi -> Çarpma testi")
    void multiply_operation(final RepetitionInfo repetitionInfo) {
        int currentRepetitionLoc = repetitionInfo.getCurrentRepetition();
        System.out.println("Current : " + currentRepetitionLoc);
        Integer[] datas = this.dataset[currentRepetitionLoc - 1];
        Assertions.assertEquals(datas[2],
                                this.calc.multiply(datas[0],
                                                   datas[1]));

    }

}
