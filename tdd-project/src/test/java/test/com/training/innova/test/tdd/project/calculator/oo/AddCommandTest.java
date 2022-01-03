package test.com.training.innova.test.tdd.project.calculator.oo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.training.innova.test.tdd.project.calculator.oo.AddCommand;


class AddCommandTest {

    AddCommand ac;

    @BeforeEach
    void setUp() throws Exception {
        this.ac = new AddCommand();
    }

    @Test
    @DisplayName("Toplama testi ---> Temel tesler")
    void add_basic_Test() {
        Assertions.assertEquals(20,
                                this.ac.process(10,
                                                10));
        Assertions.assertEquals(30,
                                this.ac.process(20,
                                                10));

    }

    @Test
    @DisplayName("Toplama testi ---> Null testleri")
    void add_null_tests() {
        Assertions.assertThrows(IllegalArgumentException.class,
                                () -> this.ac.process(10,
                                                      null));
        Assertions.assertThrows(IllegalArgumentException.class,
                                () -> this.ac.process(null,
                                                      null));

    }

}
