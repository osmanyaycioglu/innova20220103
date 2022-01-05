package com.training.innova.test.Labs.lab3.atm.business;

import java.util.Scanner;

import com.training.innova.test.Labs.lab3.atm.models.Customer;

@FunctionalInterface
public interface ICustomerTask {

    void execute(Customer customerParam,
                 Scanner scannerParam);
}
