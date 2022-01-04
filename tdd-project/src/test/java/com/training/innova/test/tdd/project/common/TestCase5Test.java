package com.training.innova.test.tdd.project.common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.training.innova.test.tdd.project.calculator.Calculator;

// @TestInstance(Lifecycle.PER_CLASS)
public class TestCase5Test {

    Calculator calc;

    @BeforeEach
    void setUp() throws Exception {
        this.calc = new Calculator();
    }

    @ParameterizedTest
    @ValueSource(ints = {
                          100,
                          2000,
                          303,
                          904,
                          72,
                          81,
                          9
    })
    void test1(final int i) {
        System.out.println(i);
    }

    @ParameterizedTest(name = "{index}---->{arguments}")
    @ValueSource(strings = {
                             "2,2,4",
                             "10,20,200"
    })
    void multiply_operation(final String datas) {
        String[] splitLoc = datas.split(",");
        int expected = Integer.parseInt(splitLoc[2]);
        int val1 = Integer.parseInt(splitLoc[0]);
        int val2 = Integer.parseInt(splitLoc[1]);
        Assertions.assertEquals(expected,
                                this.calc.multiply(val1,
                                                   val2));
    }

    @DisplayName("CsvSource test 1")
    @ParameterizedTest(name = " {index}---->{arguments}")
    @CsvSource({
                 "2,2,4",
                 "10,20,200"
    })
    void multiply_operation(final int val1,
                            final int val2,
                            final int expected) {
        Assertions.assertEquals(expected,
                                this.calc.multiply(val1,
                                                   val2));
    }

    @DisplayName("CsvSource test 2")
    @ParameterizedTest(name = " {index}---->{arguments}")
    @CsvSource({
                 "2,2,osman",
                 "10,20,mehmet"
    })
    void multiply_operation(final int val1,
                            final int val2,
                            final String name) {
        System.out.println("Val 1 : " + val1 + " Val 2 : " + val2 + " name : " + name);

    }

    @DisplayName("CsvSource test 3")
    @ParameterizedTest(name = " {index}---->{arguments}")
    @CsvSource({
                 "2,2,osman,RUN",
                 "10,20,mehmet,PAUSE"
    })
    void multiply_operation(final int val1,
                            final int val2,
                            final String name,
                            final MyState stateParam) {
        System.out.println("Val 1 : " + val1 + " Val 2 : " + val2 + " name : " + name + " state : " + stateParam);

    }

    @DisplayName("CsvSource File test 1")
    @ParameterizedTest(name = " {index}---->{arguments}")
    @CsvFileSource(delimiterString = ",", resources = "my.csv")
    void multiply_operation2(final int val1,
                             final int val2,
                             final int expected) {
        Assertions.assertEquals(expected,
                                this.calc.multiply(val1,
                                                   val2));
    }

    @DisplayName("Method source test 1")
    @ParameterizedTest(name = " {index}---->{arguments}")
    @MethodSource("provideIntegers")
    void multiply_operation_method_source(final int[] values) {
        Assertions.assertEquals(values[2],
                                this.calc.multiply(values[0],
                                                   values[1]));
    }

    static Collection<int[]> provideIntegers() {
        List<int[]> returnVal = new ArrayList<>();
        returnVal.add(new int[] {
                                  2,
                                  2,
                                  4
        });
        returnVal.add(new int[] {
                                  3,
                                  3,
                                  9
        });
        returnVal.add(new int[] {
                                  6,
                                  2,
                                  12
        });
        returnVal.add(new int[] {
                                  9,
                                  9,
                                  81
        });
        return returnVal;
    }

    @DisplayName("Method source test 2")
    @ParameterizedTest(name = " {index}---->{arguments}")
    @MethodSource("provideCalculatorData")
    void multiply_operation_method_source2(final CalculationData cd) {
        Assertions.assertEquals(cd.getResult(),
                                this.calc.multiply(cd.getVal1(),
                                                   cd.getVal2()));
    }

    static Collection<CalculationData> provideCalculatorData() {
        List<CalculationData> returnVal = new ArrayList<>();
        returnVal.add(new CalculationData().setResult(50)
                                           .setVal1(10)
                                           .setVal2(5));
        returnVal.add(new CalculationData().setResult(150)
                                           .setVal1(50)
                                           .setVal2(3));
        returnVal.add(new CalculationData().setResult(42)
                                           .setVal1(7)
                                           .setVal2(6));
        return returnVal;
    }

    @DisplayName("Agument source test 1")
    @ParameterizedTest(name = " {index}---->{arguments}")
    @ArgumentsSource(MyArg.class)
    void multiply_operation_argument_source(final CalculationData cd,
                                            final String name) {
        System.out.println("Name : " + name);
        Assertions.assertEquals(cd.getResult(),
                                this.calc.multiply(cd.getVal1(),
                                                   cd.getVal2()));
    }

    static class MyArg implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(final ExtensionContext contextParam) throws Exception {
            return Stream.of(Arguments.arguments(new CalculationData().setResult(50)
                                                                      .setVal1(10)
                                                                      .setVal2(5),
                                                 "osman"),
                             Arguments.arguments(new CalculationData().setResult(500)
                                                                      .setVal1(25)
                                                                      .setVal2(20),
                                                 "ali"));
        }
    }
}
