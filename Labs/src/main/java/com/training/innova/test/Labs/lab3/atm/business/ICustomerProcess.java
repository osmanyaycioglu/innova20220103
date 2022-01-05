package com.training.innova.test.Labs.lab3.atm.business;

import java.util.Scanner;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

import com.training.innova.test.Labs.lab3.atm.models.Customer;

public interface ICustomerProcess {

    Supplier<String> menuProvider();

    BiConsumer<Customer, Scanner> customerTask();

}
