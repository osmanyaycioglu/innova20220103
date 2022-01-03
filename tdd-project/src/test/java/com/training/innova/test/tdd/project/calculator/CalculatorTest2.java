package com.training.innova.test.tdd.project.calculator;

import java.util.Random;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.opentest4j.AssertionFailedError;

import com.training.innova.test.common.AllTestOnWindows;
import com.training.innova.test.common.BasicTestOnWindows;

class CalculatorTest2 {

    Calculator calc;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        //        System.getProperties()
        //              .setProperty("my.sys.prop.enable.test",
        //                           "true");

    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
    }

    @BeforeEach
    void setUp(final TestInfo testInfoParam) throws Exception {
        System.out.println("about to run" + testInfoParam.getDisplayName() + " tags : " + testInfoParam.getTags());
        this.calc = new Calculator();
    }

    @AfterEach
    void tearDown() throws Exception {
    }

    @Nested
    @DisplayName("Hesap Makinesi -> Toplama testi")
    class ToplamaTestleri {


        @AllTestOnWindows
        @DisplayName("Bütün testler aynı yerde")
        void add_operation() {
            Integer addLoc = CalculatorTest2.this.calc.add(10,
                                                           10);
            if (addLoc != 20) {
                throw new AssertionFailedError("10 , 10 toplaman sonuçu 20 olmadı");
            }
            Integer add2Loc = CalculatorTest2.this.calc.add(10,
                                                            20);
            if (add2Loc != 30) {
                throw new AssertionFailedError("10 , 20 toplaman sonuçu 20 olmadı");
            }
            try {
                Integer add3Loc = CalculatorTest2.this.calc.add(null,
                                                                20);
            } catch (IllegalArgumentException eLoc) {
            }

            try {
                Integer add4Loc = CalculatorTest2.this.calc.add(10,
                                                                null);
            } catch (IllegalArgumentException eLoc) {
            }

        }

        boolean checkIfDisabled() {
            Random randomLoc = new Random();
            int nextIntLoc = randomLoc.nextInt(10);
            System.out.println("random : " + nextIntLoc);
            return nextIntLoc > 5;
        }

        @BasicTestOnWindows
        @DisplayName("temel testler")
        // @DisabledOnOs(OS.WINDOWS)
        // @DisabledForJreRange(max = JRE.JAVA_12, min = JRE.JAVA_8)
        // @EnabledForJreRange(max = JRE.JAVA_12, min = JRE.JAVA_8)
        void add_operation_basic_test() {
            Integer addLoc = CalculatorTest2.this.calc.add(10,
                                                           10);
            if (addLoc != 20) {
                throw new AssertionFailedError("10 , 10 toplaman sonuçu 20 olmadı");
            }
            Integer add2Loc = CalculatorTest2.this.calc.add(10,
                                                            20);
            if (add2Loc != 30) {
                throw new AssertionFailedError("10 , 20 toplaman sonuçu 20 olmadı");
            }

        }

        @Test
        @DisplayName("Null testleri")
        void add_operation_given_null_test(final TestInfo testInfoParam) {
            System.out.println("Running add_operation_given_null_test : "
                               + testInfoParam.getDisplayName()
                               + " tags : "
                               + testInfoParam.getTags());
            try {
                Integer add3Loc = CalculatorTest2.this.calc.add(null,
                                                                20);
            } catch (IllegalArgumentException eLoc) {
            }

            try {
                Integer add4Loc = CalculatorTest2.this.calc.add(10,
                                                                null);
            } catch (IllegalArgumentException eLoc) {
            }

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

    @Nested
    @DisplayName("Hesap Makinesi -> Çarpma testi")
    class MultiplyTests {

        @Test
        @DisplayName("Bütün testler")
        @Disabled("Bug 101 den dolayı disable edildi")
        void multiply_operation() {
            Assertions.assertEquals(100,
                                    CalculatorTest2.this.calc.multiply(10,
                                                                       10),
                                    "test ettim 100 gelmeliydi geldi");
            Assertions.assertEquals(200,
                                    CalculatorTest2.this.calc.multiply(10,
                                                                       20),
                                    "test ettim 100 gelmeliydi geldi");
            Assertions.assertThrows(IllegalArgumentException.class,
                                    () -> CalculatorTest2.this.calc.multiply(10,
                                                                             null));
            Assertions.assertThrows(IllegalArgumentException.class,
                                    () -> CalculatorTest2.this.calc.multiply(null,
                                                                             null));
        }

        @Test
        @DisplayName("Temel testler")
        void multiply_basic_tests() {
            Assertions.assertEquals(100,
                                    CalculatorTest2.this.calc.multiply(10,
                                                                       10),
                                    "test ettim 100 gelmeliydi geldi");
            Assertions.assertEquals(200,
                                    CalculatorTest2.this.calc.multiply(10,
                                                                       20),
                                    "test ettim 100 gelmeliydi geldi");
        }

        @Test
        @DisplayName("Null testleri")
        void multiply_given_null_tests() {
            Assertions.assertThrows(IllegalArgumentException.class,
                                    () -> CalculatorTest2.this.calc.multiply(10,
                                                                             null));
            Assertions.assertThrows(IllegalArgumentException.class,
                                    () -> CalculatorTest2.this.calc.multiply(null,
                                                                             null));
        }
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
