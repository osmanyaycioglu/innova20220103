package com.training.innova.test.tdd.project.calculator.oo;


public interface IAritmeticCommand<T> {

    T process(Integer val1,
              Integer val2);

}
