package com.training.innova.test.tdd.project.common;


public class CalculationData {

    private Integer result;
    private Integer val1;
    private Integer val2;

    public Integer getResult() {
        return this.result;
    }

    public CalculationData setResult(final Integer resultParam) {
        this.result = resultParam;
        return this;
    }

    public Integer getVal1() {
        return this.val1;
    }

    public CalculationData setVal1(final Integer val1Param) {
        this.val1 = val1Param;
        return this;
    }

    public Integer getVal2() {
        return this.val2;
    }

    public CalculationData setVal2(final Integer val2Param) {
        this.val2 = val2Param;
        return this;
    }

    @Override
    public String toString() {
        return "CalculationData [result=" + this.result + ", val1=" + this.val1 + ", val2=" + this.val2 + "]";
    }


}
