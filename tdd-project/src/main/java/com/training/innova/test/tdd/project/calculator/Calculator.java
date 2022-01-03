package com.training.innova.test.tdd.project.calculator;


public class Calculator {


    public Calculator() {
        System.out.println("Calculator yaratıldı");
    }

    public Integer add(final Integer val1,
                       final Integer val2) {
        if ((val1 == null) || (val2 == null)) {
            throw new IllegalArgumentException("val1 null olamaz");
        }
        return val1 + val2;
    }

}
