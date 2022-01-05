package com.training.innova.test.Labs.lab3.atm.common;

import java.util.Scanner;

public class InputSourceImpl implements IInputSource {

    private final Scanner scanner;


    public InputSourceImpl(final Scanner scannerParam) {
        super();
        this.scanner = scannerParam;
    }

    @Override
    public Integer nextInt() {
        return this.scanner.nextInt();
    }

    @Override
    public String nextString() {
        return this.scanner.nextLine();
    }

}
