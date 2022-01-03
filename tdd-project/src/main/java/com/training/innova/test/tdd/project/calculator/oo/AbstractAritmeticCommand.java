package com.training.innova.test.tdd.project.calculator.oo;


public abstract class AbstractAritmeticCommand<T> implements IAritmeticCommand<T> {

    @Override
    public T process(final Integer val1Param,
                     final Integer val2Param) {
        if ((val1Param == null) || (val2Param == null)) {
            throw new IllegalArgumentException("val1,val2 null olamaz");
        }
        return this.execute(val1Param,
                            val2Param);
    }

    abstract T execute(final Integer val1Param,
                       final Integer val2Param);

}
