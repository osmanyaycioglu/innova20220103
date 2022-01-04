package com.training.innova.test.tdd.project.assertion;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class AssertJTest {

    @Test
    void test1() {
        assertThat("osman").isEqualTo("osman")
                           .contains("os")
                           .containsSubsequence("man")
                           .containsAnyOf("os",
                                          "mos")
                           .endsWith("n")
                           .startsWith("os");

    }

}
