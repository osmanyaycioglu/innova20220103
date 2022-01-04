package com.training.innova.test.tdd.project.calculator.oo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class AbstractAritmeticCommandTest {

    AbstractAritmeticCommand<Integer> aac = new AbstractAritmeticCommand<>() {

        @Override
        Integer execute(final Integer val1Param,
                        final Integer val2Param) {
            return val1Param + val2Param;
        }


    };

    @Test
    @DisplayName("Null testleri")
    void test_null_check() {
        Assertions.assertThrows(IllegalArgumentException.class,
                                () -> this.aac.process(null,
                                                       null));
    }

}
