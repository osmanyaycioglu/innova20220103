package com.training.innova.test.tdd.project.calculator.oo;


public class AddCommand extends AbstractAritmeticCommand<Integer> {

    @Override
    Integer execute(final Integer val1Param,
                    final Integer val2Param) {
        return val1Param + val2Param;
    }

}
