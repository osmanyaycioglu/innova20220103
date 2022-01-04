package com.training.innova.test.Labs.lab1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class CamelToSnakeCacheTest {

    CamelToSnakeCache csc;

    @BeforeEach
    void setUp() throws Exception {
        this.csc = new CamelToSnakeCache();
    }

    @Test
    @DisplayName("test1")
    void testConverCamelToSnake() {
        Assertions.assertNotEquals("hello-world",
                                   this.csc.searchHistory("helloWorld"));
        Assertions.assertEquals(null,
                                this.csc.searchHistory("helloWorld"));
        String camelToSnakeLoc = this.csc.converCamelToSnake("helloWorld");
        Assertions.assertEquals(null,
                                this.csc.searchHistory("helloworld"));
        Assertions.assertEquals("hello-world",
                                camelToSnakeLoc);
        Assertions.assertEquals(camelToSnakeLoc,
                                this.csc.searchHistory("helloWorld"));

    }

    @Test
    @DisplayName("test2")
    void testCamelToSnake() {
        Assertions.assertEquals("hello-world",
                                this.csc.camelToSnake("helloWorld"));
        Assertions.assertEquals("nil",
                                this.csc.camelToSnake(null));
        Assertions.assertEquals("",
                                this.csc.camelToSnake(""));
        Assertions.assertEquals("hello-world_ets_1",
                                this.csc.camelToSnake("helloWorld_ets_1"));
        Assertions.assertEquals("hello1-world--ets-1.op",
                                this.csc.camelToSnake("hello1World-Ets-1.op"));
        Assertions.assertEquals("öçşipğ-ömür-ğur",
                                this.csc.camelToSnake("öçşipğÖmürĞur"));
        Assertions.assertEquals("h-e-l-l-o-w-o-r-l-d",
                                this.csc.camelToSnake("HELLOWORLD"));

    }

}
