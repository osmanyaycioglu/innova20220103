package com.training.innova.test.Labs.lab3.atm.common;

import java.util.List;

public class OutputSourceImpl implements IOutputSource {

    @Override
    public void writeLine(final String strParam) {
        System.out.println(strParam);
    }

    @Override
    public void writeLines(final List<String> strParam) {
        for (String stringLoc : strParam) {
            System.out.println(stringLoc);
        }
    }

}
